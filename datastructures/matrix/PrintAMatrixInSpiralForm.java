public class PrintAMatrixInSpiralForm{
    private static final int row    = 3;
    private static final int column = 6;

    private static final int[][] matrix =  { 
                                                        {  1,  2,  3,  4,  5,  6 },
                                                        {  7,  8,  9, 10, 11, 12 },
                                                        { 13, 14, 15, 16, 17, 18 } 
				                    };

    public static void main(final String[] args){
        spiralPrinting();
    }

    private static void spiralPrinting(){
        int firstRow = 0;
	int lastRow  = row - 1;

	int firstColumn = 0;
	int lastColumn  = column - 1;

	while(firstRow <= lastRow){
	//    System.out.format("first Row %d, last Row %d, first Column %d, last Column %d.%n", 
	//                       firstRow,
	//		       lastRow,
	//		       firstColumn,
	//		       lastColumn);
	    for(int columnIndex = firstColumn; columnIndex <= lastColumn; ++columnIndex){
	        System.out.format("%d ", matrix[firstRow][columnIndex]);
	    }

	    for(int rowIndex = firstRow + 1; rowIndex <= lastRow; ++rowIndex){
	        System.out.format("%d ", matrix[rowIndex][lastColumn]);
	    }

	    if(firstRow < lastRow){
	        for(int columnIndex = lastColumn - 1; columnIndex >= firstColumn; --columnIndex){
	            System.out.format("%d ", matrix[lastRow][columnIndex]);
	        }
	    }

	    if(firstColumn < lastColumn){
	        for(int rowIndex = lastRow - 1; rowIndex >= firstRow + 1; --rowIndex){
	            System.out.format("%d ", matrix[rowIndex][firstColumn]);
	        }
	    }
	    ++firstRow;
	    --lastRow;

	    ++firstColumn;
	    --lastColumn;
	}
	System.out.println();
    }
}
