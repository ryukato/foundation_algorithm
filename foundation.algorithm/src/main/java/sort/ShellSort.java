package sort;


public class ShellSort<E extends Comparable<E>> {

	private static final int DEFAULT_HOP_SIZE = 3;

	public void sort(E[] source) {
		int size = source.length;
		int hop = 1;
		while(hop < size/DEFAULT_HOP_SIZE){
			hop = DEFAULT_HOP_SIZE * hop +1;
		}
		while(hop >=1){
			for(int outerIdx = hop; outerIdx < size; outerIdx++){
				for(int j = outerIdx; j >= hop && isGreaterThan(source[j - hop], source[j]); j-=hop){
					swap(source, j - hop, j);
				}
				System.out.println("hop = "+ hop + ", outerIdx ="+ outerIdx);
				print(source);
			}
			hop /=DEFAULT_HOP_SIZE;
		}
	}
	
	protected boolean isGreaterThan(E e1, E e2) {
		return e1.compareTo(e2) > 0;
	}
	
	protected void swap(E[] source, int from, int to) {
		E tmp = source[from];
		source[from] = source[to];
		source[to] = tmp;
	}
	
	private void print(E[] source){
		for(int i = 0; i < 10 ; i++){
			System.out.print(source[i] + ", ");
		}
		System.out.println("");
	}

}
