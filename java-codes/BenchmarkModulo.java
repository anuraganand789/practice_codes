public class BenchmarkModulo{
    public static void main(final String[] args){
	final int endInteger = Integer.MAX_VALUE;

        long startTime = System.nanoTime();

        int numberIsThree = 0;
        int numberIsFive  = 0;

        for(int anyNumber = 1; anyNumber < endInteger; ++anyNumber){
            ++numberIsThree;
            ++numberIsFive;

            if(numberIsThree == 3) { numberIsThree = 0;} 
            if(numberIsFive  == 5) { numberIsFive  = 0;} 

        }

        long endTime   = System.nanoTime();

	System.out.format("Total time in modulo replacement is %d nanos.%n", (endTime - startTime));

        startTime = System.nanoTime();
	
         for(int anyNumber = 1; anyNumber < endInteger; ++anyNumber){
             if(anyNumber % 3 == 0) { } 
             if(anyNumber % 5 == 0) { } 
         }

        endTime   = System.nanoTime();

	System.out.format("Total time in modulo is %d nanos.%n", (endTime - startTime));
    }
}
