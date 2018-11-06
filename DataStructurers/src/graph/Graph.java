package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Graph {

	Map<String, Set<String>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<String, Set<String>>();
	}

	public void addEdge(String v, String w) {
		if (hasVertex(v) && hasVertex(w)) {
			adjacencyList.get(v).add(w);
			adjacencyList.get(w).add(v);
		}
	}

	public void addVertex(String v) {
		if (!hasVertex(v)) {
			adjacencyList.put(v, new HashSet<String>());
		}
	}

	// returns number of verticies
	public int getSize() {
		return adjacencyList.size();
	}

	public Set<String> getVerticies() {
		return adjacencyList.keySet();
	}
	
	public boolean hasVertex(String v) {
		return adjacencyList.containsKey(v);
	}
	
	public String toString() {
		String ret = "";
		for (String key : adjacencyList.keySet()) {
			ret += key + ": ";
			for (String val : adjacencyList.get(key)) {
				ret += val+" ";
			}
			ret += "\n";
		}
		return ret;
	}
	
	public static BufferedReader in = new BufferedReader(new FileReader("src/input.txt"));
	
	public static void main(String[] args) {
		
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("A", "D");
		System.out.println(g);
	}

}
