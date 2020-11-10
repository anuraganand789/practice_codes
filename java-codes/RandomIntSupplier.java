import java.util.stream.IntStream;
import java.util.function.IntSupplier;

public class RandomIntSupplier {
    private static final IntSupplier randomIntSupplier = () -> (int) (Math.random() * 10);

    public static void main(final String ... args){
	IntStream.generate(randomIntSupplier).limit(10).forEach(System.out::println);
    }
}
