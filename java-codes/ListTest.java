import java.util.List;
import java.util.ArrayList;

public class ListTest {

    public static void main(final String... args){
	//Create an immutable list
        final List<String> listImmutable = List.of("Anurag", "Anand");
	listImmutable.stream().forEach(System.out::println);
	//using list's own forEach function
	listImmutable.forEach(System.out::println);
    }

}
