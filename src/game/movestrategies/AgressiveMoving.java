package game.movestrategies;

import java.util.Random;

import game.abstracts.AbstractGameObject;
import game.abstracts.AbstractMovingObject;
import game.enums.ActionResult;
import game.enums.MovingDirection;
import game.interfaces.gamemap.collections.GameCollection;

public class AgressiveMoving implements MoveStrategy {

    private MovingDirection[] directions = MovingDirection.values();
    private AbstractMovingObject movingObject;
    private GameCollection gameCollection;

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection) {

        this.movingObject = movingObject;
        this.gameCollection = gameCollection;

        // vispirms mees paskataamies apkaart, vai ir iespeejams apeest speeleetaaju
        MovingDirection direction = searchAction(ActionResult.DIE, false);

        // ja tuvumaa nav speeleetaaja - vienkaarsi paarvietojieties nejausaa virzienaa
        if (direction == null) {
            direction = searchAction(ActionResult.MOVE, true);
        }

        return direction;
    }

    private MovingDirection getRandomDirection() {
        return directions[new Random().nextInt(directions.length)];
    }

    private MovingDirection searchAction(ActionResult actionResult, boolean random) {
        MovingDirection direction = null;

        if (random) {
            do {
                direction = getRandomDirection();
            } while (!checkActionResult(actionResult, direction));// nejausi izveelieties pusi, liidz atrodam pareizo ActionResult
        }else{
            for (MovingDirection movingDirection : directions) {// mekleet visaas 4 pusees
                if (checkActionResult(actionResult, movingDirection)){
                    direction = movingDirection;
                    break;
                }
            }
        }

        return direction;
    }
    
    private boolean checkActionResult(ActionResult actionResult, MovingDirection direction){
        AbstractGameObject objectInNewCoordinate = gameCollection.getObjectByCoordinate(movingObject.getDirectionCoordinate(direction));     
        return movingObject.doAction(objectInNewCoordinate).equals(actionResult);
    }
}
