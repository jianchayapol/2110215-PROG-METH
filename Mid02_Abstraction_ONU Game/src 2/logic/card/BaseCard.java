package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

public abstract class BaseCard {
	private CardColor color;
	private CardSymbol symbol;
	
	public BaseCard(CardColor color) {
		this.color = color;
	}
	
	public abstract void play();
	
	public abstract boolean ruleCheck();

	public CardColor getColor() {
		return color;
	}

	public void setColor(CardColor color) {
		this.color = color;
	}

	public CardSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}
	
	
	
	
}
