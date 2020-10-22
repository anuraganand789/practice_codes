public class ForEachLoopAndForExplicitIteration{
    public static void main(final String... args){
        final int[] vals = {1, 3, 4};

	final var arrLen = vals.length;
	for(int i = 0; i < arrLen; ++i) System.out.println(vals[i]);

	for(int val : vals) System.out.println(val);
    }
}
