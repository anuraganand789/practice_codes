public class ZeroMatrix{
    public static void main(final String[] args){
        int[][] matrix = {
                             {1, 0, 1, 2},
                             {1, 1, 1, 0},
                             {2, 3, 9, 6}
                         };
        zero(matrix);
        print(matrix);

    }

    private static void print(final int[][] matrix){
       final int maxX = matrix.length;
       final int maxY = matrix[0].length;

       for(int x = 0; x < maxX; ++x){
           for(int y = 0; y < maxY; ++y){
               System.out.print(matrix[x][y]);
               System.out.print(',');
           }
           System.out.println();
       }
    }
    
    private static void zero(final int[][] matrix){
       final int maxX  = matrix.length;
       final int maxY  = matrix[0].length;
       
       final int[] rows = new int[maxX];
       final int[] columns = new int[maxY];

       for(int x = 0; x < maxX; ++x){
           for(int y = 0; y < maxY; ++y){
               if(matrix[x][y] == 0) {
                   rows[x]    = 1;
                   columns[y] = 1;
                   System.out.printf("x : %d rows[%d] = 1, --  y : %d - columns[%d] = 1.%n", x, x, y, y);
               }
           }
       }

       zeroRow(rows, matrix);
       zeroColumn(columns, matrix);
    }

    private static void zeroRow(final int[] rows, int[][] matrix){
       final int maxX = matrix.length;
       final int maxY = matrix[0].length; 

       for(int row = 0; row < maxX; ++row){
           if(rows[row] != 1) continue;
           for(int column = 0; column < maxY; ++column){
               matrix[row][column] = 0;
           }
       }
    }

    private static void zeroColumn(final int[] columns, int[][] matrix){
       final int maxX = matrix.length;
       final int maxY = matrix[0].length; 

       for(int row = 0; row < maxX; ++row){
           for(int column = 0; column < maxY; ++column){
               if(columns[column] == 1) matrix[row][column] = 0;
           }
       }
    }
}

