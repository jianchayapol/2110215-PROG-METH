package card.cards;

import card.base.CharacterCard;
import player.Player;

//You CAN modify the first line
public class MainCharacterCard extends CharacterCard {

	private int level;
	private float levelUpBonus;

	
	public MainCharacterCard(String name, String description, int lifePoint, int attackPoint, int defensePoint,
			float levelUpBonus) {
		super(name, description, lifePoint, attackPoint, defensePoint);
		this.setLevelUpBonus(levelUpBonus);
		this.level = 0;
	
	}


	@Override
	public String getName() {
		return super.getName() + " [level " + this.getLevel() + "]";
	}

	public int getLevel() {
		// TODO Auto-generated method stub
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int sacrifice(Player player) {
		// TODO Auto-generated method stub
		int p = player.getMaxLifePoint()/8;
		player.healPlayer(p);
		return p;
	}

	public float getLevelUpBonus() {
		return levelUpBonus;
	}

	public void setLevelUpBonus(float levelUpBonus) {
		this.levelUpBonus = levelUpBonus;
	}

	public float levelUp(Player player) {
		this.level++;
		player.setNewCharacterLifePoint((int) (player.getCurrentLifePoint() *(1+levelUpBonus)));
		player.setAttack((int) (player.getAttack()*(1+levelUpBonus)));
		player.setDefense((int) (player.getDefense()*(1+levelUpBonus)));
		return level;
	}
	
	
	
}
