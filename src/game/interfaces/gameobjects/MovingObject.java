package game.interfaces.gameobjects;

import game.abstracts.AbstractGameObject;
import game.enums.ActionResult;
import game.enums.MovingDirection;

public interface MovingObject extends StaticObject{
    
    ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject); 
    
    int getStep();
       
}