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
			
			
		
		}
		@Override
		public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
			// TODO Auto-generated method stub
			return false;
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
		public void leggTil(T element) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void leggTilAlleFra(MengdeADT<T> annenMengde) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public T fjern(T element) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public T[] tilTabell() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public int antallElementer() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	
	
	
	

