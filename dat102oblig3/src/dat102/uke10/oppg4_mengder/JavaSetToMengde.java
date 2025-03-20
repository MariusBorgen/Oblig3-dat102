package dat102.uke10.oppg4_mengder;

import java.util.HashSet;
import java.util.Set;


public class JavaSetToMengde <T> implements MengdeADT<T>{
	
	private Set<T> mengde;
	
	public JavaSetToMengde() {
		mengde = new HashSet<>();
	}
	
	@Override
	public boolean erTom(){
		return mengde.isEmpty();
	}
	
	public boolean inneholder(T element) {
		return mengde.contains(element);
	}
	
	public void leggTil(T element) {
		mengde.add(element);
	}
	
	@Override
	public T fjern(T element) {
		if(mengde.remove(element)) {
			return element;
		}
		return null;
	}
	
	public T[] tilTabell() {
	    return mengde.toArray((T[]) new Object[mengde.size()]);
	}

	
	public int antallElementer() {
		return mengde.size();
	}
	
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (T element : mengde) {
			if(!annenMengde.inneholder(element)) {
				return false;
			}
		}
		return true;

	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		Set<T> annenMengdeSet = new HashSet<>();
		for (T element : annenMengde.tilTabell()) {
			annenMengdeSet.add(element);
		}
		return mengde.equals(annenMengdeSet);
		
//		Annen løsning, vet ikke hvilken som er best;		
//		Set<T> annenMengdeSet = new HashSet<>(Arrays.asList(annenMengde.tilTabell()));
//		return mengde.equals(annenMengdeSet);
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for(T element : annenMengde.tilTabell()) {
			if (mengde.contains(element)) {
				return false;
			}
		}
		return true;
		
//		Annen løsning;	(mindre effektivt?)
//		Set<T> kopiMengde = new HashSet<>(mengde);
//		kopiMengde.retainAll(Arrays.asList(annenMengde.tilTabell()));
//		return kopiMengde.isEmpty();
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> snittMengde = new JavaSetToMengde<>();
		for (T element : mengde) {
			if (annenMengde.inneholder(element)) {
				snittMengde.leggTil(element);
			}
		}
		return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		JavaSetToMengde<T> unionMengde = new JavaSetToMengde<>();
		for (T element : mengde) {
			unionMengde.leggTil(element);
		}
		for (T element : annenMengde.tilTabell()) {
			unionMengde.leggTil(element);
		}
		return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
	    JavaSetToMengde<T> minusMengde = new JavaSetToMengde<>();

	    for (T element : mengde) {
	        if (!annenMengde.inneholder(element)) {
	            minusMengde.leggTil(element); 
	        }
	    }
	    return minusMengde; 
	}


	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
	    for (T element : annenMengde.tilTabell()) {
	        this.leggTil(element);  // Bruker eksisterende `leggTil()`-metode
	    }
	}

}
	
	

