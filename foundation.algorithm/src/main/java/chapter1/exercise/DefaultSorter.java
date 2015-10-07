package chapter1.exercise;

import java.util.Arrays;

public class DefaultSorter<E> implements Sorter<E> {

	@Override
	public Comparable<E>[] sort(Comparable<E>[] input) {
		Comparable<E>[] copy = input.clone();
		Arrays.sort(copy, new java.util.Comparator<Comparable<E>>(){
			@SuppressWarnings("unchecked")
			@Override
			public int compare(Comparable<E> o1, Comparable<E> o2) {
				return o1.compareTo((E) o2);
			}
			
		});
		return copy;
	}

}
