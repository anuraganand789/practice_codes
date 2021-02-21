public class FizzBuzzBetter{
    public static void main(final String[] args){

        boolean divisibleByThree = false;
        boolean divisibleByFive  = false;
        boolean divisibleByNone  = false;

        for(int i = 0; i < 100; ++i){

	    divisibleByThree = i % 3 == 0;
	    divisibleByFive  = i % 5 == 0;
	    divisibleByNone  = !(divisibleByFive || divisibleByThree);

	    System.out.format(divisibleByNone ? "%d %n" : "%s %n", 
	                      divisibleByNone ? i : ((divisibleByThree ? "Fizz" : "")  + 
			                             (divisibleByFive  ? "Buzz" : ""))
                             );
	}

        for(int i = 0; i < 100; ++i){

	    divisibleByThree = i % 3 == 0;
	    divisibleByFive  = i % 5 == 0;
	    divisibleByNone  = !(divisibleByFive || divisibleByThree);

	    System.out.println((divisibleByNone ? i: "") + (divisibleByThree ? "Fizz" : "")  + (divisibleByFive  ? "Buzz" : ""));
	}
    }
}
