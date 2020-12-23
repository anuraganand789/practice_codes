import java.util.Arrays;

public class SearchInPivotedArray{
    public static void main(final String ... args){
        final int[] dataSet = { 6,7, 8, 9, 1, 2, 3, 5 };
	final int lastIndex = dataSet.length - 1;
	final int key = 3;

	final int pivot = thePivot(dataSet);
	System.out.format("Pivot %d.%n", pivot);
	int   index     = Arrays.binarySearch(dataSet, 0, pivot + 1, key);
	if  (index < 0) index = Arrays.binarySearch(dataSet, pivot + 1, lastIndex + 1, key);
	if  (index < 0) System.out.format("%d is not found .%n", key);
	else            System.out.format("%d is found at %d.%n", key, index);
    }

    private final static int thePivot(final int[] dataSet){

        int low = 0;
	int high = dataSet.length - 1;
	int currNumber;
	int numberOnLeft;
	int numberOnRight;
	int mid;
	int numberOnLowIndex;
	int numberOnHighIndex;

	while(true){

	    mid = (high - low)/2 + low;

	    currNumber = dataSet[mid];

	    numberOnLeft  = dataSet[mid - 1];
	    numberOnRight = dataSet[mid + 1];

	    numberOnLowIndex  = dataSet[low];
	    numberOnHighIndex = dataSet[high];

	    if(currNumber > numberOnRight) return mid;
	    if(currNumber < numberOnLeft ) return mid;
	    if(currNumber < numberOnLowIndex) {
	        high = mid - 1;
		continue;
	    }
	    if(currNumber > numberOnHighIndex) {
	        low = mid + 1;
		continue;
	    }
	}
    }
}
