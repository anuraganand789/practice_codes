public class MaxSumNonAdjacent{
    public static void main(final String ... args){
        final int[] dataSet = { 5, 5, 10, 40, 50, 35 };

	int sumIncludingLastNumber = 5;
	int sumExcludingLastNumber = 0;

	final int lengthOfDataSet = dataSet.length;
	int sumIncluding;
	for(int index = 1; index < lengthOfDataSet; ++index){
	    sumIncluding = sumIncludingLastNumber;
            System.out.format("Exlcude %d, Include %d.%n", sumExcludingLastNumber, sumIncludingLastNumber);
	    sumIncludingLastNumber = sumExcludingLastNumber + dataSet[index];
	    sumExcludingLastNumber = Math.max(sumExcludingLastNumber, sumIncluding);
	}

        System.out.format("Exlcude %d, Include %d.%n", sumExcludingLastNumber, sumIncludingLastNumber);
    }
}
