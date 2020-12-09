public class RotateArray{

    public static void main(final String ... args){
        final int[] numbers = {1, 3, 4, 5, 6};
	rotateMultipleTimes(numbers, 0);
	printArray(numbers);
    }

    public static void rotate(final int[] numbers){
	final int length = numbers.length;
	int index = length-1;
        final int last  = numbers[index];

	while(index > 0){
	     numbers[index] = numbers[--index];
	}

	numbers[0] = last;
    }

    public static void rotateMultipleTimes(final int[] numbers, int times){
        while(times-- > 0) { rotate(numbers); }
    }

    public static void printArray(final int[] numbers){
        for(final int number : numbers){
	    System.out.format(" %d", number);
	}
	System.out.println();
    }
}
