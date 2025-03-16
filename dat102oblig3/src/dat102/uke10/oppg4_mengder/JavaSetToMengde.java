package dat102.uke10.oppg4_mengder;

import dat102.uke10.oppg4_mengder.MengdeADT;
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
		return mengde.toArray((T[]) new Object[0]);
	}
	
	public int antallElementer() {
		return mengde.size();
	}
	
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> nyMengde) {
		for (T element : mengde) {
			if(!nyMengde.inneholder(element)) {
				return false;
			}
		}
		return true;

	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		// TODO Auto-generated method stub
		
	}
}
	
	

