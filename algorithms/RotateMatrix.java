public RotateMatrix{
    
    public static void main(final String[] args){
       final int[][] = {
                           {1,  2,  3,  4},
                           {5,  6,  7,  8},
                           {9, 10, 11, 12},
                           {9, 10, 11, 12}
                       };

    }

    private void static rotateBy90(final int[][] matrix, int x, int y){
        int temp;
        int maxRight x;

        int topRowPosition = 0;
        int bottomRowPosition = y - 1;

        int firstColumnPosition = 0;
        int lastColumnPosition = x -1 ;

        while(topRowPosition < bottomRowPosition && firstColumnPosition < lastColumnPosition){
            //shift top row
            temp = matrix[topRowPosition][lastColumnPosition];
            for(int index = rightColumnPosition; index >  lastColumnPosition; --index){
                matrix[topRowPosition][index] = matrix[topRowPosition][index - 1]; 
            }
            --topRowPosition;

            int lastNumber = temp;

            for(int index = topRowPosition - 1; index < bottomRowPosition; ++index){
                matrix[index][lastColumnPosition] = temp
            }



            //shift right column
            //shift bottom row
            //shift left column
        }
    }
}
