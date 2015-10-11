package chapter1.exercise;

import java.util.Arrays;

public class DefaultSorter implements Sorter {

	@SuppressWarnings("rawtypes")
	@Override
	public Comparable[] sort(Comparable[] input) {
		Comparable[] copy = input.clone();
		Arrays.sort(copy, new java.util.Comparator<Comparable>(){
			@SuppressWarnings("unchecked")
			@Override
			public int compare(Comparable o1, Comparable o2) {
				return o1.compareTo(o2);
			}
			
		});
		return copy;
	}

}
