package game.objects;

import game.abstracts.AbstractGameObject;
import game.abstracts.AbstractMovingObject;
import game.enums.ActionResult;
import game.enums.GameObjectType;
import game.enums.MovingDirection;

public class GoldMan extends AbstractMovingObject {

    private int totalScore = 0;
    private int turnsNumber = 0;

    public GoldMan(Coordinate coordinate) {
        super.setType(GameObjectType.GOLDMAN);
        super.setCoordinate(coordinate);
        super.setIcon(getImageIcon("/game/images/goldman_up.png"));
    }

    public void addSTotalcore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public int getTurnsNumber() {
        return turnsNumber;
    }

    public void setTurnsNumber(int turnsNumber) {
        this.turnsNumber = turnsNumber;
    }

    @Override
    public void changeIcon(MovingDirection direction) {
        switch (direction) {
            case DOWN:
                super.setIcon(getImageIcon("/game/images/goldman_down.png"));
                break;
            case LEFT:
                super.setIcon(getImageIcon("/game/images/goldman_left.png"));
                break;
            case RIGHT:
                super.setIcon(getImageIcon("/game/images/goldman_right.png"));
                break;
            case UP:
                super.setIcon(getImageIcon("/game/images/goldman_up.png"));
                break;
        }
    }

    @Override
    public ActionResult doAction(AbstractGameObject gameObject) {

        turnsNumber++;

        switch (gameObject.getType()) {

            case TREASURE: {
                totalScore += ((Treasure) gameObject).getScore();
                return ActionResult.COLLECT_TREASURE;
            }

            case MONSTER:  {
                return ActionResult.DIE;
            }
                
            case EXIT:{
                totalScore *= 2;
                return ActionResult.WIN;
            }
                
        }

        return super.doAction(gameObject);
    }
}

