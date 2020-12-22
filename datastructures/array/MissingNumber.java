public class MissingNumber{
    
    public static void main(final String ... args){
        final int[] numbers = {1, 2, 3, 4, 6};
	final int   totalNumbers = 6;
	final int   correctSum = (totalNumbers * (totalNumbers + 1)) / 2;

	int   sum = 0;
	for(final int number : numbers) { sum += number; }
	System.out.format("Missing number %d. %n", correctSum - sum);
    }
}

