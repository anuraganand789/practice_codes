public class SignOfProduct{
    public static void main(final String ... args){
        final int[][] tests = {
	                        {1, -2, -3, 5},
				{1, 2, 3, -5},
				{1, 2, 0, 5},
				{-1, -2, 0, -5},
	                        {1, 2, 3, 5}
			      };

        for(final int[] test : tests){
	    System.out.format("Sign of multiplication is %d.%n", solution(test));
	}
    }

    public static int solution(int[] A) {
	int numberOfOddNumbers = 0;
        for(final int number : A){
	    if(number == 0) return 0;
	    if(number < 0)  ++numberOfOddNumbers;
	}

	return numberOfOddNumbers % 2 == 0 ? 1 : -1;
    }
}
