package chapter1.exercise;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSorter implements Sorter {

	@SuppressWarnings("rawtypes")
	@Override
	public Comparable[] sort(Comparable[] input) {
		int totalLen = input.length;
		Comparable[] copy = input.clone();
		for(int i = 0; i < totalLen; i++){
			for(int j = i; j > 0; j--){
				//System.out.println(toStringOf(copy));
				if(less(copy[j], copy[j-1])){
					swap(copy, j, j -1);
				}else{break;}
			}
			//System.out.println("sorted "+ toStringOf(copy));
		}
		return copy;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected boolean less(Comparable left, Comparable right){
		return left.compareTo(right) < 0;
	}
	@SuppressWarnings("rawtypes")
	protected void swap(Comparable[] copy, int i, int j) {
		Comparable tmp = copy[i];
		copy[i] = copy[j];
		copy[j] = tmp;
	}
	
	@SuppressWarnings("rawtypes")
	protected String toStringOf(Comparable[] input){
		return Arrays.stream(input).map(i -> String.valueOf(i)).collect(Collectors.joining(", "));
	}

}
