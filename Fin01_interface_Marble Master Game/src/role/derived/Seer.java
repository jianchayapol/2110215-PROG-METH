package role.derived;

import java.util.ArrayList;

import game.logic.GameAction;
import game.logic.GameLogic;
import game.object.Card;
import game.object.GameObject;
import game.object.Player;
import role.base.PreTurnActable;
import role.base.Role;

public class Seer extends Role implements PreTurnActable{

	@Override
	public void preTurnActs(GameAction action) {
		// TODO Auto-generated method stub
		
		ArrayList<GameObject> info = action.getInfo();
		
		for(int i=0; i<info.size()-1; i++) {
			GameLogic.getInstance().getCurrentRound().swapCards((Card) (info.get(i)),(Card)info.get(i+1));
			
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Seer";
	}

}
