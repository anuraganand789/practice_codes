import java.util.function.IntToDoubleFunction;

public class IntToDoubleImpl{
    private static final IntToDoubleFunction castIntToDouble = (intValue) -> intValue * 1.0;

    public static void main(final String ... args){
        System.out.println(castIntToDouble.applyAsDouble(12));
    }
}
