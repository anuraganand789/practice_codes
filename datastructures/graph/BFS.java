import java.util.Deque;
import java.util.ArrayDeque;

import java.util.List;
import java.util.ArrayList;

public class BFS{

    private class Node {
        private String name;
	private List<Node> listOfConnections;
	private boolean isVisited;

	private Node(final String name) { 
	    this.name = name; 
	    this.listOfConnections = new ArrayList<>();
	}
    }

    public static void main(final String ... args){
        final BFS bfs = new BFS();

        final Node nodeA = bfs.new Node("A");
        final Node nodeB = bfs.new Node("B");
        final Node nodeC = bfs.new Node("C");
        final Node nodeD = bfs.new Node("D");

	nodeA.listOfConnections.add(nodeB);
	nodeB.listOfConnections.add(nodeC);
	nodeB.listOfConnections.add(nodeD);
	nodeC.listOfConnections.add(nodeD);
	nodeD.listOfConnections.add(nodeA);

	bfs(nodeA);
    }

    private static void bfs(final Node node){
        final Deque<Node> queue = new ArrayDeque<>();

	queue.add(node);
	node.isVisited = true;

	while(!queue.isEmpty()){
	   final Node currentNode = queue.removeFirst(); 
	   System.out.format("Node %s.%n", currentNode.name);

	   for(final Node connection : currentNode.listOfConnections){

	       if(connection.isVisited) {
	           System.out.format("Parent Node %s, Child Node %s has been visited.%n", currentNode.name, connection.name);
	           continue;
	       }

	       connection.isVisited = true;
	       queue.addLast(connection);
	   }
	}
    }
}
