package dat102.uke10.oppg4_Tester;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.classfile.components.ClassPrinter.Node;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dat102.uke10.oppg4_mengder.TabellMengde;

class TabellMengdeTest {

/* --- Data brukt i testene -------------------------------------- */ 
	
	static Integer[] tomTabell = {};
	static Integer[] Tabell = new Integer[] 	{2,8,0,4,6};
	static Integer[] Tabell2 = new Integer[] 	{3,8,5,1,9};
	static Integer[] TabellLik = new Integer[] 	{2,8,0,4,6};
	static Integer[] TabellUlik = new Integer[] {1,3,5,7,9};
	static Integer[] TabellSnitt = new Integer[]{4,6};
	/* --------------------------------------------------------------- */
	
	//TODO Vi må jo skrive tester for å sjekke at det vi lager virker !!
	
		@Test
		void sokTabellTomTest() {
			assertTrue(TabellMengde.erTom(tomTabell));
			assertFalse(TabellMengde.erTom(Tabell));
		}
		
		
		@Test
		void sokTabellTest() {
			assertTrue(TabellMengde.inneholder(Tabell,2));
			assertTrue(TabellMengde.inneholder(Tabell,0));
			assertTrue(TabellMengde.inneholder(Tabell,6));
			assertFalse(TabellMengde.inneholder(Tabell,5));
		}
		@Test
		void sokDelMengdeTabellTest () {
			assertTrue(TabellMengde.erDelmengdeAv(Tabell,Tabell2));
			assertFalse(TabellMengde.erDelmengdeAv(Tabell,tomTabell));
		}
		@Test
		void sokTabellLikTest () {
	        assertTrue(TabellMengde.erLik(Tabell, TabellLik));
	        assertFalse(TabellMengde.erLik(Tabell, Tabell2));

		}
		@Test
		void erDisjunktTest () {
			 assertTrue(TabellMengde.erDisjunkt(Tabell, TabellUlik));
			 assertFalse(TabellMengde.erDisjunkt(Tabell, TabellLik));
		}
		@Test
		void snittTest () {
		}
}
