package chapter1.exercise;


public class SmallestNumberFinder extends AbstractFinder<Integer> {
	
	public SmallestNumberFinder() {
		super();
	}
	
	public SmallestNumberFinder(Sorter sorter) {
		super(sorter);
	}

	@Override
	protected int getTargetIndex(Comparable<Integer>[] input) {
		return 0;
	}
}
