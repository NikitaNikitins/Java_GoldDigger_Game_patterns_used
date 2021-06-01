package game.interfaces.gamemap.collections;

import java.util.*;

import game.abstracts.AbstractGameObject;
import game.enums.GameObjectType;
import game.enums.MovingDirection;
import game.movestrategies.MoveStrategy;
import game.objects.Coordinate;
import game.objects.listeners.MoveResultNotifier;

public interface GameCollection extends MoveResultNotifier{
    
    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);
    
    AbstractGameObject getObjectByCoordinate(int x, int y);
    
    void addGameObject(AbstractGameObject gameObject);
    
    List<AbstractGameObject> getAllGameObjects();
    
    List<AbstractGameObject> getGameObjects(GameObjectType type);
    
    void moveObject(MovingDirection direction, GameObjectType gameObjectType);
    
    void moveObject(MoveStrategy moveStrategy, GameObjectType gameObjectType);

}
