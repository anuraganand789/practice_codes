public class DoubleBinaryOperator{
    public static void main(final String ... args){
        final java.util.function.DoubleBinaryOperator dbo = (x, y) -> Math.sqrt(Math.pow(x, 2) * Math.pow(y, 2));
	System.out.format("hypotenuse %.2f and %5.2f => %.1f. %n", 100d, 100d, dbo.applyAsDouble(100d, 100d));
    }
}
