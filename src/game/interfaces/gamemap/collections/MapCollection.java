package game.interfaces.gamemap.collections;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import game.abstracts.AbstractGameObject;
import game.abstracts.AbstractMovingObject;
import game.enums.ActionResult;
import game.enums.GameObjectType;
import game.enums.MovingDirection;
import game.movestrategies.MoveStrategy;
import game.objects.Coordinate;
import game.objects.GoldMan;
import game.objects.Nothing;
import game.objects.Wall;
import game.objects.listeners.MapListenersRegistrator;
import game.objects.listeners.MoveResultListener;

public class MapCollection extends MapListenersRegistrator {// kartes objekti, kas var pazinot klausiitajiem par saviem paarvietojumiem

    private HashMap<Coordinate, AbstractGameObject> gameObjects = new HashMap<>();// saglabaa visus objektus ar koordinaatem
    private EnumMap<GameObjectType, ArrayList<AbstractGameObject>> typeObjects = new EnumMap<>(GameObjectType.class); // saglabaa katra tipa objektus 

    @Override
    public List<AbstractGameObject> getAllGameObjects() {
        return new ArrayList(gameObjects.values());// ! katru reizi jauna kollekcija
    }

    @Override
    public List<AbstractGameObject> getGameObjects(GameObjectType type) {
        return typeObjects.get(type);
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        AbstractGameObject gameObject = gameObjects.get(coordinate);
        if (gameObject == null){// kartes robeeza
            gameObject = new Wall(coordinate);
        }
        return gameObject;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(int x, int y) {
        return gameObjects.get(new Coordinate(x, y));
    }

    @Override
    public void addGameObject(AbstractGameObject gameObject) {

        ArrayList<AbstractGameObject> tmpList = typeObjects.get(gameObject.getType());

        if (tmpList == null) {
            tmpList = new ArrayList<>();
        }

        tmpList.add(gameObject);

        gameObjects.put(gameObject.getCoordinate(), gameObject);
        typeObjects.put(gameObject.getType(), tmpList);

    }

    @Override
    public void moveObject(MovingDirection direction, GameObjectType gameObjectType) {
        doMoveAction(direction, gameObjectType, null);// paarvietosana bez strategijas
    }
    
    
    @Override
    public void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType) {
        doMoveAction(null, gameObjectType, moveStrategy);// paarvietosana ar strateegiju
    }
    
    private void doMoveAction(MovingDirection direction, GameObjectType gameObjectType, MoveStrategy moveStrategy){
          GoldMan goldMan = (GoldMan) getGameObjects(GameObjectType.GOLDMAN).get(0);

        ActionResult actionResult = null;

        for (AbstractGameObject gameObject : this.getGameObjects(gameObjectType)) {
            if (gameObject instanceof AbstractMovingObject) {// dargaa darbiiba instanceof
                AbstractMovingObject movingObject = (AbstractMovingObject) gameObject;
                        
                if (moveStrategy!=null){
                    direction = moveStrategy.getDirection(movingObject, goldMan, this);
                }

                Coordinate newCoordinate = movingObject.getDirectionCoordinate(direction);

                AbstractGameObject objectInNewCoordinate = getObjectByCoordinate(newCoordinate);
                
                actionResult = movingObject.moveToObject(direction, objectInNewCoordinate);

                switch (actionResult) {
                    case MOVE: {
                        swapObjects(movingObject, objectInNewCoordinate);
                        break;
                    }
                    case COLLECT_TREASURE: {
                        swapObjects(movingObject, new Nothing(newCoordinate));
                        break;
                    }

                    case WIN:
                    case DIE: {
                        break;
                    }

                }

            }

            notifyMoveListeners(actionResult, goldMan);
        }
    }

    private void swapObjects(AbstractGameObject obj1, AbstractGameObject obj2) {

        swapCoordinates(obj1, obj2);

        gameObjects.put(obj1.getCoordinate(), obj1);
        gameObjects.put(obj2.getCoordinate(), obj2);

    }

    private void swapCoordinates(AbstractGameObject obj1, AbstractGameObject obj2) {
        Coordinate tmpCoordinate = obj1.getCoordinate();
        obj1.setCoordinate(obj2.getCoordinate());
        obj2.setCoordinate(tmpCoordinate);
    }

  
    

    

    @Override
    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan) {
        for (MoveResultListener listener : getMoveListeners()) {
            listener.notifyActionResult(actionResult, goldMan);
        }
    }
    

    
}
