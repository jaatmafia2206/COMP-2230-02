/**
 * Search Algorithms - Uninformed Search Implementations
 * 
 * This class implements three uninformed search algorithms:
 * - Breadth First Search (BFS)
 * - Depth First Search (DFS)  
 * - Uniform Cost Search (UCS)
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;

public class SearchAlgorithms {

	private UninformedSearches graph;
	
	// Search statistics
	private int numOfNodesGenerated = 0;
	private int maxNumOfNodesInMemory = 0;

	public SearchAlgorithms(UninformedSearches graph) {
		this.graph = graph;
	}

	/*--------------------------------------------------------------------------
	 * Breadth First Search (BFS) - Level-by-level exploration
	 -------------------------------------------------------------------------*/
	/**
	 * Breadth First Search Algorithm
	 * Uses a Queue data structure to explore nodes level-by-level.
	 * Finds the shortest path in terms of number of hops.
	 * 
	 * @param src - Source node to start search
	 * @param dest - Destination node to find
	 * @return ArrayList of nodes visited from source to destination
	 */
	public ArrayList<UninformedSearches.Node> bfs(UninformedSearches.Node src, UninformedSearches.Node dest) {
		Queue<UninformedSearches.Node> frontier = new LinkedList<>();
		frontier.add(src);
		
		ArrayList<UninformedSearches.Node> visited = new ArrayList<>();
		Set<Integer> visitedSet = new HashSet<>();
		
		while (!frontier.isEmpty()) {
			UninformedSearches.Node elem = frontier.remove();
			
			// Skip if already visited
			if (visitedSet.contains(elem.getCity())) {
				continue;
			}
			
			visited.add(elem);
			visitedSet.add(elem.getCity());
			
			// Check if destination reached
			if (elem.getCity() == dest.getCity()) {
				break;
			}
			
			// Expand current node to find adjacent nodes
			ArrayList<UninformedSearches.Node> adjNodes = graph.findAdjNodes(elem.getCity());
			ArrayList<UninformedSearches.Edge> adjEdges = graph.findAdjEdges(elem.getCity());
			elem.expandNode(adjNodes, adjEdges);
			
			maxNumOfNodesInMemory = Math.max(maxNumOfNodesInMemory, frontier.size());
			
			// Add unvisited neighbors to queue
			if (adjNodes != null) {
				for (UninformedSearches.Node child : adjNodes) {
					if (!visitedSet.contains(child.getCity()) && !containsNode(frontier, child.getCity())) {
						frontier.add(child);
					}
				}
			}
		}
		
		numOfNodesGenerated = visited.size();
		return visited;
	}

	/*--------------------------------------------------------------------------
	 * Depth First Search (DFS) - Deep-first exploration
	 -------------------------------------------------------------------------*/
	/**
	 * Depth First Search Algorithm
	 * Uses a Stack data structure to explore as deep as possible first.
	 * May find a different path than BFS.
	 * 
	 * @param src - Source node to start search
	 * @param dest - Destination node to find
	 * @return ArrayList of nodes visited from source to destination
	 */
	public ArrayList<UninformedSearches.Node> dfs(UninformedSearches.Node src, UninformedSearches.Node dest) {
		Stack<UninformedSearches.Node> frontier = new Stack<>();
		frontier.push(src);
		
		ArrayList<UninformedSearches.Node> visited = new ArrayList<>();
		Set<Integer> visitedSet = new HashSet<>();
		
		while (!frontier.isEmpty()) {
			UninformedSearches.Node elem = frontier.pop();
			
			// Skip if already visited
			if (visitedSet.contains(elem.getCity())) {
				continue;
			}
			
			visited.add(elem);
			visitedSet.add(elem.getCity());
			
			// Check if destination reached
			if (elem.getCity() == dest.getCity()) {
				break;
			}
			
			// Expand current node to find adjacent nodes
			ArrayList<UninformedSearches.Node> adjNodes = graph.findAdjNodes(elem.getCity());
			ArrayList<UninformedSearches.Edge> adjEdges = graph.findAdjEdges(elem.getCity());
			elem.expandNode(adjNodes, adjEdges);
			
			maxNumOfNodesInMemory = Math.max(maxNumOfNodesInMemory, frontier.size());
			
			// Add unvisited neighbors to stack
			if (adjNodes != null) {
				for (UninformedSearches.Node child : adjNodes) {
					if (!visitedSet.contains(child.getCity()) && !containsNode(frontier, child.getCity())) {
						frontier.push(child);
					}
				}
			}
		}
		
		numOfNodesGenerated = visited.size();
		return visited;
	}

	/*--------------------------------------------------------------------------
	 * Uniform Cost Search (UCS) - Lowest-cost exploration
	 -------------------------------------------------------------------------*/
	/**
	 * Uniform Cost Search Algorithm
	 * Uses a PriorityQueue to explore lowest-cost paths first.
	 * Guaranteed to find the minimum-cost path.
	 * 
	 * @param src - Source node to start search
	 * @param dest - Destination node to find
	 * @return ArrayList of nodes visited from source to destination
	 */
	public ArrayList<UninformedSearches.Node> ucs(UninformedSearches.Node src, UninformedSearches.Node dest) {
		Comparator<UninformedSearches.Node> comparator = graph.new NodeComparator();
		PriorityQueue<UninformedSearches.Node> frontier = new PriorityQueue<>(graph.NUM_OF_CITIES, comparator);
		
		frontier.add(src);
		
		ArrayList<UninformedSearches.Node> visited = new ArrayList<>();
		Set<Integer> visitedSet = new HashSet<>();
		
		while (!frontier.isEmpty()) {
			UninformedSearches.Node elem = frontier.remove();
			
			// Skip if already visited
			if (visitedSet.contains(elem.getCity())) {
				continue;
			}
			
			visited.add(elem);
			visitedSet.add(elem.getCity());
			
			// Check if destination reached
			if (elem.getCity() == dest.getCity()) {
				break;
			}
			
			// Expand current node to find adjacent nodes
			ArrayList<UninformedSearches.Node> adjNodes = graph.findAdjNodes(elem.getCity());
			ArrayList<UninformedSearches.Edge> adjEdges = graph.findAdjEdges(elem.getCity());
			elem.expandNode(adjNodes, adjEdges);
			
			maxNumOfNodesInMemory = Math.max(maxNumOfNodesInMemory, frontier.size());
			
			// Add unvisited neighbors with updated costs
			if (adjNodes != null && adjEdges != null) {
				for (int i = 0; i < adjNodes.size(); i++) {
					UninformedSearches.Node child = adjNodes.get(i);
					UninformedSearches.Edge edge = adjEdges.get(i);
					
					if (!visitedSet.contains(child.getCity())) {
						int newCost = elem.getCost() + edge.getCost();
						child.updateCost(newCost);
						frontier.add(child);
					}
				}
			}
		}
		
		numOfNodesGenerated = visited.size();
		return visited;
	}

	/*--------------------------------------------------------------------------
	 * Helper Methods
	 -------------------------------------------------------------------------*/
	
	/**
	 * Check if a node with given city index exists in the queue
	 */
	private boolean containsNode(Queue<UninformedSearches.Node> queue, int cityIndex) {
		for (UninformedSearches.Node node : queue) {
			if (node.getCity() == cityIndex) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if a node with given city index exists in the stack
	 */
	private boolean containsNode(Stack<UninformedSearches.Node> stack, int cityIndex) {
		for (UninformedSearches.Node node : stack) {
			if (node.getCity() == cityIndex) {
				return true;
			}
		}
		return false;
	}
	
	public void resetStatistics() {
		numOfNodesGenerated = 0;
		maxNumOfNodesInMemory = 0;
	}

	public int getNumOfNodesGenerated() {
		return numOfNodesGenerated;
	}

	public int getMaxNumOfNodesInMemory() {
		return maxNumOfNodesInMemory;
	}
}
