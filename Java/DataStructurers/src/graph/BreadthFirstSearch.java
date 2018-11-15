package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	
	private Set<String> marked;
	private Map<String, String> edgeTo;
	private Map<String, Integer> distTo;
	private String start;
	private Graph graph;
	
	public BreadthFirstSearch(Graph graph, String start) {
		this.start = start;
		this.graph = graph;
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		distTo = new HashMap<String, Integer>();
		bfs(start);
	}
	
	public void bfs(String vertex) {
		Queue<String> queue = new LinkedList<String>();
		queue.add(vertex);
		marked.add(vertex);
		distTo.put(vertex, 0);
		while(!queue.isEmpty()) {
			for (String v : graph.getAdjacent(queue.peek())) {
				if (!marked.contains(v)) {
					queue.add(v);
					edgeTo.put(v, queue.peek());
					distTo.put(v, distTo.get(queue.remove()));
				}
			}
		}
	}
	
	public int getDist(String vertex) {
		return distTo.get(vertex);
	}

}
