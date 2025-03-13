package dat102.uke10.oppg4_mengder;

public class TabellMengde<T> {

/**
	 * En implementasjon av BagADT
	 * 
	 * @author Lars-Petter Helland
	 */
		private static final int DEFAULT_KAPASITET = 10;

		private T[] tabell;
		private int antall;

		/************************************************************/

		public TabellMengde() {
			this(DEFAULT_KAPASITET);
		}

		@SuppressWarnings("unchecked")
		public TabellMengde(int kapasitet) {
			tabell = (T[]) new Object[kapasitet];
			antall = 0;
		}

		public int getCurrentSize() {
			return antall;
		}

		public boolean isEmpty() {
			return antall == 0;
		}

		private boolean erFull() {
			return antall == tabell.length;
		}
		
		public boolean add(T newEntry) {
			
			if (erFull()) {
				return false;
			}
			
			tabell[antall] = newEntry;
			antall++;
			return true;
		}

		public T remove() {
			
			if (isEmpty()) {
				return null;
			}
			
			T element = tabell[antall-1];
			tabell[antall-1] = null;
			antall--;
			return element;
		}

		public boolean remove(T anEntry) {
			// TODO Auto-generated method stub
			return false;
		}

		public void clear() {
			// TODO Auto-generated method stub
			
		}

		public int getFrequencyOf(T anEntry) {
			// TODO Auto-generated method stub
			return 0;
		}

		public boolean contains(T anEntry) {
			
			for (int i = 0; i < antall; i++) {
				if (tabell[i].equals(anEntry)) {
					return true;
				}
			}
			return false;
		}

		public T[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		/************************************************************/

	}


