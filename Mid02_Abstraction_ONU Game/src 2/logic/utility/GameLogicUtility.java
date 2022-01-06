package logic.utility;

import java.util.ArrayList;

import logic.card.BaseCard;
import logic.game.GameLogic;

public class GameLogicUtility {
	
	public static boolean drawRule() {
		ArrayList<BaseCard> hand = GameLogic.getInstance().getHand();
		for(BaseCard c : hand) {
			if(c.ruleCheck()) return false;
		}
		return true;
	}
	
}
