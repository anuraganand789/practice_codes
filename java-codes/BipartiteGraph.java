import java.util.Deque;
import java.util.ArrayDeque;

public class BiPartiteGraph{

    enum Color { RED, GREEN, NONE };

    private static final int numberOfNodes = 4;

    public static void main(final String ... args){
        final boolean[][] graph = {
				      {false, true, false, true},
				      {true, false, true, false},
				      {false, true, false, true},
	                              {true, false, true, false}
			          };     
        
	if(isBipartite(graph, 0)) System.out.println("Graph is bipartite");
    }

    private static boolean isBipartite(final boolean[][] graph, final int src){
        
	final Color[] color = new Color[numberOfNodes];

	for(int colorIndex = 0; colorIndex < numberOfNodes; ++colorIndex){
	    color[colorIndex] = Color.NONE;
	}

	final Deque<Integer> queue = new ArrayDeque<>();
	queue.addLast(src);
	color[src] = Color.RED;

	while(!queue.isEmpty()){
	    final int parentNode = queue.removeFirst();

	    if(graph[parentNode][parentNode]) return false;

	    for(int childNode = 0; childNode < numberOfNodes; ++childNode){
		if(graph[parentNode][childNode]){
	            if(color[childNode] == Color.NONE){
		        color[childNode] = color[parentNode] == Color.RED ? Color.GREEN : Color.RED;
		        queue.addLast(childNode);
		    } else if(color[childNode] == color[parentNode]){ return false; }
		}
	    }
	}

	return true;
    }
}
