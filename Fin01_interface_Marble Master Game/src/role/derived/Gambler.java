package role.derived;

import game.logic.GameAction;
import game.object.GameObject;
import game.object.Player;
import role.base.PreRoundActable;
import role.base.PreTurnActable;
import role.base.Role;

public class Gambler extends Role implements PreRoundActable, PreTurnActable {

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Gambler";
	}

	@Override
	public void preRoundActs(GameAction action) {
		// TODO Auto-generated method stub
		int t=0;
		for(GameObject tmp : action.getInfo()) {
			((Player) tmp).setOrder(t++);
		}
		
	}

	@Override
	public void preTurnActs(GameAction action) {
		// TODO Auto-generated method stub
		
		for(GameObject tmp : action.getInfo()) {
			((Player) tmp).setToBeSwapped(true);
		}
	}
	
	
	
	

}
