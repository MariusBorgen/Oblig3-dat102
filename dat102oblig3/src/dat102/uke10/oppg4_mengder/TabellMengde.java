package dat102.uke10.oppg4_mengder;

import java.util.Arrays;

public class TabellMengde<T> {
	                   	             
	/**
	 * @return Om mengden er tom
	 */
	public static <T> boolean erTom(T[] tabell) {
	
	return tabell.length == 0;
	}
	
	/**
	 * @param element
	 * @return Om mengden inneholder element
	 */
	
	public static <T> boolean inneholder(T[] tabell, T element) {
 		
		for (T tabel:tabell) {
				if (tabel.equals(element)) {
					return true;
				}
			}		
			return false;
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er en delmengde av en annenMengde
	 */
	public static <T> boolean erDelmengdeAv(T[] tabell, T[]annenMengde) {
	
		for (T tabel : tabell) {
	        if (inneholder(annenMengde, tabel)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	/**
	 * @param annenMengde
	 * @return Om mengden er lik en annenMengde
	 */
	public static <T> boolean erLik(T[] tabell, T[]annenMengde) {
		  if (tabell.length != annenMengde.length) {
		        return false;
		    }
		    Arrays.sort(tabell);
		    Arrays.sort(annenMengde);
		    return Arrays.equals(tabell, annenMengde);
		}
	
	
	/**
	 * @param annenMengde
	 * @return Om mengden og en annenMengde er disjunkte
	 */
	public static <T> boolean erDisjunkt(T[] tabell, T[]annenMengde) {
		for (T tabel:tabell) {
			 if (inneholder(annenMengde, tabel)) {
				return false;
			}
		}
	return true;	
	}
	
	/**
	 * @param annenMengde
	 * @return 
	 * @return Snittet av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	public static <T> T[] snitt(T[] tabell, T[] annenMengde) {
		T[] resultat = Arrays.copyOf(tabell, 0);
        int antall = 0;
        for (T tabel : tabell) {
            if (inneholder(annenMengde, tabel)) {
                resultat = Arrays.copyOf(resultat, antall + 1);
                resultat[antall++] = tabel;
            }
        }
        return resultat;
	}
	
	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	public static <T> T[] union(T[] tabell, T[] annenMengde) {
		
        T[] resultat = Arrays.copyOf(tabell, tabell.length);
        int antall = tabell.length;
        
        for (T tabel : annenMengde) {
            if (!inneholder(tabell, tabel)) {
                resultat = Arrays.copyOf(resultat, antall + 1);
                resultat[antall++] = tabel;
            }
        }
        return resultat;
    }
	
	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	public static <T> T[] minus(T[] tabell, T[] annenMengde) {
        T[] resultat = Arrays.copyOf(tabell, 0);
        int antall = 0;
        for (T tabel : tabell) {
            if (!inneholder(annenMengde, tabel)) {
                resultat = Arrays.copyOf(resultat, antall + 1);
                resultat[antall++] = tabel;
            }
        }
        return resultat;
    }
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	
	public static <T> T[] leggTil(T[] tabell, T element) {
        if (inneholder(tabell, element)) {
            return tabell;
        }
        T[] nyTabell = Arrays.copyOf(tabell, tabell.length + 1);
        nyTabell[tabell.length] = element;
        return nyTabell;
    }
	
	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer
	 * som ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	public static <T> T[] leggTilAlleFra(T[] tabell, T[] annenMengde) {
        for (T tabel : annenMengde) {
            tabell = leggTil(tabell, tabel);
        }
        return tabell;
    }
	
	/**
	 * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes 
	 * i mengden, skal metoden returnere null.
	 * 
	 * @param element Et element som er lik det elementet som skal fjernes 
	 * @return Elementet som ble fjernet fra mengden, null hvis det ikke fantes.
	 */
	 public static <T> T fjern(T[] tabell, T element) {
	        if (!inneholder(tabell, element)) {
	            return null;
	        }
	        T[] nyTabell = Arrays.copyOf(tabell, tabell.length - 1);
	        int antall = 0;
	        T fjernetElement = null;
	        for (T tabel : tabell) {
	            if (fjernetElement == null && tabel.equals(element)) {
	                fjernetElement = tabel;
	            }
	            if (antall < nyTabell.length) {
	                nyTabell[antall++] = tabel;
	            }
	        }
	        return fjernetElement;
	    }
	
	/**
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik
	 *         antall elementer i mengden.
	 */
	 public static <T> T[] tilTabell(T[] tabell) {
	        return Arrays.copyOf(tabell, tabell.length);
	    }
	
	/**
	 * @return Antall elementer i mengden.
	 */
	 public static <T> int antallElementer(T[] tabell) {
	        return tabell.length;
	    }
}
	




