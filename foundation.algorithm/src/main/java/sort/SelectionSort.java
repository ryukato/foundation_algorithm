package sort;

public class SelectionSort<E extends Comparable<E>> {
	public void sort(E[] source){
		final int size = source.length;
		for(int last = size - 1; last >= 1; --last){
			int largest = last;
			for(int current = 0;  current <= last; current++){
				if(isGreaterThan(source[current], source[largest])){
					largest = current;
				}
			}
			if(largest != last){
				swap(source, last, largest);
			}
			
		}
	}

	protected boolean isGreaterThan(E e1, E e2) {
		return e1.compareTo(e2) > 0;
	}
	
	protected void swap(E[] source, int from, int to) {
		E tmp = source[from];
		source[from] = source[to];
		source[to] = tmp;
	}
}
