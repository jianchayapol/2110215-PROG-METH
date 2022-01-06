package card.cards;

import card.base.ItemCard;
import player.Player;

//You CAN modify the first line
public class ExodiaPartCard extends ItemCard {
	
	
	public ExodiaPartCard(String name, int defense) {
		super(name,"Assemble 4 of Exodia part card to win the game",0,0,defense);
	}
	
	public void equipItem(Player player) {
		int bonus_d = getDefenseBonus();
		if(player.getAssignedCharacter() instanceof ExodiaCharacterCard) {
			bonus_d *=2;
		}
		player.addInventory(this);
		player.setDefense(player.getDefense()+bonus_d);
	}
	

}