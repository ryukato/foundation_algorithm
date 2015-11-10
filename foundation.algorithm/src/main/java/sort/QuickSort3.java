package sort;

import util.ComparableUtil;

public class QuickSort3<E extends Comparable<E>> {

	private int partition(E[] source, int first, int last){
		int i = first;
		int j = last +1;
		while(true){
			while(less(source[++i], source[first])){
				if(i == last){
					break;
				}
			}
			
			while(less(source[first], source[--j])){
				if(j == first){
					break;
				}
			}
			if(i >= j){break;}
			exchange(source, i, j);
		}
		exchange(source, first, j);
		return j;
	}
	
	public void sort(E[] source, int first, int last){
		if(first < last){
			int pivotIndex = partition(source, first, last);
			sort(source, first, pivotIndex - 1);
			sort(source, pivotIndex + 1, last);
		}
	}
	
	
	private boolean less(E e1, E e2) {
		return ComparableUtil.less(e1, e2);
	}
	
	private void exchange(E[] source, int i, int j){
		E tmp = source[i];
		source[i] = source[j];
		source[j] = tmp;
	}


}
