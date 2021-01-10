import java.util.Set;
import java.util.LinkedHashSet;

import java.util.Map;
import java.util.IdentityHashMap;

public class CycleInDAG{

    private class Node {
        private final String name;
        private final Set<Node> setOfChildNodes;
        private boolean isVisited;

        private Node(final String name){
            this.name = name;
            this.setOfChildNodes = new LinkedHashSet<>();
        }
    }
    public static void main(final String ... args){
	final CycleInDAG cyc = new CycleInDAG();

        final Node nodeA = cyc.new Node("A");
        final Node nodeB = cyc.new Node("B");
        final Node nodeC = cyc.new Node("C");
        final Node nodeD = cyc.new Node("D");
        final Node nodeE = cyc.new Node("E");
        final Node nodeF = cyc.new Node("F");


        nodeA.setOfChildNodes.add(nodeB);
        nodeA.setOfChildNodes.add(nodeF);

        nodeB.setOfChildNodes.add(nodeC);
        nodeB.setOfChildNodes.add(nodeD);

        nodeC.setOfChildNodes.add(nodeB);
        nodeC.setOfChildNodes.add(nodeA);

        nodeD.setOfChildNodes.add(nodeE);
        nodeE.setOfChildNodes.add(nodeB);

        for(final Node node : new Node[]{nodeA, nodeB, nodeC, nodeD, nodeE, nodeF}){
	    if(graphHasCycle(node)){
	        System.out.println("Cycle exists ");
		break;
	    }

	}
    }
    
    private static final Map<Node, Object> mapOfNodesPresentInCurrentPath = new IdentityHashMap<>();

    private static boolean graphHasCycle(final Node node){
	if(mapOfNodesPresentInCurrentPath.containsKey(node)) return true;
        if(node.isVisited) return false;

	node.isVisited = true;
	mapOfNodesPresentInCurrentPath.put(node, null);
	System.out.format("%s added to path.%n", node.name);
        
	for(final Node childNode : node.setOfChildNodes){
	    if(graphHasCycle(childNode)) return true;
	}

	System.out.format("%s removed from path.%n", node.name);
	mapOfNodesPresentInCurrentPath.remove(node);
	return false;
    }
}


