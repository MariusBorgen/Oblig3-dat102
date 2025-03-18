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
	
		for (T element : tabell) {
	        if (inneholder(annenMengde, element)) {
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
	public static <T> boolean snitt(T[] tabell, T element) {
		return false;
	}
	
	/**
	 * @param annenMengde
	 * @return Unionen av mengden og en annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	MengdeADT<T> union(T[] tabell, T element) {
		return null;
		
	};
	
	/**
	 * @param annenMengde
	 * @return Mengden minus annenMengde.
	 *         Metoden skal ikke endre på mengden eller annenMengde,
	 *         men lage en ny mengde som blir resultatet.
	 */
	MengdeADT<T> minus(T[] tabell, T element) {
		return null;
		
	};
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	void leggTil(T[] tabell, T element) {
		
	};
	
	/**
	 * Legger alle elementer fra en annenMengde til i mengden. Kun elementer
	 * som ikke finnes i mengden fra før, skal legges til.
	 * 
	 * @param annenMengde
	 */
	void leggTilAlleFra(T[] tabell, T element) {
		
	};
	
	/**
	 * Fjerner og returnerer et element fra mengden. Hvis elementet ikke finnes 
	 * i mengden, skal metoden returnere null.
	 * 
	 * @param element Et element som er lik det elementet som skal fjernes 
	 * @return Elementet som ble fjernet fra mengden, null hvis det ikke fantes.
	 */
	T fjern(T element) {
		return element;
		
	};
	
	/**
	 * @return En tabell av elementene i mengden. Tabellen har størrelse lik
	 *         antall elementer i mengden.
	 */
	T[] tilTabell() {
		return null;
		
	};
	
	/**
	 * @return Antall elementer i mengden.
	 */
	int antallElementer() {
		return 0;
		
	};
}
	




