package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.card.NumberCard;
import logic.game.CardColor;
import logic.game.GameLogic;
import logic.game.CardSymbol;

class NumberCardTest {

	NumberCard c1;
	NumberCard c2;
	NumberCard c3;
	NumberCard c4;
	
	@BeforeEach
	void setUp() throws Exception {
		c1 = new NumberCard(CardColor.RED,CardSymbol.ONE);
		c2 = new NumberCard(CardColor.RED,CardSymbol.TWO);
		c3 = new NumberCard(CardColor.YELLOW,CardSymbol.ONE);
		c4 = new NumberCard(CardColor.BLUE,CardSymbol.THREE);
		
	}
	
	@Test
	void testConstructor(){
		assertEquals(CardColor.RED,c1.getColor());
		assertEquals(CardSymbol.ONE,c1.getSymbol());
	}

	@Test
	void testPlay() {
		c1.play();
		assertEquals(CardColor.RED,GameLogic.getInstance().getTopCard().getColor());
		assertEquals(CardSymbol.ONE,GameLogic.getInstance().getTopCard().getSymbol());
		
		c2.play();
		assertEquals(CardColor.RED, GameLogic.getInstance().getTopCard().getColor());
		assertEquals(CardSymbol.TWO, GameLogic.getInstance().getTopCard().getSymbol());
	}
	
	@Test
	void testRuleCheck() {
		GameLogic.getInstance().setTopCard(c1);
		assertEquals(true,c1.ruleCheck());
		assertEquals(true,c2.ruleCheck());
		assertEquals(true,c3.ruleCheck());
		assertEquals(false,c4.ruleCheck());
		
		GameLogic.getInstance().setTopCard(c3);
		assertEquals(true,c1.ruleCheck());
		assertEquals(false,c2.ruleCheck());
		assertEquals(true,c3.ruleCheck());
		assertEquals(false,c4.ruleCheck());
	}

}
