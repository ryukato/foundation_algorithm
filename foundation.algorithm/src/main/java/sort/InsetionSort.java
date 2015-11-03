package sort;

public class InsetionSort<E extends Comparable<E>>{

	public void sort(E[] source) {
		int size = source.length;
		for(int pick = 1; pick < size; pick++){
			int current = pick;
			E tmp = source[current];
			for(; current > 0 && isGreaterThan(source[current -1], tmp); current--){
				source[current] = source[current -1];
			}
			source[current] = tmp;
		}
		
	}
	
	protected boolean isGreaterThan(E e1, E e2) {
		return e1.compareTo(e2) > 0;
	}

}
