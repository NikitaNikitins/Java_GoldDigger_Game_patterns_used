package game.objects;

import game.abstracts.AbstractGameObject;
import game.abstracts.AbstractMovingObject;
import game.enums.ActionResult;
import game.enums.GameObjectType;
import game.enums.MovingDirection;

public class Monster extends AbstractMovingObject {

    public Monster(Coordinate coordinate) {
        super.setType(GameObjectType.MONSTER);
        super.setCoordinate(coordinate);

        super.setIcon(getImageIcon("/game/images/monster_up.jpg"));

    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/game/images/monster_down.jpg"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/game/images/monster_right.jpg"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/game/images/monster_right.jpg"));
                break;
            case UP:
                super.setIcon(getImageIcon("/game/images/monster_up.jpg"));
                break;
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        switch (gameObject.getType()) {


            case TREASURE:
            case MONSTER: {
                return ActionResult.NO_ACTION;
            }

            case GOLDMAN: {
                return ActionResult.DIE;
            }

        }

        return super.doAction(gameObject);
    }
}