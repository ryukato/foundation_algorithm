package chapter1.exercise;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class AbstractFinder<E extends Comparable> implements Finder<E>{
	private Sorter sorter = new DefaultSorter();
	
	public AbstractFinder() {
		super();
	}
	
	public AbstractFinder(Sorter sorter) {
		super();
		this.sorter = sorter;
	}
	
	
	@Override
	public E find(E[] input) {
		if(input == null){
			throw new IllegalArgumentException("input can NOT be null");
		}
		if(input.length == 1){
			return input[0];
		}
		
		return (E) sorter.sort(input)[getTargetIndex(input)];
	}

	protected abstract int getTargetIndex(Comparable<E>[] input);
}
