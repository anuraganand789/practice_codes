public class RotateMatrix{
    public static void main(final String ... args){
        final int[][] matrix = {
	                        {1, 2, 3, 4}, 
	                        {5, 6, 7, 8}, 
			        {9, 10, 11, 12}
			       };

        final int xAxis = 3;
	final int yAxis = 4;

	int rowStartsAt    = 0;
	int columnStartsAt = 0;

        int rowEndsAt = xAxis - 1;
	int columnEndsAt = yAxis - 1;

	printMatrix(matrix, xAxis, yAxis);

	while(true){
	    if(rowStartsAt == rowEndsAt || columnStartsAt == columnEndsAt) break;
	    int curr = matrix[rowStartsAt][columnStartsAt];
	    int prev = -1;
	    int temp;

	    for(int colIndex = columnStartsAt + 1; colIndex <= columnEndsAt; ++colIndex){
		temp = matrix[rowStartsAt][colIndex];
		matrix[rowStartsAt][colIndex] = curr;
	        prev = curr;
		curr = temp;
	    }

            for(int rowIndex = rowStartsAt + 1; rowIndex <= rowEndsAt; ++rowIndex){
	         temp = matrix[rowIndex][columnEndsAt];
		 matrix[rowIndex][columnEndsAt] = curr;
		 prev = curr;
		 curr = temp;
	    }

	    for(int colIndex = columnEndsAt - 1; colIndex >= columnStartsAt; --colIndex){
		temp = matrix[rowEndsAt][colIndex];
		matrix[rowEndsAt][colIndex] = curr;
	        prev = curr;
		curr = temp;
	    }

            for(int rowIndex = rowEndsAt - 1; rowIndex >= rowStartsAt; --rowIndex){
	         temp = matrix[rowIndex][columnStartsAt];
		 matrix[rowIndex][columnStartsAt] = curr;
		 prev = curr;
		 curr = temp;
	    }

	    ++columnStartsAt;
	    ++rowStartsAt;

	    --rowEndsAt;
	    --columnEndsAt;
	}

	printMatrix(matrix, xAxis, yAxis);

    }

    private static void printMatrix(final int[][] matrix, final int maxRow, final int maxCol){
        for(int row = 0; row < maxRow; ++row){
	    for(int col = 0; col < maxCol; ++col){
	        System.out.format("%d ", matrix[row][col]);
	    }
	    System.out.println();
	}
        System.out.println();
    }
}
