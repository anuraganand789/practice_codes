import java.util.function.ToIntBiFunction;

public class SlopeOfALine{
    private record Point(int x, int y){
       public void print(){
           System.out.println(this.toString());
       }
       @Override
       public String toString(){
           return "X " + x + ", Y " + y;
       }
    };

    public static void main(final String ... args){
        final Point firstPoint = new Point(10, 12);
	firstPoint.print();

	final Point secondPoint = new Point(15, 19);
	secondPoint.print();
        
	final ToIntBiFunction<Point, Point> slopeOfALine = (point1, point2) -> (point2.y() - point1.y()) / (point2.x() - point1.x()); 

        System.out.format("Slope Of Line %d. %n", slopeOfALine.applyAsInt(firstPoint, secondPoint));
    }
}
