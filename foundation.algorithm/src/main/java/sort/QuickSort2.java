package sort;

import util.ComparableUtil;

public class QuickSort2<E extends Comparable<E>> {
	private int partition(E[] source, int first, int last){
		int low = first;
		int pivot = last;
		int high = last - 1;
		
		while(low <= high){
			while(less(source[low], source[pivot])){
				low++;
			}
			while(less(source[pivot], source[high])){
				high--;
				if(high < 0){
					break;
				}
			}
			if(low <= high){
				exchange(source, low, high);
			}
			
		}
		exchange(source, low, pivot);
		return low;
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
