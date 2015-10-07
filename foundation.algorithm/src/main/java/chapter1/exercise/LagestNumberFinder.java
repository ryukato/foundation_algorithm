package chapter1.exercise;


public class LagestNumberFinder {
	interface Sorter{
		int[] sort(int[] input);
	}
	private Sorter sorter = new MergeSorter();
	
	public LagestNumberFinder() {
		super();
	}
	
	public LagestNumberFinder(Sorter sorter) {
		super();
		this.sorter = sorter;
	}

	public int find(int[] input) {
		if(input == null){
			throw new IllegalArgumentException("input can NOT be null");
		}
		if(input.length == 1){
			return input[0];
		}
		
		return sorter.sort(input)[input.length -1];
	}
	
	private class MergeSorter implements Sorter{
		public int[] sort(int[] input){
			int[] copy = new int[input.length];
			System.arraycopy(input, 0, copy, 0, input.length);
			sort(copy, 0, copy.length - 1);
			return copy;
		}
		
		private void sort(int[] input, int lo, int hi) {
			if(hi <= lo)return;
			int mid = lo + (hi -lo) / 2;
			sort(input, lo, mid);
			sort(input, mid +1, hi);
			merge(input,lo, mid, hi);
			
		}
		
		private void merge(int[] input, int lo, int mid, int hi) {
			int[] aux = new int[input.length];
			for(int k = lo; k <= hi; k++){
				aux[k] = input[k];
			}
			int i = lo, j = mid +1;
			for(int k = lo; k <= hi; k++){
				if(i > mid){
					input[k] = aux[j++];
				}else if(j > hi){
					input[k] = aux[i++];
				}else if(aux[j] < aux[i]){
					input[k] = aux[j++];
				}else{
					input[k] = aux[i++];
				}
			}
			
		}
	}
	
	
	
}
