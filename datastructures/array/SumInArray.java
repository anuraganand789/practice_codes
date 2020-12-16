import java.util.Arrays;

public class SumInArray{
    public static void main(final String ... args){
        final int[] numbers = {1, 2, 3, 5, 8, 10, 12};
	final int sum = 13;
        sumInArray(numbers, sum);
    }

    private static void sumInArray_2(final int[] numbers, final int sum){
	final int arrLength = numbers.length;
	int index = 0; 
	int searchIndex = -1;
	while(index < arrLength && numbers[index] < sum){
	    int diff = sum - numbers[index];
	    searchIndex = Arrays.binarySearch(numbers, diff);
	    if(searchIndex > -1) break;
	    ++index;
	}

	System.out.format("Found at %d + %d.%n", index, searchIndex);
    }
    private static void sumInArray(final int[] numbers, final int sum){
	final int numbersLength = numbers.length;
        int left = 0;
	int right = numbersLength - 1;

	int valueOnLeft;
	int valueOnRight;
	int currentSum;

	while(left < right){

	    valueOnLeft  = numbers[left];
	    valueOnRight = numbers[right];
	    currentSum   = valueOnLeft + valueOnRight;

	    if(currentSum == sum){ 
	        System.out.format("Sum of numbers %d - %d.%n", numbers[left], numbers[right]); 
	        break;
	    } 
	    else if(currentSum < sum) { ++left; }
	    else { --right; }
	}
    }
    
}
