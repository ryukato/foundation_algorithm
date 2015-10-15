package sort;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import util.ComparableUtil;

public class QuickSort<E extends Comparable<E>> {
	public void sort(E[] source, int low, int high){
		int pivotIndex = 0;
		if(high > low){
			pivotIndex = partition(source, low, high, pivotIndex);
			sort(source, low, pivotIndex -1);
			sort(source, pivotIndex + 1, high);
		}
	}

	private int partition(E[] source, int low, int high, int pivotIndex) {
		
		int j = low;
		E pivotItem = source[low];
		for(int i = low +1; i <= high; i++){
			if(less(source[i], pivotItem)){
				j++;
				exchange(source, i, j);
			}
			pivotIndex = j;
		}
		exchange(source, low, pivotIndex);
		print(source, low, high, pivotIndex);
		return pivotIndex;
	}
	
	private void print(E[] source, int low, int high, int pivotIndex) {
		E pivotItem = source[pivotIndex];
		String joinedElements = Arrays.stream(source).map(new Function<E, String>() {

			@Override
			public String apply(E t) {
				if(pivotItem.equals(t)){
					return String.format("|%s|", String.valueOf(t));
				}else{
					return String.valueOf(t);
				}
			}
			
		}).collect(Collectors.joining(" "));
		System.out.println(joinedElements);
	}

	private void exchange(E[] source, int i, int j){
		E tmp = source[i];
		source[i] = source[j];
		source[j] = tmp;
	}
	
	private boolean less(E e1, E e2) {
		return ComparableUtil.less(e1, e2);
	}
	
}
