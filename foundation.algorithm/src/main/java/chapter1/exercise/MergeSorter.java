package chapter1.exercise;

class MergeSorter<E> implements Sorter<E>{
	 // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private void merge(Comparable<E>[] a, Comparable<E>[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if(i > mid){
            	a[k] = aux[j++];
            }
            else if(j > hi){
            	a[k] = aux[i++];
            }
            else if (less(aux[j], aux[i])){
            	a[k] = aux[j++];
            }
            else{
            	 a[k] = aux[i++];
            }
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private void sort(Comparable<E>[] a, Comparable<E>[] aux, int lo, int hi) {
        if (hi <= lo){
        	return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    @Override
	public Comparable<E>[] sort(Comparable<E>[] a) {
    	Comparable<E>[] copy = a.clone();
    	@SuppressWarnings("unchecked")
    	Comparable<E>[] aux = new Comparable[a.length];
        sort(copy, aux, 0, a.length-1);
        return copy;
    }


   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    @SuppressWarnings("unchecked")
	private boolean less(Comparable<E> v, Comparable<E> w) {
        return v.compareTo((E) w) < 0;
    }


    
}