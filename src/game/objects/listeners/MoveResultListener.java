package game.objects.listeners;

import game.enums.ActionResult;
import game.objects.GoldMan;

public interface MoveResultListener {
    
    public void notifyActionResult(ActionResult actionResult, GoldMan goldMan);

}
