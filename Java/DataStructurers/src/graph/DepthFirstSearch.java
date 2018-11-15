package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DepthFirstSearch {
	
	private Set<String> marked;
	private Map<String, String> edgeTo;
	private String start;
	private Graph graph;
	
	public DepthFirstSearch(Graph graph, String start) {
		this.start = start;
		this.graph = graph;
		marked = new HashSet<String>();
		edgeTo = new HashMap<String, String>();
		dfs(start);
	}
	
	public void dfs(String vertex) {
		marked.add(vertex);
		for (String v : graph.getAdjacent(vertex)) {
			if (!marked.contains(v)) {
				edgeTo.put(v, vertex);
				dfs(v);
			} 
		}
	}
	
	public int lengthTo(String vertex) {
		if (!graph.hasVertex(vertex)) return 0;
		if (edgeTo.get(vertex) != start) return 1+lengthTo(edgeTo.get(vertex));
		return 1;
	}

}
