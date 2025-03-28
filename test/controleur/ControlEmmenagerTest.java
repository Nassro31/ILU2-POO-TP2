package controleur;

import static org.junit.jupiter.api.Assertions.*;

import javax.print.event.PrintJobAttributeEvent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private Village village;
	private Chef chef;
	
	@BeforeEach
	public void initialiser() {
		
	}

	@Test
	void testControlEmmenager() {
		assertFalse(false);
	}

	@Test
	void testIsHabitant() {
		assertFalse(village.isHabitant());
	}

	@Test
	void testAjouterDruide() {
		fail("Not yet implemented");
	}

	@Test
	void testAjouterGaulois() {
		fail("Not yet implemented");
	}

}
