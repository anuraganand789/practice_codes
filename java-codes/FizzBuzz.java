public class FizzBuzz{
   //for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
   //}
   private static void badCoder(){
       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){

	   //As Per the Great Coder in YOutube video => a
	   //(anyNumber % 15 == 0) is equivalent to (anyNumber % 5 == 0 && anyNumber % 3 == 0)

           if(anyNumber % 15 == 0) { System.out.print("FizzBuzz"); } 

           else if(anyNumber % 5 == 0) { System.out.print("Buzz"); } 

           else if(anyNumber % 3 == 0) { System.out.print("Fizz"); } 
	   
	   else System.out.print(anyNumber);
       }
   }

   private static void goodCoder(){
       boolean test;
       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
           test = false;
           if(anyNumber % 3 == 0) { System.out.print("Fizz"); test  = true;} 
           if(anyNumber % 5 == 0) { System.out.print("Buzz"); test  = true;} 

	   if(!test){
	       System.out.print(anyNumber);
	   }
	   System.out.println();
       }
   }

   //Bad Coder
   private static void goodCoderTwo(){
       String d;
       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
           d = "";
           if(anyNumber % 3 == 0) { d = d + "Fizz"; }
           if(anyNumber % 5 == 0) { d = d + "Buzz"; }

	   if(d.isEmpty()){
	       System.out.print(anyNumber);
	   } else {
	       System.out.print(d);
	   }
          System.out.println();
       }
   }
   
   //My Elegant Code
   private static void myGoodCoderTwo(){
       String d;
       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
           d = "";
           if(anyNumber % 3 == 0) { d = d + "Fizz"; }
           if(anyNumber % 5 == 0) { d = d + "Buzz"; }

	   System.out.println( d.isEmpty() ? anyNumber : d );
       }
   }
   
   private static void myGoodCode(){
       boolean test;
       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
           if(test = (anyNumber % 3 == 0)) { System.out.print("Fizz");} 
           if(anyNumber % 5 == 0) { System.out.print("Buzz"); test  = true;} 

	   if(!test){
	       System.out.print(anyNumber);
	   }
	   System.out.println();
       }
   }

   private static void greatCoder(){
       String d;
       int digit3 = 0;
       int digit5 = 0;

       for(int anyNumber = 1; anyNumber < 101; ++anyNumber){
	   ++digit3;
	   ++digit5;
	   d = "";

           if(digit3 == 3) { d += "Fizz"; digit3 = 0;} 
           if(digit5 == 5) { d += "Buzz"; digit5 = 0;} 

	   if(d.isEmpty()){
	       System.out.print(anyNumber);
	   } else {
	       System.out.print(d);
	   }
          System.out.println();
       }
   }

   public static void main(final String[] args){
       greatCoder();
   }
}
