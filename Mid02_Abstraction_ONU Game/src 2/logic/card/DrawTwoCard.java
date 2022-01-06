package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class DrawTwoCard extends BaseCard {

	private CardSymbol symbol;

	public DrawTwoCard(CardColor color) {
		super(color);
		this.symbol = CardSymbol.DRAW;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		GameLogic.getInstance().setTopCard(this);
		GameLogic.getInstance().draw(2);
	}

	@Override
	public boolean ruleCheck() {
		// TODO Auto-generated method stub
		BaseCard n = GameLogic.getInstance().getTopCard();
		return (n.getColor() == this.getColor());
	}

	public CardSymbol getSymbol() {
		return symbol;
	}

	public void setSymbol(CardSymbol symbol) {
		this.symbol = symbol;
	}
	
	

}
