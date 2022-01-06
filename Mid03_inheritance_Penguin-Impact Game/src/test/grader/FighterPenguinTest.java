package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penguin.*;

public class FighterPenguinTest {

	@Test
	void testConstructor() {
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		
		assertEquals("Lumine Hall", lumine.getName());
		assertEquals(70, lumine.getHp());
		assertEquals(70, lumine.getMaxHp());
		assertEquals(9, lumine.getPow());
		assertEquals("I'll find you, Aether!", lumine.getCatchphrase());
		
		FighterPenguin hillchurl = new FighterPenguin("Hillpenguin", -100, -50, "GRRR");
		
		assertEquals("Hillpenguin", hillchurl.getName());
		assertEquals(0, hillchurl.getHp());
		assertEquals(0, hillchurl.getMaxHp());
		assertEquals(0, hillchurl.getPow());
		assertEquals("GRRR", hillchurl.getCatchphrase());
	}
	
	@Test
	void testSetPow() {
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		
		lumine.setPow(12);
		
		assertEquals(12, lumine.getPow());
		
		lumine.setPow(0);
		
		assertEquals(0, lumine.getPow());
		
		lumine.setPow(-16);
		
		assertEquals(0, lumine.getPow());
		
		lumine.setPow(127);
		
		assertEquals(127, lumine.getPow());
	}
	
	@Test
	void testAttack() {
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		
		Penguin dummy = new Penguin("Dummy", 120, "...");
		
		int damage = lumine.attack(dummy);
		
		assertEquals(9, damage);
		assertEquals(111, dummy.getHp());
		
		Penguin dummy2 = new Penguin("Weak Dummy", 5, "...");
		
		damage = lumine.attack(dummy2);
		
		assertEquals(9, damage);
		assertEquals(0, dummy2.getHp());
	}
	
        //Uncomment this after finishing ElementalPenguin class!

	@Test
	void testToString() {
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		
		lumine.setHp(24);
		
		assertEquals("Lumine Hall 24/70 HP, 9 POW", lumine.toString());
	} 
	
	//Uncomment this after finishing ElementalPenguin class!
    @Test
	void testNotElemental() {
		
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		Penguin target = new Penguin("TargetDummy", 999, "...");
		
		assertThrows(ClassCastException.class, ()->{
			ElementalPenguin lumine2 = (ElementalPenguin) lumine;
			lumine2.getElementalAdvantage(target);
		});
		
	}
	
	@Test
	void testInheritance() {
		FighterPenguin lumine = new FighterPenguin("Lumine Hall", 70, 9, "I'll find you, Aether!");
		Penguin penLumine = (Penguin) lumine;
		System.out.println(penLumine.getSpeech());
	}

}
