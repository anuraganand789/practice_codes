public class ABooleanMatrix{
    private static final int row    = 3;
    private static final int column = 4;

    private static final boolean[][] solution = new boolean[row][column];
    private static final boolean[][] matrix = { 
                                                  {true, false, false, true},
                                                  {false, false, true, false},
                                                  {false, false, false, false}
					      };
    
    public static void main(final String[] args){
        findTruth();
	printMyMatrix(matrix);
	System.out.println();
	printMyMatrix(solution);

    }

    private static void printMyMatrix(final boolean[][] matrix){
        for(int rowIndex = 0; rowIndex < row; ++rowIndex){
	    for(int columnIndex = 0; columnIndex < column; ++columnIndex){
	        System.out.format("%s ", matrix[rowIndex][columnIndex] ? "True" : "False");
	    }
	    System.out.println();
	}
    }

    private static void paintMyMatrixTrue(final int row, final int column){
	for(int columnIndex = 0; columnIndex < ABooleanMatrix.column; ++columnIndex)  solution[row][columnIndex] = true;
        for(int rowIndex    = 0; rowIndex < ABooleanMatrix.row; ++rowIndex)           solution[rowIndex][column] = true;
    }

    private static void findTruth(){
        for(int rowIndex = 0; rowIndex < row; ++rowIndex){
            for(int columnIndex = 0; columnIndex < column; ++columnIndex){
	        if(matrix[rowIndex][columnIndex]) paintMyMatrixTrue(rowIndex, columnIndex);
	    }
	}
    }
}

