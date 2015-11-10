package sort;

import util.ComparableUtil;
/**
 * reference: http://algs4.cs.princeton.edu/22mergesort/
 */
public class MergeSort2<E extends Comparable<E>>{
	public void sort(E[] source, int low, int high) {
		if(low < high){
			int mid = (int) Math.floor((low + high)/2);
			sort(source, low, mid);
			sort(source, mid+1, high);
			merge(source, low, mid, high);
		}
		
	}
	
	private void merge(E[] source, int low, int mid, int high){
		@SuppressWarnings({"unchecked" })
		E[] aux = (E[]) new Comparable[source.length];
		System.arraycopy(source, 0, aux, 0, source.length);
		int first1 = low;
		int first2 = mid + 1;
		
		for(int index = low; index <= high; index++){
			if(first1 > mid){ 					// handle left remaining elements
				source[index] = aux[first2++];
			}else if(first2 > high){			// handle right remaining elements	
				source[index] = aux[first1++];
			}else if(less(aux[first1], aux[first2])){
				source[index] = aux[first1++];
				
			}else{
				source[index] = aux[first2++];
			}
		}
	}
	
	private boolean less(E e1, E e2) {
		return ComparableUtil.less(e1, e2);
	}

}
