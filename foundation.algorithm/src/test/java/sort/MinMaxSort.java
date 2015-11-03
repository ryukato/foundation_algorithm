package sort;

public class MinMaxSort<E extends Comparable<E>> extends SelectionSort<E> {

	@Override
	public void sort(E[] source) {
		final int size = source.length;
		for(int last = size -1; last >=1; --last){
			int largest = last;
			int smallest = last;
			boolean isLargest = true;
			for(int current = 0; current <= last; current++){
				if(isGreaterThan(source[current], source[largest])){
					largest = current;
				}else if(isLessThan(source[current], source[smallest])){
					isLargest = false;
					smallest = current;
				}
			}
			
			if(!isLargest){
				swap(source, 0, smallest);
			}else{
				swap(source, last, largest);
			}
		}
	}

	

	protected boolean isLessThan(E e1, E e2) {
		return e1.compareTo(e2) < 0;
	}
}
