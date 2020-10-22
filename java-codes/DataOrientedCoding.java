public class DataOrientedCoding {
    class Point{ int x, y; }

    //static final int MAX =1_00_00_00_000;
    static final int MAX = 30_00_00_000;

    public static void main(final String ... args){
        final DataOrientedCoding obj = new DataOrientedCoding();
	{
	    Point[] points = new Point[MAX]; 
	    for(int i = 0; i < MAX; ++i) points[i] = obj.new Point();
	    System.out.println("Array of objects created");
	    long start = System.nanoTime();
	    for(final Point point : points) { point.x = 0; point.y = 0; }
	    System.out.format("Array Of Object Time taken %12d.%n", (System.nanoTime() - start));

	    for(int i = 0; i < MAX; ++i) points[i] = null;
	    points = null;
	    System.gc();
	}
	{
            int[] x = new int[MAX];
            int[] y = new int[MAX];
	    long start = System.nanoTime();
	    for(int i = 0; i < MAX; ++i) x[i] = 0;
	    for(int i = 0; i < MAX; ++i) y[i] = 0;
	    System.out.format("Array of Ints Time taken   %12d.%n", (System.nanoTime() - start));
	}
    }
}
