package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

	Map<String, Set<String>> adjacencyList;

	public Graph() {
		adjacencyList = new HashMap<String, Set<String>>();
	}
	
	public void fill(BufferedReader in) throws IOException {
		String line;
		while((line = in.readLine()) != null) {
			String vertex = line.split(":")[0];
			addVertex(vertex);
			for (String vertexTwo : line.split(":")[1].split(" ")) {
				addEdge(vertex, vertexTwo);
			}
		}
	}

	public void addEdge(String v, String w) {
		if (hasVertex(v) && hasVertex(w)) {
			adjacencyList.get(v).add(w);
			adjacencyList.get(w).add(v);
		}
	}
	
	public Set<String> getAdjacent(String v) {
		return adjacencyList.get(v);
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
	
	public static void main(String[] args) throws IOException {

		File inputFile = new File("C:\\Users\\aalex\\Dev\\GitHub\\ICS4U\\DataStructurers\\src\\graph\\TinyGraph.txt"); 
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		Graph g = new Graph();
		g.fill(in);
		DepthFirstSearch dfs = new DepthFirstSearch(g, "A");
		System.out.println(dfs.lengthTo("E"));
		
	}

}
