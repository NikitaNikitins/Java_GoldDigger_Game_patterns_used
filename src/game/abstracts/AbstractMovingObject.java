package game.abstracts;

import game.enums.ActionResult;
import game.enums.MovingDirection;
import game.interfaces.gameobjects.MovingObject;
import game.objects.Coordinate;

//abildiiga klase par objektu, kas var paarvietotes
public abstract class AbstractMovingObject extends AbstractGameObject implements MovingObject {

    public abstract void changeIcon(MovingDirection direction);
    private int step = 1;// default step is 1

    @Override
    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    protected void actionBeforeMove(MovingDirection direction) {

        // paarvietojoties objektam vajag mainiit bildit un implementeet skaanu
        changeIcon(direction);
//        playSound();

    }

    @Override
    public ActionResult moveToObject(MovingDirection direction, AbstractGameObject gameObject) {
        actionBeforeMove(direction);
        return doAction(gameObject);
    }

    public ActionResult doAction(AbstractGameObject gameObject) {

        if (gameObject == null) { // kartes robeza
            return ActionResult.NO_ACTION;
        }

        switch (gameObject.getType()) {

            case NOTHING: {
                return ActionResult.MOVE;
            }

            case WALL: {// default: objekts nevar parvietotites cauri sienai
                return ActionResult.NO_ACTION;
            }
        }

        return ActionResult.NO_ACTION;
    }

    public Coordinate getDirectionCoordinate(MovingDirection direction) {

        int x = this.getCoordinate().getX();
        int y = this.getCoordinate().getY();


        Coordinate newCoordinate = new Coordinate(x, y);


        switch (direction) {// kuraa pusee kusteeties?
            case UP: {
                newCoordinate.setY(y - this.getStep());
                break;
            }
            case DOWN: {
                newCoordinate.setY(y + this.getStep());
                break;
            }
            case LEFT: {
                newCoordinate.setX(x - this.getStep());
                break;
            }
            case RIGHT: {
                newCoordinate.setX(x + this.getStep());
                break;
            }
        }

        return newCoordinate;


    }
}
