import java.util.Set;
import java.util.LinkedHashSet;

public class PrintUniqueRows{
    private static final int numberOfRows     = 6;
    private static final int numberOfColumns  = 5;

    private static final int[][] matrix = {
                                        {1, 0, 1, 0, 0},
                                        {0, 1, 0, 0, 1},  
                                        {1, 0, 1, 1, 0},  
                                        {0, 1, 0, 0, 1},  
                                        {1, 0, 1, 0, 0},
                                        {1, 0, 1, 1, 0}  
				    };
    private static int intValue(final int rowIndex){
	int sum = 0;

        for(int columnIndex = 0; columnIndex < numberOfColumns; ++columnIndex){
	    sum += Math.pow(2, columnIndex) * matrix[rowIndex][columnIndex];
	}

	return sum;
    }

    private static void printNode(final BSTNode node){
        if(node == null) return;
	int sum = node.data;
	for(int columnIndex = 0; columnIndex < numberOfColumns; ++columnIndex){
	    System.out.format("%d " , sum % 2);
	    sum = sum / 2;
	}
	System.out.println();
    }

    private static class BSTNode {
        int data;
	BSTNode left;
	BSTNode right;

	private BSTNode(final int data) { this.data = data; }
    }

    final static Set<Integer> setOfIndices = new LinkedHashSet<>();

    private static BSTNode insert(final BSTNode head, final int data, final int currentRowIndex){
        if(head == null) {
	    setOfIndices.add(currentRowIndex);
	    return new BSTNode(data);
	}

	if(head.data == data){ return head; }
	if(head.data > data) {
	    final BSTNode oldLeftNode = head.left;
	    head.left  = insert(oldLeftNode, data, currentRowIndex);

	    if(oldLeftNode != head.left) setOfIndices.add(currentRowIndex);

	} else {
	    final BSTNode oldRightNode = head.right;
	    head.right = insert(oldRightNode, data, currentRowIndex);

	    if(oldRightNode != head.right) setOfIndices.add(currentRowIndex);

	}

	return head;
    }

    private static void inorder(final BSTNode root){
        if(root == null) return ;
        
	inorder(root.left);
	printNode(root);
	inorder(root.right);
    }
    
    public static void main(final String[] args){
       BSTNode head = null;
       for(int row = 0; row < numberOfRows; ++row){
           head = insert(head, intValue(row), row);
       }

       //inorder(head);
       for(int rowIndex : setOfIndices){
           for(int columnIndex = 0; columnIndex < numberOfColumns; ++columnIndex){
	       System.out.format("%d ", matrix[rowIndex][columnIndex]);
	   }
	   System.out.println();
       }
    }
}

