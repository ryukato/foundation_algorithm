package search;

import util.ComparableUtil;


public class BinarySearch<E extends Comparable<E>> {
	
	/**
	 * Recursive binary search
	 * @param source
	 * @param target
	 * @param low
	 * @param high
	 * @return
	 */
	public int location(E[] source, E target,  int low, int high){
		if(low > high){
			return -1;
		}else{
			int mid = (int) Math.floor((low + high)/2);
			if(equals(target, source[mid])){
				return mid;
			}else if(less(target, source[mid])){
				return location(source, target, low, mid - 1);
			}else{
				return location(source, target, mid +1, high);
			}	
		}
	}

	protected boolean equals(E c1, E c2) {
		return ComparableUtil.equals(c1, c2);
	}

	protected boolean less(E c1, E c2) {
		return ComparableUtil.less(c1, c2);
	}
	
}
