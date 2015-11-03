package sort;


public class BubbleSort<E extends Comparable<E>> {

	public int sort(E[] source) {
		int size = source.length;
		boolean isSorted = false;
		int swapCount = 0;
		for(int pass = 1; pass < size && (!isSorted); pass++){
			isSorted = true;
			for(int current = 0; current < size - pass; current++){
				if(isGreaterThan(source[current], source[current + 1])){
					isSorted = false;
					swap(source, current, current + 1);
					swapCount++;
				}
			}
		}
		return swapCount;
		
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
