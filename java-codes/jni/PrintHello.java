public class PrintHello {
    static{
        System.loadLibrary("hello");
    }
    private static native void f(int data, String str);

    public static void main(final String ... args){
	System.out.println("Before calling c function");
        f(19, "Hello From Java");
	System.out.println("After calling c function");
    }

}
