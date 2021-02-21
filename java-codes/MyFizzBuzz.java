public class MyFizzBuzz{
    private static void fizzbuzz(){

        boolean itIsDivisibleByThree = false;
        boolean itIsDivisibleByFive  = false;
        boolean itIsDivisibleByNone  = false;

	for(int currentNumber = 1; currentNumber < 101; ++currentNumber){

	    itIsDivisibleByThree = currentNumber % 3 == 0;
	    itIsDivisibleByFive  = currentNumber % 5 == 0;
	    itIsDivisibleByNone  = !(itIsDivisibleByThree || itIsDivisibleByFive);

	    System.out.format((itIsDivisibleByNone ? "%d.%n" : "%s.%n" ),
	                      (itIsDivisibleByNone ? currentNumber : (itIsDivisibleByThree ? "Fizz" : "") + (itIsDivisibleByFive ? "Buzz" : "")));
	}

    }

    private static void fizzbuzzBetter(){

        boolean itIsDivisibleByThree = false;
        boolean itIsDivisibleByFive  = false;
        boolean itIsDivisibleByNone  = false;

	for(int currentNumber = 1; currentNumber < 101; ++currentNumber){

	    itIsDivisibleByThree = currentNumber % 3 == 0;
	    itIsDivisibleByFive  = currentNumber % 5 == 0;
	    itIsDivisibleByNone  = !(itIsDivisibleByThree || itIsDivisibleByFive);

	    System.out.println((itIsDivisibleByNone ? currentNumber : (itIsDivisibleByThree ? "Fizz" : "") + (itIsDivisibleByFive ? "Buzz" : "")));
	}

    }

    public static void main(final String[] args){
        fizzbuzzBetter();
    }
}
