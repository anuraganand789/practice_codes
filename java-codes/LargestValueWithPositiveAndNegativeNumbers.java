import java.util.Arrays;

public class LargestValueWithPositiveAndNegativeNumber{
    public static void main(final String[] commandLineArguments){
        final int[][] tests = {
			          {3, 2, -2, 5, -3},
				  {1, 1, 2, -1, 2, -1},
				  {1, 2, 3, -4},
				  {-1, -2},
				  {1, 2},
				  {-99, 100, -101},
				  {-99, 100, -101, 99, 100}
	                      };

        for(int[] test : tests){
	    System.out.format("%d is largest.%n", largestValue(test));
	}
    }

    private static int largestValue(final int[] arrayOfIntegers){
        if(arrayOfIntegers == null) return 0;

	final int lenghtOfTheArray = arrayOfIntegers.length;
        if(lenghtOfTheArray == 0) return 0;

	Arrays.sort(arrayOfIntegers);

	//No negative number
	if(arrayOfIntegers[0] > -1) return 0;

	//No positive number
	if(arrayOfIntegers[lenghtOfTheArray - 1] < 1) return 0;

	for(int lastIndex = lenghtOfTheArray - 1; lastIndex >= 0 && arrayOfIntegers[lastIndex] > 0 ; --lastIndex){
	    int currentPositiveNumber = arrayOfIntegers[lastIndex];
	    int negativeValueIsPresentAt = Arrays.binarySearch(arrayOfIntegers, -1 * currentPositiveNumber);
	    if(negativeValueIsPresentAt > -1) return currentPositiveNumber;
	}

	return 0;
    }
}
