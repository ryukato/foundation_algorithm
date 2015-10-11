package chapter1.exercise;

class MergeSorter implements Sorter{
	@SuppressWarnings("rawtypes")
	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
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

    @SuppressWarnings("rawtypes")
    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
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
    @SuppressWarnings("rawtypes")
	@Override
	public Comparable[] sort(Comparable[] a) {
    	Comparable[] copy = a.clone();
    	Comparable[] aux = new Comparable[a.length];
        sort(copy, aux, 0, a.length-1);
        return copy;
    }


   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    
}