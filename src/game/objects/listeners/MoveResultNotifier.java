package game.objects.listeners;

import java.util.List;

import game.enums.ActionResult;
import game.objects.GoldMan;

public interface MoveResultNotifier {
    
    List<MoveResultListener> getMoveListeners();

    void addMoveListener(MoveResultListener listener);

    public void removeMoveListener(MoveResultListener listener);

    public void removeAllLMoveisteners();

    public void notifyMoveListeners(ActionResult actionResult, GoldMan goldMan);

}
