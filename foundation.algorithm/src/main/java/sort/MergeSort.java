package sort;

import util.ComparableUtil;


public class MergeSort<E extends Comparable<E>> {
	public void sort(E[] source, int low, int high){
		if(low < high){
			int mid = (int) Math.floor((low + high)/2);
			sort(source, low, mid);
			sort(source, mid +1, high);
			merge(source, low, mid, high);
		} 
	}

	private void merge(E[] source, int low, int mid, int high) {
		int i = low, j = mid +1;
		E[] tmp = source.clone();
		
		for(int k = low; k <= high; k++){
			if(i > mid){
				source[k] = tmp[j++];
			}else if(j > high){
				source[k] = tmp[i++];
			}
			else if(less(tmp[i], tmp[j])){
				source[k] = tmp[i];
				i++;
			}else{
				source[k] = tmp[j];
				j++;
			}
		}
	}

	private boolean less(E e1, E e2) {
		return ComparableUtil.less(e1, e2);
	}
}
