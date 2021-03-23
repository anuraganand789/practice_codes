import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CurryingJava{
    
    final static BiFunction<Map<String, String>, String, Consumer<String>> 
    curryMap = (map, defaultValue) -> (someStringValue) -> map.put(someStringValue, defaultValue);

    public static void main(final String ...args){
       final List<String> list = List.of("firstName", "lastName", "Age"); 
       final Map<String, String> map = new HashMap<>();
       updateWithNullValues(map, list);

       System.out.println("Map -> " + map.toString());
    }

    public static void 
    updateWithNullValues(final Map<String, String> map, final List<String> listOfColumns){
        if(map == null) return ;

        final Consumer<String> 
        curryWithNull = curryMap.apply(map, null);

        listOfColumns
        .stream()
        .forEach(curryWithNull::accept);
    }
}
