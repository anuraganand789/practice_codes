//Largest Sum In Contiguous array

public class LargestSum{
    public static void main(final String ... args){
        final int[] dataSet = { -2, -3, 4, -1, -2, 1, 5, -3 };
	final int   dataSetLength = dataSet.length;

	final int subArraySize = 5;

	int leftIndex  = 0,                maxLeftIndex  = leftIndex;
	int rightIndex = subArraySize - 1, maxRightIndex = rightIndex;

	int currentSum = 0;

	for(int index = leftIndex; index <= rightIndex; ++index){ currentSum += dataSet[index]; }
        
	int maxSum = currentSum;
	int subtractFromSum;
	int addToSum;

	while(rightIndex < dataSetLength){

	    subtractFromSum = dataSet[leftIndex];
	    ++leftIndex; 

	    ++rightIndex;
	    if(rightIndex == dataSetLength) break;

	    addToSum = dataSet[rightIndex];

	    currentSum -= subtractFromSum;
	    currentSum += addToSum;

            System.out.format("Current Sum %d, left index %d, right index %d.%n", maxSum, leftIndex, rightIndex);

	    if(maxSum < currentSum) {
	        maxSum        = currentSum;
	        maxLeftIndex  = leftIndex;
		maxRightIndex = rightIndex;
	    }
	}

	System.out.format("Max Sum %d, left index %d, right index %d.%n", maxSum, maxLeftIndex, maxRightIndex);
    }
}
