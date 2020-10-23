public class InnerClassTest{
    
    private class In2 {
       private int age = 100;
    }
    private void testInner(java.util.function.Consumer<Integer> cons){ cons.accept(19); }
    private void test(){
        class InTestMethod{
	    private int age = 0;
	    private void test(final int value){
	        System.out.println("InTestMethod test function " + value);
	    }
	}
	final InTestMethod oo  = new InTestMethod();
	System.out.println(" age " + oo.age);

	testInner((new InTestMethod())::test);
    }

    public static void main(String ... args){
        final InnerClassTest o = new InnerClassTest();
	o.test();
	//access private memebers
	final In2 in = o.new In2();
	int x = in.age;
    }
}
