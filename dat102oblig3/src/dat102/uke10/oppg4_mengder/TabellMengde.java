package dat102.uke10.oppg4_mengder;

public class TabellMengde<T> {
	
//	Sjekk om tabellen har null eller ingen elementer.   
	
	public static <T> boolean sokTabellTom(T[] tabell, T element) {
		
	for (T tabel:tabell) {
			if (tabel.equals(null)) {
				return true;
			}
		}		
		return false;
}

	public static <T> boolean sokTabell(T[] tabell, T element) {

//		Løkke gjennom tabellen og sjekk likhet (`equals`). 
		
		for (T tabel:tabell) {
				if (tabel.equals(element)) {
					return true;
				}
			}		
			return false;
	}
}
		/*
	                          
	Gå gjennom elementene og sjekk om de finnes i den andre mengden.             
	Sammenlign lengde og sjekk at alle elementer er like.                        
	Sjekk at ingen elementer finnes i begge mengder.
	Gå gjennom begge mengdene og legg felles elementer i en ny mengde.
	Kombiner alle elementer fra begge mengder i en ny mengde.                    
	Fjern alle elementer i den andre mengden fra den første.                     
	Sjekk at elementet ikke finnes før du legger det til i tabellen.             
	Finn elementet og fjern det. Flytt etterfølgende elementer ett hakk bakover.
	Returner en kopi av tabellen med alle elementene.             
	Returner lengden på tabellen.
	*/
	




