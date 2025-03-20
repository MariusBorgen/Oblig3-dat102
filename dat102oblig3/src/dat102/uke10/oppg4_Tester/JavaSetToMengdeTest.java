package dat102.uke10.oppg4_Tester;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dat102.uke10.oppg4_mengder.JavaSetToMengde;

class JavaSetToMengdeTest {

    @Test
    void testErTom() {
        JavaSetToMengde<Integer> mengde = new JavaSetToMengde<>();
        assertTrue(mengde.erTom()); // Skal være tom ved oppretting
        
        mengde.leggTil(1);
        assertFalse(mengde.erTom()); // Skal ikke være tom etter at et element er lagt til
    }

    @Test
    void testInneholder() {
        JavaSetToMengde<Integer> mengde = new JavaSetToMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        
        assertTrue(mengde.inneholder(1)); // Skal være sann
        assertFalse(mengde.inneholder(3)); // Skal være usann
    }

    @Test
    void testLeggTil() {
        JavaSetToMengde<Integer> mengde = new JavaSetToMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        
        assertEquals(2, mengde.antallElementer()); // Skal ha 2 elementer
        
        mengde.leggTil(2); // Duplikat, skal ikke legges til
        assertEquals(2, mengde.antallElementer()); // Skal fortsatt ha 2 elementer
    }

    @Test
    void testFjern() {
        JavaSetToMengde<Integer> mengde = new JavaSetToMengde<>();
        mengde.leggTil(1);
        mengde.leggTil(2);
        
        assertEquals((Integer) 1, mengde.fjern(1)); // Skal fjerne 1 og returnere det
        assertNull(mengde.fjern(3)); // Skal returnere null hvis elementet ikke finnes
    }

    @Test
    void testSnitt() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        
        JavaSetToMengde<Integer> snitt = (JavaSetToMengde<Integer>) mengde1.snitt(mengde2);
        assertArrayEquals(new Integer[]{2}, snitt.tilTabell()); // Snittet skal være [2]
    }

    @Test
    void testUnion() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        
        JavaSetToMengde<Integer> union = (JavaSetToMengde<Integer>) mengde1.union(mengde2);
        assertArrayEquals(new Integer[]{1, 2, 3}, union.tilTabell()); // Unionen skal være [1, 2, 3]
    }

    @Test
    void testMinus() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde1.leggTil(3);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        
        JavaSetToMengde<Integer> minus = (JavaSetToMengde<Integer>) mengde1.minus(mengde2);
        assertArrayEquals(new Integer[]{1}, minus.tilTabell()); // Minus skal være [1]
    }

    @Test
    void testErDelmengdeAv() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(1);
        mengde2.leggTil(2);
        mengde2.leggTil(3);
        
        assertTrue(mengde1.erDelmengdeAv(mengde2)); // mengde1 er delmengde av mengde2
        assertFalse(mengde2.erDelmengdeAv(mengde1)); // mengde2 er ikke delmengde av mengde1
    }

    @Test
    void testErLik() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(2);
        mengde2.leggTil(1);
        
        assertTrue(mengde1.erLik(mengde2)); // De er like, selv om rekkefølgen er forskjellig
        
        mengde2.leggTil(3);
        assertFalse(mengde1.erLik(mengde2)); // Nå er de forskjellige
    }
    
    @Test
    void testErDisjunkt() {
        JavaSetToMengde<Integer> mengde1 = new JavaSetToMengde<>();
        JavaSetToMengde<Integer> mengde2 = new JavaSetToMengde<>();
        
        mengde1.leggTil(1);
        mengde1.leggTil(2);
        mengde2.leggTil(3);
        mengde2.leggTil(4);
        
        assertTrue(mengde1.erDisjunkt(mengde2)); // Skal være disjunkte (ingen felles elementer)
        
        mengde2.leggTil(2);
        assertFalse(mengde1.erDisjunkt(mengde2)); // Ikke disjunkte lenger, de har 2 som felles
    }
}
