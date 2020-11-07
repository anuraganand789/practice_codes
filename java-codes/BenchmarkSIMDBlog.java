import java.util.Random;
public class BenchmarkSIMDBlog
{
    public static final int SIZE = 1024;

    public static class Context
    {
        public final int[] values = new int[SIZE];
        public final int[] results = new int[SIZE];

        public void setup()
        {
            Random random = new Random();
            for (int i = 0; i < SIZE; i++) {
                values[i] = random.nextInt(Integer.MAX_VALUE / 32);
            }
        }
    }

    public static int[] increment(Context context)
    {
        for (int i = 0; i < SIZE; i++) {
            context.results[i] = context.values[i] + 1;
        }
        return context.results;
    }

    public static int[] hashLoop(Context context)
    {
        for (int i = 0; i < SIZE; i++) {
            context.results[i] = getHashPosition(context.values[i], 1048575);
        }
        return context.results;
    }

    private static int getHashPosition(int rawHash, int mask)
    {
        rawHash ^= rawHash >>> 15;
        rawHash *= 0xed558ccd;
        rawHash ^= rawHash >>> 15;
        rawHash *= 0x1a85ec53;
        rawHash ^= rawHash >>> 15;

        return rawHash & mask;
    }

    public static void main(final String ... args){
	BenchmarkSIMDBlog.Context context = new BenchmarkSIMDBlog.Context();
	context.setup();

        //final long start = System.currentTimeMillis();
	int noOfIter = 10;
	long nanosTotal = 0; 
	for(int i = 0; i < noOfIter; ++i){
            final long start = System.nanoTime();
//	    increment(context);
            hashLoop(context);
            final long end   = System.nanoTime();
	    nanosTotal += (end - start);
	}

	System.out.println("Avg for " + noOfIter + " iterations in nanos " + nanosTotal / noOfIter);
    }
}
