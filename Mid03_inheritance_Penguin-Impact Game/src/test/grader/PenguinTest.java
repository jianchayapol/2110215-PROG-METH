package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penguin.*;

public class PenguinTest {

	@Test
	void testConstructor() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		assertEquals("Penmon", paimon.getName());
		assertEquals(100, paimon.getHp());
		assertEquals(100, paimon.getMaxHp());
		assertEquals("No bullying!", paimon.getCatchphrase());
		
		Penguin paimon2 = new Penguin("Emergency Food", -200, "I'm not delicious!");
		assertEquals("Emergency Food", paimon2.getName());
		assertEquals(0, paimon2.getHp());
		assertEquals(0, paimon2.getMaxHp());
		assertEquals("I'm not delicious!", paimon2.getCatchphrase());
	}
	
	@Test
	void testSetName() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		paimon.setName("Penguin Paimon");
		
		assertEquals("Penguin Paimon", paimon.getName());
	}
	
	@Test
	void testSetHp() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		paimon.setHp(50);
		
		assertEquals(50, paimon.getHp());
		
		paimon.setHp(0);
		
		assertEquals(0, paimon.getHp());
		
		paimon.setHp(-666);
		
		assertEquals(0, paimon.getHp());
		
		paimon.setHp(10000);
		
		assertEquals(100, paimon.getHp());
	}
	
	@Test
	void testSetMaxHp() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		paimon.setMaxHp(50);
		
		assertEquals(50, paimon.getMaxHp());
		
		paimon.setMaxHp(0);
		
		assertEquals(0, paimon.getMaxHp());
		
		paimon.setMaxHp(-666);
		
		assertEquals(0, paimon.getMaxHp());
		
		paimon.setMaxHp(10000);
		
		assertEquals(10000, paimon.getMaxHp());
	}
	
	@Test
	void testSetCatchphrase() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		paimon.setCatchphrase("Don't eat me either!");
		
		assertEquals("Don't eat me either!", paimon.getCatchphrase());
	}
	
        
        //Uncomment this after Creating FighterPenguin class and ElementalPenguin class
	
	@Test
	void testToString() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		paimon.setHp(40);
		
		assertEquals("Penmon 40/100 HP", paimon.toString());
	}
	
	@Test
	void testGetSpeech() {
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		
		assertEquals("Penmon: \"No bullying!\"", paimon.getSpeech());
	}
	
	//Uncomment this after finishing FighterPenguin class!
	@Test
	void testNotFighter() {
		
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		Penguin target = new Penguin("TargetDummy", 999, "...");
		
		assertThrows(ClassCastException.class, ()->{
			FighterPenguin paimon2 = (FighterPenguin) paimon;
			paimon2.attack(target);
		});
		
	}
	
	//Uncomment this after finishing ElementalPenguin class!
	@Test
	void testNotElemental() {
		
		Penguin paimon = new Penguin("Penmon", 100, "No bullying!");
		Penguin target = new Penguin("TargetDummy", 999, "...");
		
		assertThrows(ClassCastException.class, ()->{
			ElementalPenguin paimon2 = (ElementalPenguin) paimon;
			paimon2.getElementalAdvantage(target);
		});
		
	}

}
