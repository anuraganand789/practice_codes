import java.util.LinkedList;

import java.util.Map;
import java.util.HashMap;

public class BinaryTreeInVertical{

    private class Node{
        private final String name;
	private Node left;
	private Node right;

	private Node(final String name){
	    this(null, null, name);
	}

	private Node(final Node left, final Node right, final String name){
	    this.left = left;
	    this.right = right;
	    this.name = name;
	}
    }

    private static final Map<Integer, LinkedList<Node>> spaceToNode = new HashMap<>();

    private static int minNegative = 0;
    private static int maxPositive = 0;

    private static void printBinaryTreeInVerticalOrder(final Node node, final int space){
	if(node == null) return ;

	if(space < 0 && minNegative > space) minNegative = space;
	else if(space > 0 && maxPositive < space) maxPositive = space;

        if(!spaceToNode.containsKey(space)) spaceToNode.put(space, new LinkedList<Node>());

	spaceToNode.get(space).add(node);

	printBinaryTreeInVerticalOrder(node.right, space + 1);
        printBinaryTreeInVerticalOrder(node.left, space - 1);
    }

    public static void main(final String ... args){
        final BinaryTreeInVertical bt = new BinaryTreeInVertical();

	final Node nodeA = bt.new Node("A");
	final Node nodeB = bt.new Node("B");
	final Node nodeC = bt.new Node("C");
	final Node nodeD = bt.new Node("D");
	final Node nodeE = bt.new Node("E");
	final Node nodeF = bt.new Node("F");
	final Node nodeG = bt.new Node("G");
	final Node nodeH = bt.new Node("H");
	final Node nodeI = bt.new Node("I");
	final Node nodeJ = bt.new Node("J");
	final Node nodeK = bt.new Node("K");

	nodeA.left  = nodeB;
	nodeA.right = nodeC;

	nodeB.left  = nodeD;
	nodeB.right = nodeE;
        
	nodeC.left  = nodeF;
	nodeC.right = nodeG;

	printBinaryTreeInVerticalOrder(nodeA, 0);

	while(minNegative < 0) {
	    final LinkedList<Node> listOfNodes = spaceToNode.get(minNegative);
	    if(listOfNodes == null) break;

	    for(final Node currentNode : listOfNodes) System.out.format("[%d, %s].", minNegative, currentNode.name);

	    ++minNegative;
	    System.out.println();
	}

	int positive = 0;
	while(positive <= maxPositive){
	    final LinkedList<Node> listOfNodes = spaceToNode.get(positive);
	    if(listOfNodes == null) break;

	    for(final Node currentNode : listOfNodes) System.out.format("[%d, %s].", positive, currentNode.name);

            ++positive;
	    System.out.println();
	}
    }
}
