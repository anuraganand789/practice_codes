public class FizzBuzz{
    public static void main(final String[] args){
        int end = 100;//Integer.MAX_VALUE;

	long startTime = System.nanoTime();
	int count;
	for(count  = 1; count < end; ++count){
	    if(count % 3 == 0){ System.out.println("Fizz");}
	    if(count % 5 == 0){ System.out.println("Buzz");}
	}
	long endTime   = System.nanoTime();
	System.out.format("Nano time diff is %d, count is %d.%n", endTime - startTime, count);

	startTime = System.nanoTime();
	int count3 = 0;
	int count5 = 0;
	for(count  = 1; count < end; ++count){
	    ++count3;
	    ++count5;

	    if(count3 == 3){ System.out.println("Fizz");count3 = 0;}
	    if(count5 == 5){ System.out.println("Buzz");count5 = 0;}
	}
	endTime   = System.nanoTime();
	System.out.format("Nano time diff is %d, count is %d.%n", endTime - startTime, count);
    }
}
