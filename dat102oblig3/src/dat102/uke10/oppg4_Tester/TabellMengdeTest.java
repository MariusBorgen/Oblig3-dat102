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
	static Integer[] Snitt = {8};
	static Integer[] Union = {2, 8, 0, 4, 6, 3, 5, 1, 9};
	static Integer[] Minus = {0,2,4,6};
	static Integer[] LeggTil = {2, 8, 0, 4, 6, 7};
	static Integer[] LeggTilAlleFra = {0,2,4,6,8,1,3,5,7,9};
	
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
		void snittTest() {
		    assertArrayEquals(Snitt, TabellMengde.snitt(Tabell, Tabell2));
		    assertArrayEquals(new Integer[]{}, TabellMengde.snitt(Tabell, TabellUlik));
		}
		@Test
		void unionTest() {
		    assertArrayEquals(Union, TabellMengde.union(Tabell, Tabell2));
		}
		@Test
		void minusTest() {
		    assertArrayEquals(Minus, TabellMengde.minus(Tabell, Tabell2));
		}
		@Test
		void leggTilTest() {
		    assertArrayEquals(LeggTil, TabellMengde.leggTil(Tabell, 7));
		}

		@Test
		void leggTilAlleFraTest() {
		    assertArrayEquals(LeggTilAlleFra, TabellMengde.leggTilAlleFra(Tabell, TabellUlik));
		}

		@Test
		void fjernTest() {
		    assertEquals((Integer) 8, TabellMengde.fjern(Tabell, 8));
		    assertNull(TabellMengde.fjern(Tabell, 99));
		}

		@Test
		void tilTabellTest() {
		    assertArrayEquals(Tabell, TabellMengde.tilTabell(Tabell));
		}

		@Test
		void antallElementerTest() {
		    assertEquals(5, TabellMengde.antallElementer(Tabell));
		    assertEquals(0, TabellMengde.antallElementer(tomTabell));
		}
}

