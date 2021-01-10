import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.LinkedHashMap;

public class MajorityElements{
    public static void main(final String ... args){
        final int[] numbers = { 1, 2, 3, 4, 4, 4, 4};
	final Map<Integer, AtomicInteger> map = new LinkedHashMap<>();

	for(final int number : numbers) {
	    if(map.get(number) == null) { 
	        map.put(number, new AtomicInteger(0)); 
	    } else { 
	        map.get(number).incrementAndGet(); 
	    }
	}

	int number;
	int count  = -1;
	final int countNeeded = numbers.length / 2;
	for(Map.Entry<Integer, AtomicInteger> entry : map.entrySet()){
	    
	}
    }
}
