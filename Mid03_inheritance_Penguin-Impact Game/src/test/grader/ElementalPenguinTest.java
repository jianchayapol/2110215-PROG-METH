package test.grader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import penguin.*;

public class ElementalPenguinTest {
	
	ElementalPenguin diona;
	ElementalPenguin barbara;
	ElementalPenguin hutao;
	ElementalPenguin eula;
	ElementalPenguin xiangling;
	ElementalPenguin xingqiu;
	FighterPenguin hillchurl;
	Penguin paimon;
	Penguin weakdummy;
	
	
	@BeforeEach
	void setup() {
		diona = new ElementalPenguin("Penguona", 60, 7, PenguinType.SNOW, "Want a drink?");
		barbara = new ElementalPenguin("Barbaraide", 70, 8, PenguinType.WATER, "Let's dance!");
		hutao = new ElementalPenguin("Pen Tao", 50, 9, PenguinType.FIRE, "Time to cross over!");
		eula = new ElementalPenguin("End User License Agreement", 80, 6, PenguinType.SNOW, "This warranty has expired!");
		xiangling = new ElementalPenguin("Pengling", 80, 5, PenguinType.FIRE, "Order's up!");
		xingqiu = new ElementalPenguin("Penqiu", 60, 7, PenguinType.WATER, "RAINING!");
		hillchurl = new FighterPenguin("Hill Penguin", 100, 4, "GRRR");
		paimon = new Penguin("Penmon", 100, "No bullying!");
		weakdummy = new Penguin("Weak Dummy", 2, "...");
	}
	

	@Test
	void testConstructor() {
		ElementalPenguin dionaCon = new ElementalPenguin("Penguona", 60, 7, PenguinType.SNOW, "Want a drink?");
		
		assertEquals("Penguona", dionaCon.getName());
		assertEquals(60, dionaCon.getHp());
		assertEquals(60, dionaCon.getMaxHp());
		assertEquals(7, dionaCon.getPow());
		assertEquals(PenguinType.SNOW, dionaCon.getType());
		assertEquals("Want a drink?", dionaCon.getCatchphrase());
		
        ElementalPenguin jotaro = new ElementalPenguin("Jotaro", -9, -7, PenguinType.WATER, "YareYare?");
		
		assertEquals("Jotaro", jotaro.getName());
		assertEquals(0, jotaro.getHp());
		assertEquals(0, jotaro.getMaxHp());
		assertEquals(0, jotaro.getPow());
		assertEquals(PenguinType.WATER, jotaro.getType());
		assertEquals("YareYare?", jotaro.getCatchphrase());
		
	}
	
	@Test
	void testSetType() {
		//ElementalPenguin diona = new ElementalPenguin("Penguona", 60, 7, PenguinType.SNOW, "Want a drink?");
		
		diona.setType(null);
		
		assertEquals(null, diona.getType());
		
		diona.setType(PenguinType.WATER);
		
		assertEquals(PenguinType.WATER, diona.getType());
		
		diona.setType(PenguinType.FIRE);
		
		assertEquals(PenguinType.FIRE, diona.getType());
		
		diona.setType(PenguinType.SNOW);
		
		assertEquals(PenguinType.SNOW, diona.getType());
	}
	
	@Test
	void testGetElementalAdvantageFire() {
		//fire beats snow but loses to water
		assertEquals(1, hutao.getElementalAdvantage(diona));
		assertEquals(-1, hutao.getElementalAdvantage(barbara));
	}
	
	@Test
	void testGetElementalAdvantageSnow() {
		//snow beats water but loses to fire
		assertEquals(1, diona.getElementalAdvantage(barbara));
		assertEquals(-1, diona.getElementalAdvantage(hutao));
	}
	
	@Test
	void testGetElementalAdvantageWater() {
		//water beats fire but loses to snow
		assertEquals(1, barbara.getElementalAdvantage(hutao));
		assertEquals(-1, barbara.getElementalAdvantage(diona));		
	}
	
	@Test
	void testGetElementalAdvantageElementless() {
		//no advantage or disadvantages to elementless
		assertEquals(0, diona.getElementalAdvantage(hillchurl));
		assertEquals(0, barbara.getElementalAdvantage(hillchurl));
		assertEquals(0, hutao.getElementalAdvantage(hillchurl));
		assertEquals(0, diona.getElementalAdvantage(paimon));
		assertEquals(0, barbara.getElementalAdvantage(paimon));
		assertEquals(0, hutao.getElementalAdvantage(paimon));
	}
	
	@Test
	void testGetElementalAdvantageSameElement() {
		//no advantage or disadvantage to same element
		assertEquals(0, hutao.getElementalAdvantage(xiangling));
		assertEquals(0, barbara.getElementalAdvantage(xingqiu));
		assertEquals(0, diona.getElementalAdvantage(eula));
	}
	
	@Test
	void testAttackFire() {
		int damage = 0;
		
		//winning element
		damage = hutao.attack(diona);
		assertEquals(18, damage);
		assertEquals(42, diona.getHp());
		
		//losing element
		damage = hutao.attack(barbara);
		assertEquals(4, damage);
		assertEquals(66, barbara.getHp());
		
		//equal element
		damage = hutao.attack(xiangling);
		assertEquals(9, damage);
		assertEquals(71, xiangling.getHp());
		
		//elementless
		damage = hutao.attack(hillchurl);
		assertEquals(9, damage);
		assertEquals(91, hillchurl.getHp());
		
		//near death
		damage = hutao.attack(weakdummy);
		assertEquals(9, damage);
		assertEquals(0, weakdummy.getHp());
	}
	
	@Test
	void testAttackSnow() {
		int damage = 0;
		
		//winning element
		damage = diona.attack(barbara);
		assertEquals(14, damage);
		assertEquals(56, barbara.getHp());
		
		//losing element
		damage = diona.attack(hutao);
		assertEquals(3, damage);
		assertEquals(47, hutao.getHp());
		
		//equal element
		damage = diona.attack(eula);
		assertEquals(7, damage);
		assertEquals(73, eula.getHp());
		
		//elementless
		damage = diona.attack(hillchurl);
		assertEquals(7, damage);
		assertEquals(93, hillchurl.getHp());
		
		//near death
		damage = diona.attack(weakdummy);
		assertEquals(7, damage);
		assertEquals(0, weakdummy.getHp());
	}
	
	@Test
	void testAttackWater() {
		int damage = 0;
		
		//winning element
		damage = barbara.attack(hutao);
		assertEquals(16, damage);
		assertEquals(34, hutao.getHp());
		
		//losing element
		damage = barbara.attack(diona);
		assertEquals(4, damage);
		assertEquals(56, diona.getHp());
		
		//equal element
		damage = barbara.attack(xingqiu);
		assertEquals(8, damage);
		assertEquals(52, xingqiu.getHp());
		
		//elementless
		damage = barbara.attack(hillchurl);
		assertEquals(8, damage);
		assertEquals(92, hillchurl.getHp());
		
		//near death
		damage = barbara.attack(weakdummy);
		assertEquals(8, damage);
		assertEquals(0, weakdummy.getHp());
	}
	
	@Test
	void testToString() {
		assertEquals("Pen Tao (F) 50/50 HP, 9 POW", hutao.toString());
		assertEquals("Penguona (S) 60/60 HP, 7 POW", diona.toString());
		assertEquals("Barbaraide (W) 70/70 HP, 8 POW", barbara.toString());
	}
	
	@Test
	void testInheritance() {
		FighterPenguin hutao2 = (FighterPenguin) hutao;
		System.out.println(hutao2.attack(diona));
		Penguin hutao3 = (Penguin) hutao2;
		System.out.println(hutao3.getSpeech());
	}

}
