import java.util.Arrays;

public class LeadersInArray{
    public static void main(final String ... args){
        int[] numbers = {12, 6, 77, 9, 9, 12};
	printArray(numbers);
	System.out.println();
	final int length = numbers.length;
	int maxOnRight = numbers[length - 1];
	for(int index = length - 1; index > -1; --index){
	    if(numbers[index] >= maxOnRight) {
	        System.out.format("%d is a leader.%n", numbers[index]);
                maxOnRight = numbers[index];
	    }
	}
    }

    private static void printArray(final int[] numbers){
        Arrays.stream(numbers).forEach(LeadersInArray::print);
    }
    
    private static void print(final int number){
        System.out.format("%d ", number);
    }

}
