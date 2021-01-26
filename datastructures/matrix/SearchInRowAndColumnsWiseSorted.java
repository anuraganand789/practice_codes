public class SearchInRowAndColumnsWiseSorted{

    private static final int m = 4;
    private static final int n = 4;

    private static final int[][] matrix = { 
                                              {10, 20, 30, 40},
                                              {15, 25, 35, 45},
                                              {27, 29, 37, 48},
                                              {32, 33, 39, 50}
				          };

    public static void main(final String[] args){
        final int findValue = 50;
	if(findValue2(findValue, 0, 0)) 
	    System.out.format("%d found ", findValue);
	else                           
	    System.out.format("%d not found", findValue);

	System.out.format("%n%d no of calls", noOfCalls);
    }

    private static boolean isSafeCoordinate(final int x, final int y){
        return x >= 0 && y >= 0 && 
	       x < m  && y < n; 
    }

    private static int noOfCalls = 0;
    private static boolean findValue(final int searchValue, final int x, final int y){
        ++noOfCalls;
	return (isSafeCoordinate(x, y)     && matrix[x][y] == searchValue) || 
	       (isSafeCoordinate(x + 1, y) && findValue(searchValue, x + 1, y)) || 
	       (isSafeCoordinate(x, y + 1) && findValue(searchValue, x, y + 1));
    }
    private static boolean findValue2(final int searchValue, final int x, final int y){
        ++noOfCalls;
	return isSafeCoordinate(x, y)           && 
	       (matrix[x][y] == searchValue     || 
	       findValue(searchValue, x + 1, y) || 
	       findValue(searchValue, x, y + 1));
    }
}
