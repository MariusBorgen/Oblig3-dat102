package oppgave4f;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Person {

	String navn;
	Set<String> hobbyer;
	public Person(String navn, String ... hobbyer) {
		this.navn = navn;
		this.hobbyer = new HashSet<>(Arrays.asList(hobbyer));
	}
	public String getNavn() {
		return navn;
	}
	
	public Set<String> getHobbyer() {
		return hobbyer;
	}
	
	
}
