import java.util.Map;
import java.util.HashMap;

public interface InterfaceInsideInterface<T>{
    int age = 12;
    void here();
    Map<String, String> m = new HashMap<>();
    String name = "Anurag";
    interface AnotherInterface<String>{
	InterfaceInsideInterface t = null;
	Object n  = "";
        Void name = null; 
	int age = 122;
        void play();
    }
    
    static void display(final String message){ System.out.println("Message " + message); }
    class InsideInterface{
        String name = "InsideInterface";
    }
}
