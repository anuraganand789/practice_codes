public class RotateArray{

    public static void main(final String ... args){
        final int[] numbers = {1, 3, 4, 5, 6};
//	rotateMultipleTimes(numbers, 0);
        rotateUsingTempArray(numbers, 124);
	printArray(numbers);
    }

    public static int getAuxArraySize(final int arrayLength, final int noOfTimes){ 
        return (noOfTimes % arrayLength);
    }

    public static void rotateUsingTempArray(final int[] numbers, int noOfTimes){
	final int arrayLength = numbers.length;
	noOfTimes = getAuxArraySize(arrayLength, noOfTimes);
        final int[] auxArray = new int[noOfTimes];
	int iter = 0;
        while(iter < noOfTimes){ 
	    auxArray[iter] = numbers[iter];
	    iter++;
	}
        
	while(iter < arrayLength){
	    numbers[iter - noOfTimes] = numbers[iter];
	    iter++;
	}

        iter = arrayLength - noOfTimes;
        int secondaryIter = 0;
	while(iter < arrayLength){
	    numbers[iter++] = auxArray[secondaryIter++];
	}
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

    public static int rightIndex(final int length, int currentIndex){
        return ++currentIndex >= length ? 0 : currentIndex; 
    }

    public static void printArray(final int[] numbers){
        for(final int number : numbers){
	    System.out.format(" %d", number);
	}
	System.out.println();
    }
}
