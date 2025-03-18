package dat102.uke10.oppg4_mengder;

import java.util.NoSuchElementException;

	class Node<T> {
	    T data;
	    Node<T> neste;

	    public Node(T data) {
	        this.data = data;
	        this.neste = null;
	    }
	}

	public class LenketMengde<T> implements MengdeADT<T> {
		private Node<T> hode;
		private int antall;
	
		public LenketMengde() {
	        this.hode = null;
	        this.antall = 0;
		}
		
		
		@Override
		public boolean erTom() {
			
			return hode == null;
		}
		@Override
		public boolean inneholder(T element) {
			
		Node<T>aktuell = hode;
		while(aktuell !=null) {
			if(aktuell.data.equals(element)) {
				return true;
			}
			aktuell = aktuell.neste;
		}
			return false;
		
		}
		@Override
		public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
			Node<T>aktuell = hode;
			while(aktuell != null) { 
				if(!annenMengde.inneholder(aktuell.data)) {
					return false;
				}
			aktuell = aktuell.neste;
			}
		return true;
		}
		
		@Override
		public boolean erLik(MengdeADT<T> annenMengde) {
			if (antall !=annenMengde.antallElementer()) {
				return false;
			}
			return erDelmengdeAv(annenMengde);
		}
		
		@Override
		public boolean erDisjunkt(MengdeADT<T> annenMengde) {
			Node<T>aktuell = hode;
			while(aktuell !=null) {
				if (annenMengde.inneholder(aktuell.data)) {
					return false;
				}
				aktuell = aktuell.neste;
			}
			return true;


		}
		@Override
		public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
			LenketMengde<T> resultat = new LenketMengde<>();
			Node<T>aktuell = hode;
			while (aktuell !=null) {
				if (annenMengde.inneholder(aktuell.data)) {
					resultat.leggTil(aktuell.data);
				}
				aktuell = aktuell.neste;
			}
			return resultat;
			
		}
		@Override
		public MengdeADT<T> union(MengdeADT<T> annenMengde) {
			LenketMengde<T> resultat = new LenketMengde<>();
			Node<T>aktuell = hode;
			while (aktuell !=null) {
				resultat.leggTil(aktuell.data);
				aktuell = aktuell.neste;
			}
			T[] endreElementer = annenMengde.tilTabell();
			for(T element : endreElementer) {
				resultat.leggTil(element);
			}
			return resultat;
			
		}
		@Override
		public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
			LenketMengde<T> resultat = new LenketMengde<>();
			Node<T>aktuell = hode;
			while(aktuell != null) {
				if(!annenMengde.inneholder(aktuell.data)) {
					resultat.leggTil(aktuell.data);
				}
				aktuell = aktuell.neste;
				
			}
			return resultat;
		
		}
		@Override
		public void leggTil(T element) {
			if(!inneholder(element)) {
				Node<T> nyNode = new Node<>(element);
				nyNode.neste = hode;
				hode = nyNode;
				antall++;
			}
			
		}
		@Override
		public void leggTilAlleFra(MengdeADT<T> annenMengde) {
			T[] endreElement =  annenMengde.tilTabell();
			for (T element : endreElement) {
				leggTil(element);
			}
		}
		@Override
		public T fjern(T element) {
		if (erTom()) {
			throw new NoSuchElementException("Denne megnde er tom");
		}
		Node<T> forrige = null;
		Node<T> aktuell = hode;
		while (aktuell != null && !aktuell.data.equals(element)) {
			forrige = aktuell;
			aktuell = aktuell.neste;
		}
		if (aktuell.equals(null)) {
			return null;
		}
		if (forrige.equals(null)) {
			hode = aktuell.neste;
		} else {
			forrige = aktuell.neste;
		} 
		antall--;
		return aktuell.data;
		}
		
			
		
		@Override
		public T[] tilTabell() {
			@SuppressWarnings("Ikke sjekket")
			T[] tabell = (T[]) new Object[antall];
			Node<T> aktuell = hode;
			int indeks = 0;
			while (aktuell != null) {
				tabell[indeks++] = aktuell.data;
				aktuell = aktuell.neste;
			}
			return tabell;
			
		
		}
		@Override
		public int antallElementer() {
			return antall;
		}
	}
	
	
	
	
	

