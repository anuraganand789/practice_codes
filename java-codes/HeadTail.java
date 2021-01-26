public class HeadTail{
    public static void main(final String ... args){
        final int[][] tests = {
			          {1, 0, 1, 0, 1, 1},
				  {0, 1, 0},
				  {1, 0, 1},
				  {1, 1, 0, 1, 1},
				  {0, 1, 1, 0},
				  {0, 0, 0, 0, 0, 0}

	                      };
        

        for(int[] test : tests) {
            System.out.format("minimum Number of flips needed %d.%n", numberOfFlips(test));
	}
    }
    
    private static int numberOfFlips(int[] coins){
	if(coins == null) return 0;

        int length = coins.length;

	if(length < 2) return 0;

	int[] startsWithOne = new int[length];
	setAlternateOnes(startsWithOne, 0, length);

	int numberOfFlipsStartingWithOne  = numberOfLocationsWhereDataDoesNotMatch(coins, startsWithOne, length);

	int[] startsWithZero = new int[length];
	setAlternateOnes(startsWithZero, 1, length);

	int numberOfFlipsStartingWithZero = numberOfLocationsWhereDataDoesNotMatch(coins, startsWithZero, length);
        
	return Math.min(numberOfFlipsStartingWithOne, numberOfFlipsStartingWithZero);
    }

    private static int numberOfLocationsWhereDataDoesNotMatch(final int[] arrayOne, final int[] arrayTwo, final int length){
	int diffCount = 0;
        for(int index = 0; index < length; ++index) if(arrayOne[index] != arrayTwo[index]) ++diffCount;
	return diffCount;
    }
    
    private static void setAlternateOnes(final int[] coins, final int startIndex, final int length){
        for(int index = startIndex; index < length; index = index + 2) coins[index] = 1;
    }

    private static void printArray(final int[] arrayOfInts){
        for(int integer : arrayOfInts){
	    System.out.format("%d ", integer);
	}

	System.out.println();
    }
}
