package dat102.uke10.oppg4_mengder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.classfile.components.ClassPrinter.Node;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TabellMengdeTest {

/* --- Data brukt i testene -------------------------------------- */ 
	
	static Integer[] tomTabell = {};
	static Integer[] Tabell = new Integer[] { 2, 8, 0, 4, 6 };

	/* --------------------------------------------------------------- */
	
	//TODO Vi må jo skrive tester for å sjekke at det vi lager virker !!
	
	
	

		@Test
		void sokTabellTomTest() {
			assertFalse(TabellMengde.sokTabell(tomTabell,0));
		}
		
		void sokTabellTest() {
			assertTrue(TabellMengde.sokTabell(Tabell,2));
			assertTrue(TabellMengde.sokTabell(Tabell,0));
			assertTrue(TabellMengde.sokTabell(Tabell,6));
			assertFalse(TabellMengde.sokTabell(Tabell,5));

		}
}
