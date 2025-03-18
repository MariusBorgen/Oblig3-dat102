package oppgave4Del2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class BinærVSHashSet {

    static int antallElementer = 100_000;
    static int maxVerdi = 1_000_000;
    static int søkeAntall = 10_000;

    static Random random = new Random();

    public static void main(String[] args) {
        
        HashSet<Integer> hs = new HashSet<>();
        int[] tab = new int[antallElementer];

        
        generer(hs, tab);

       
        Arrays.sort(tab);


        int[] søketall = genererSøketall();


        long tidHashSet = målTid(() -> søkIHashSet(hs, søketall));


        long tidBinarySearch = målTid(() -> søkIBinarySearch(tab, søketall));


        System.out.println("\nTid for søk i HashSet: " + tidHashSet + " ms");
        System.out.println("Tid for søk i Binærsøk: " + tidBinarySearch + " ms");
    }

    public static void generer(HashSet<Integer> hs, int[] tab) {
        int tall = 376;
        for (int i = 0; i < antallElementer; i++) {
            hs.add(tall);
            tab[i] = tall;
            tall = (tall + 45713) % maxVerdi;
        }
    }

    private static int[] genererSøketall() {
        int[] søketall = new int[søkeAntall];
        for (int i = 0; i < søkeAntall; i++) {
            søketall[i] = random.nextInt(maxVerdi); 
        }
        return søketall;
    }

    private static int søkIHashSet(HashSet<Integer> hashSet, int[] søketall) {
        int funnet = 0;
        for (int søk : søketall) {
            if (hashSet.contains(søk)) {
                funnet++;
            }
        }
        System.out.println("Antall treff i HashSet: " + funnet);
        return funnet;
    }

    private static int søkIBinarySearch(int[] tabell, int[] søketall) {
        int funnet = 0;
        for (int søk : søketall) {
            if (Arrays.binarySearch(tabell, søk) >= 0) {
                funnet++;
            }
        }
        System.out.println("Antall treff i Binærsøk: " + funnet);
        return funnet;
    }

    private static long målTid(Runnable metode) {
        long start = System.nanoTime();
        metode.run();
        return (System.nanoTime() - start) / 1_000_000; // Konverter til ms
    }
}
