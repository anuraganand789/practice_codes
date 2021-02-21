import java.util.Arrays;

public class PrintSortedRowColumnWiseMatrix{
    private static final int numberOfRows    = 4;
    private static final int numberOfColumns = 4;

    private static final int[][] matrix = { 
					    {10, 20, 30, 40},
                                            {15, 25, 35, 45},
                                            {27, 29, 37, 48},
                                            {32, 33, 39, 50},
                                          };

    private static final int[] holder = new int[numberOfColumns];

    public static void main(final String[] args){
	for(int columnIndex = 0; columnIndex < numberOfColumns; ++columnIndex){
	   holder[columnIndex] = matrix[0][columnIndex];
	}

	int rowInterator = 1;
	int columnIterator = 0;

	while(true){
	    if(columnIterator == numberOfColumns){
	        if(++rowInterator == numberOfRows){ break; }

		columnIterator = 0;
	    }
	    //System.out.format("%d ", holder[0]);
	    printArray(holder);

	    final int data = matrix[rowInterator][columnIterator];
            int insertAt  = Arrays.binarySearch(holder, data);
	    System.out.format("Data %d -> insert at %d.%n", data, insertAt);
            insertAt  = Math.abs(Arrays.binarySearch(holder, data)) - 2;
	    if(insertAt < 0) insertAt = 0;
	    shiftLeftwards(holder, insertAt); 

	    holder[insertAt] = data;

	    ++columnIterator;
	}

	for(int columnIndex = 0; columnIndex < numberOfColumns; ++columnIndex){
	    System.out.format("%d ", holder[columnIndex]);
	}

    }

    private static void printArray(int[] array){
	for(int columnIndex = 0; columnIndex < array.length; ++columnIndex){
	    System.out.format("%d ", array[columnIndex]);
	}
	System.out.println();
    }

    private static void shiftLeftwards(int[] array, int fromIndex){
        int columnIndex = 0;
	while(columnIndex < fromIndex){
	    array[columnIndex] = array[columnIndex + 1];
	    ++columnIndex;
	}
    }
}
