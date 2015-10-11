package chapter1.exercise;



public class InsertionSortWithBinarySearch extends InsertionSorter{
	
	@SuppressWarnings("rawtypes")
	@Override
	public Comparable[] sort(Comparable[] input) {
		int totalLen = input.length;
		Comparable[] copy = input.clone();
		for(int i = 0; i < totalLen; i++){
			//Using binary-searching, reduce second loop count.
			int insertIndex = getInsertionIndex(copy, copy[i], 0, i);
			if(insertIndex >= 0 && insertIndex < i){
				Comparable tmp = copy[i];
	            //shift
				for (int j = i - 1; j >= insertIndex; j--){
					copy[j + 1] = copy[j];
					//System.out.println(toStringOf(copy));
				}
	            copy[insertIndex] = tmp;
	            //System.out.println("sorted "+ toStringOf(copy));
			}
		}
		return copy;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private int getInsertionIndex(Comparable[] input, Comparable key, int low, int high) {
	  
	    while(low <= high){
	    	if (low == high){
		    	 return low;
		    }
	    	int mid = low + ((high - low) / 2);
	    	if (key.compareTo(input[mid]) > 0){
		    	low = mid + 1;
		    }else if (key.compareTo(input[mid]) < 0){
		    	high = mid;
		    }else{
		    	return mid;
		    }
	    }
	    return -1;
	}
	
	
}
