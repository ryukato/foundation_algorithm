package search;

public class IterativeBinarySearch<E extends Comparable<E>> extends BinarySearch<E>{

	@Override
	public int location(E[] source, E target,  int low, int high) {
		if(low > high){
			return -1;
		}
		
		int lo = low, hi = high;
		while(lo <= high){
			int mid = (int) Math.floor((lo + hi)/2);
			if(equals(target, source[mid])){
				return mid;
			}else if(less(target, source[mid])){
				hi = mid -1;
			}else{
				lo = mid +1;
			}	
		}
		return -1;
	}
}
