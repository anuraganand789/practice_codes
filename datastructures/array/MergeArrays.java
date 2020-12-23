public class MergeArrays{
    public static void main(final String ... args){

        final int[] smallerArray = { 1, 2, 4, 6};
	final int   sizeOfSmallerArray = smallerArray.length;

	final int[] largerArray  = { 5, -1, 7, -1, 8, -1 , -1};
	final int   sizeOfLargerArray =  largerArray.length;

	printArray(largerArray);
	moveElementsAtTheEnd(largerArray, sizeOfLargerArray);
	merge(largerArray, sizeOfLargerArray, smallerArray, sizeOfSmallerArray);
	printArray(largerArray);

    }

    private static void merge(final int[] largerArray,  final int sizeOfLargerArray,
                              final int[] smallerArray, final int sizeOfSmallerArray){ 
			      
	int indexInLargerArray     = sizeOfSmallerArray;
        int indexInSmallerArray    = 0;
	int iteratorInLargerArray  = 0;
        
	while(iteratorInLargerArray < sizeOfLargerArray && indexInSmallerArray < sizeOfSmallerArray){
	    if(largerArray[indexInLargerArray] < smallerArray[indexInSmallerArray]){
	        largerArray[iteratorInLargerArray] = largerArray[indexInLargerArray];
		++indexInLargerArray;
	    } else {
	        largerArray[iteratorInLargerArray] = smallerArray[indexInSmallerArray];
		++indexInSmallerArray;
	    }
	    ++iteratorInLargerArray;
	}
	 
    }

    private static void moveElementsAtTheEnd(final int[] array, final int size){
        int index = size - 1, putIndex = index;

	while(index > -1){
	    if(array[index] != -1){
	        array[putIndex] = array[index];
		--putIndex;
	    }
	    --index;
	}
    }

    private static void printArray(final int[] array){
        for(final int number : array) { System.out.format("%d ", number); }
	System.out.println();
    }
}
