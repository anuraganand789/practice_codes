import java.util.function.IntToLongFunction;

public class IntToLongFunctionImpl{
    
    public static void main(final String ... args){
        final IntToLongFunction intToLong = (intValue) -> intValue * 1L;
	System.out.format("Int to long %d.%n", intToLong.applyAsLong(10));
    }
}
