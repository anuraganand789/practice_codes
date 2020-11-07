public class JavaSIMD{
    public static void main(final String ... args){
	final int arrSize = 10_00_000;
        final int[] x = new int[arrSize];
        final int[] y = new int[arrSize];
        final int[] z = new int[arrSize];

	long start = System.currentTimeMillis();
	{
	    int count = 1;
	    for(int i = 0; i < arrSize; ++i){
	        x[i] = count++;
	    }
	    for(int i = 0; i < arrSize; ++i){
	        y[i] = count--;
	    }
	    for(int i = 0; i < arrSize; ++i){
	        z[i] = x[i] * y[i];
	    }
	}
	System.out.println("Milliseconds " + (System.currentTimeMillis() - start));
    }
}
