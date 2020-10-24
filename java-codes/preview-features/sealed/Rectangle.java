public record Rectangle(int length, int width) implements SealedShape {

    @Override
    public void printShapeName() { System.out.println("Rectangle"); }

    @Override
    public String shapeName() { return "Rectanlge" ; }


    public static void main(final String ... args){
        final SealedShape ss  = new Rectangle(10, 100);

        if(ss instanceof Rectangle r) r.printShapeName();
        
	Byte b     = Byte.valueOf((byte) 12);
	Integer i  = Integer.valueOf(12);

	System.out.println(print(i));

    }

    static String print(Number n){
        return switch(n) {
	           case Integer i -> "Integer";
		   case Byte    b -> "Byte";
		   default       -> "Node";
	       };
    }
}
