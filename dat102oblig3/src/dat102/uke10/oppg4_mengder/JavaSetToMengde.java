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
	
	public boolean inneholder() {
		return false;
	}

}
