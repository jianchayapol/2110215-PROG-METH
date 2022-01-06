package card.base;

import player.Player;

//You CAN modify the first line
public abstract class ItemCard extends Card {

	private int lpBonus;
	private int attackBonus;
	private int defenseBonus;
	
	public ItemCard(String name, String description, int lpBonus , int attackBonus, int defenseBonus) {
		super(name,description);
		this.lpBonus = lpBonus;
		this.attackBonus = attackBonus;
		this.defenseBonus = defenseBonus;
	}
	
	public abstract void equipItem(Player player);
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName() + " \t [Item][HP : " + this.lpBonus + " ATK : " + this.attackBonus + " DEF : " + this.defenseBonus + "]";
	}

	public int getLpBonus() {
		return lpBonus;
	}

	public void setLpBonus(int lpBonus) {
		this.lpBonus = lpBonus;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDefenseBonus() {
		return defenseBonus;
	}

	public void setDefenseBonus(int defenseBonus) {
		this.defenseBonus = defenseBonus;
	}
	
}
