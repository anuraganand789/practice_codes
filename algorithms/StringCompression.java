import java.util.Map;
import java.util.LinkedHashMap;

public class StringCompression{
    
    public static void main(final String[] args){
        final String str = "aaababbcdee";
        //a3bab2cde2

        System.out.println(compress(str));


    }

    private static String compress(final String str){
        final char[] charArray = str.toCharArray();
        final int    charArrayLength = charArray.length;

        final StringBuilder sb = new StringBuilder();

        char lastChar = charArray[0];
        int count = 1;
        char currentChar;

        for(int i = 1; i < charArrayLength; ++i){
            currentChar = charArray[i];
            if(currentChar != lastChar){
                sb.append(lastChar).append(count);

                lastChar = currentChar;
                count = 1;
                continue;
            }

            ++count;
        }

        sb.append(lastChar).append(count);

        return sb.toString();
    }

    private static String wrongCode(final String str){
       final Map<String, Integer> map = new LinkedHashMap<>();

       final int strLength = str.length();

       for(int i = 0; i < strLength; ++i){
          final String ch = str.charAt(i) + "";
          Integer count = map.get(ch);
          
          if(count == null){
              count = 1;
              map.put(ch, count);
              continue;
          }

          map.put(ch, count + 1);
       }

       final int sizeOfMap = map.size();
       final StringBuilder sb = new StringBuilder(2 * sizeOfMap);

       for(Map.Entry<String, Integer> entry : map.entrySet()){
           sb.append(entry.getKey()).append(entry.getValue());
       }
       
       return sb.toString(); 
    }
}
