package oppgave4f;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {

	public static void main(String[] args) {
		
		Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
        Person bjorn = new Person("Bjørn", "sykling", "data", "trening", "musikk");
        Person camilla = new Person("Camilla", "musikk", "data", "bøker", "maling");

        System.out.printf("Match Arne - Bjørn: %.2f%n", match(arne, bjorn));
        System.out.printf("Match Arne - Camilla: %.2f%n", match(arne, camilla));
        System.out.printf("Match Bjørn - Camilla: %.2f%n", match(bjorn, camilla));
        System.out.printf("Match Arne - Arne (seg selv): %.2f%n", match(arne, arne));
        System.out.printf("Match Bjørn - Arne (seg selv): %.2f%n", match(bjorn, arne));

        Person[] personer = {arne, bjorn, camilla};
        double bestMatch = Double.NEGATIVE_INFINITY;
        String bestPair = "";

        for (int i = 0; i < personer.length; i++) {
            for (int j = i + 1; j < personer.length; j++) {
                double score = match(personer[i], personer[j]);
                if (score > bestMatch) {
                    bestMatch = score;
                    bestPair = personer[i].getNavn() + " og " + personer[j].getNavn();
                }
            }
        }
        System.out.printf("Beste match er mellom: %s med score %.2f%n", bestPair, bestMatch);    	
	}
	
	static double match(Person a, Person b) {
		
	    Set<String> fellesHobbyer = new HashSet<>(a.getHobbyer());
	    fellesHobbyer.retainAll(b.getHobbyer()); 

	    Set<String> kunHosA = new HashSet<>(a.getHobbyer());
	    kunHosA.removeAll(b.getHobbyer()); 

	    Set<String> kunHosB = new HashSet<>(b.getHobbyer());
	    kunHosB.removeAll(a.getHobbyer()); 

	    int antallFelles = fellesHobbyer.size();
	    int antallKunHosDenEne = kunHosA.size();
	    int antallKunHosDenAndre = kunHosB.size();
	    int antallTotalt = antallFelles + antallKunHosDenEne + antallKunHosDenAndre;

	    if (antallTotalt == 0) {
	        return 0; 
	    }

	    double score = (double) antallFelles - ((double) (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt);
	    return score;
	}
}
