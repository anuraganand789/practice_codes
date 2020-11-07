public class JavaNoSIMD{
    public static void main(final String ... args){
	final int arrSize = 10_00_000;
        final int[] x = new int[arrSize];
        final int[] y = new int[arrSize];
        final int[] z = new int[arrSize];

	long start = System.currentTimeMillis();
	{
	    int count = 1;
	    for(int i = 0; i < arrSize; ++i){
		count++;
	        x[i] = count;
	        y[i] = count;
		z[i] = x[i] * y[i];
	    }
	}
	System.out.println("Milliseconds " + (System.currentTimeMillis() - start));
    }
}
