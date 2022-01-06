package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class NumberCard extends BaseCard{
	
	private CardSymbol symbol;
	
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color);
		this.symbol = symbol;
		
	}

	@Override
	public void play() {
		GameLogic.getInstance().setTopCard(this);
	}

	@Override
	public boolean ruleCheck() {
		BaseCard n = GameLogic.getInstance().getTopCard();
		return (n.getColor()==this.getColor() || n.getSymbol()==this.symbol);
	}
	
	public CardSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}
	

}
