public class PrintHello{
    static {
        System.loadLibrary("saymyname");
    }
    private static native void sayMyName(final String myName);

    public static void main(final String ... args){
        sayMyName("Anurag Anand");
    }
}
