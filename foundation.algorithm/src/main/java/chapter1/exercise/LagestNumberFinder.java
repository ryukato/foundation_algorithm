package chapter1.exercise;

/**
 * Exercise 1.1
 * Using merge sort, it finds the largest number in the given array.
 */
public class LagestNumberFinder extends AbstractFinder<Integer> {
	
	public LagestNumberFinder() {
		super();
	}
	
	public LagestNumberFinder(Sorter<Integer> sorter) {
		super(sorter);
	}

	@Override
	protected int getTargetIndex(Comparable<Integer>[] input) {
		return input.length -1;
	}
}
