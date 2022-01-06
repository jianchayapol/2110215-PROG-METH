package test.student;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import card.base.ItemCard;
import card.cards.BasicItemCard;
import card.cards.ExodiaCharacterCard;
import card.cards.ExodiaPartCard;
import card.cards.MainCharacterCard;
import player.Player;

public class TestExodiaCharacterCard {
	Player player;
	ExodiaCharacterCard testExodia;
	BasicItemCard item1 = new BasicItemCard("Item1", "item1", 10, 0, 0);
	ExodiaPartCard exodiaItem = new ExodiaPartCard("exodiaItem", 10);
	ItemCard[] inventory1 = { item1, item1, item1, item1 };
	ItemCard[] inventory2 = { item1, item1, exodiaItem, exodiaItem };
	ItemCard[] inventory3 = { exodiaItem, exodiaItem, exodiaItem, exodiaItem };

	@Before
	public void setUp() {
		player = new Player("testPlayer", 400, 50, 30);
		testExodia = new ExodiaCharacterCard();
	}

	@Test
	public void testConstructor() {

		assertEquals("Exodia the Forbidden One", testExodia.getName());
		assertEquals("With 4 or more Exodia Part Card equiped, you win the game", testExodia.getDescription());

	}

	// Fill Code Here!!!

	// 1.testSwitchCharacter

	@Test
	public void testSwitchCharacter() {
		testExodia.switchCharacter(player);
		assertEquals(800, player.getCurrentLifePoint());
		assertEquals(0, player.getAttack());
		assertEquals(25, player.getDefense());
	}

	// 2.testSacrifice

	@Test
	public void testSacrifice() {
		player.setCurrentLifePoint(250);
		testExodia.sacrifice(player);
		assertEquals(290, player.getCurrentLifePoint());

		player = new Player("testPlayer", 300, 50, 30);
		testExodia = new ExodiaCharacterCard();

		player.setCurrentLifePoint(280);
		testExodia.sacrifice(player);
		assertEquals(300, player.getCurrentLifePoint());
	}

	// 3.testWinConditionCheck

	@Test
	public void testWinConditionCheck() {
		assertEquals(false, testExodia.winConditionCheck(inventory1));
		assertEquals(false, testExodia.winConditionCheck(inventory2));
		assertEquals(true, testExodia.winConditionCheck(inventory3));
	}

}