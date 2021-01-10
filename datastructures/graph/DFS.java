import java.util.Deque;
import java.util.ArrayDeque;

import java.util.List;
import java.util.ArrayList;

public class DFS{

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
        final DFS dfs = new DFS();

        final Node nodeA = dfs.new Node("A");
        final Node nodeB = dfs.new Node("B");
        final Node nodeC = dfs.new Node("C");
        final Node nodeD = dfs.new Node("D");

	nodeA.listOfConnections.add(nodeB);
	nodeB.listOfConnections.add(nodeC);
	nodeB.listOfConnections.add(nodeD);
	nodeC.listOfConnections.add(nodeD);
	nodeD.listOfConnections.add(nodeA);

	dfs(nodeA);
    }

    private static void dfs(final Node node){
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
	       queue.addFirst(connection);
	   }
	}
    }
}
