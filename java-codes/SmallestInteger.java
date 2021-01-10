//This is a demo task.
//Write a function:
//class Solution { public int solution(int[] A); }
//that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//Given A = [1, 2, 3], the function should return 4.
//Given A = [−1, −3], the function should return 1.
//Write an efficient algorithm for the following assumptions:
//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000].

import java.util.Set;
import java.util.HashSet;

public class SmallestInteger{
    public static void main(final String ... args){
        final int[][] tests = {
                                {1, 3, 6, 4, 1, 2},    	
			        {1, 2, 3},
			        {-1, -3},
			        {-3, 1, -3},
			        {1, 100}
                              };
	for(final int[] test : tests){
	    System.out.println("Missing Number " + solution(test));
	}
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        final Set<Integer> integers = new HashSet<>();

        for(final int number : A){
            if(number > max) max = number;
	    if(number < min) min = number;
	    integers.add(number);
        }
	System.out.format("min %d, max %d.%n", min, max);

        if(max <=0 && min <= 0) return 1;

	Integer missingNumber = null;
	int currNumber = min;

	for(; currNumber <= max; ++currNumber){ 
	    if(currNumber > 0 && !integers.contains(currNumber)) {
	        missingNumber = currNumber;
		break;
	    }
	}

	if(missingNumber == null){
	    if(min == 1 || max == 1) missingNumber = max + 1;
	    else missingNumber = min - 1;

	}

	return missingNumber;
    }
}
