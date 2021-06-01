package game.movestrategies;

import game.abstracts.AbstractGameObject;
import game.abstracts.AbstractMovingObject;
import game.enums.MovingDirection;
import game.interfaces.gamemap.collections.GameCollection;

public interface MoveStrategy {
    
    MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection);
    
}
