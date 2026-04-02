/**
 * Uninformed Search Lab - Testing and Analysis
 * 
 * Complete the lab exercises below to understand how search algorithms work.
 * Test each algorithm with different start and end cities.
 * Compare their performance and analyze the results.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class SearchLab {

	// City index constants for easy reference
	private static final int ORADEA = 0;
	private static final int ARAD = 2;
	private static final int SIBIU = 9;
	private static final int BUCHAREST = 12;
	private static final int MEHADIA = 5;

	public static void main(String[] args) {
		// Initialize the graph
		UninformedSearches graph = new UninformedSearches();
		SearchAlgorithms algorithms = new SearchAlgorithms(graph);

		System.out.println("=== Uninformed Search Lab ===\n");

		// Exercise 1: Run BFS from Oradea to Bucharest
		System.out.println("EXERCISE 1: Test Breadth First Search (BFS)");
		System.out.println("Task: Run BFS from Oradea (0) to Bucharest (12)");
		System.out.println("Expected: Should find the shortest path in terms of number of hops\n");
		runBFSTest(graph, algorithms, ORADEA, BUCHAREST);

		System.out.println("\n" + "=".repeat(60) + "\n");

		// Exercise 2: Run DFS from Oradea to Bucharest
		System.out.println("EXERCISE 2: Test Depth First Search (DFS)");
		System.out.println("Task: Run DFS from Oradea (0) to Bucharest (12)");
		System.out.println("Expected: May take a different path than BFS, explores deeply\n");
		runDFSTest(graph, algorithms, ORADEA, BUCHAREST);

		System.out.println("\n" + "=".repeat(60) + "\n");

		// Exercise 3: Run UCS from Oradea to Bucharest
		System.out.println("EXERCISE 3: Test Uniform Cost Search (UCS)");
		System.out.println("Task: Run UCS from Oradea (0) to Bucharest (12)");
		System.out.println("Expected: Should find the minimum cost path\n");
		runUCSTest(graph, algorithms, ORADEA, BUCHAREST);

		System.out.println("\n" + "=".repeat(60) + "\n");

		// Exercise 4: Compare algorithms with different routes
		System.out.println("EXERCISE 4: Compare all three algorithms");
		System.out.println("Task: Run all algorithms on multiple routes and compare results\n");
		runComparativeAnalysis(graph, algorithms);

		System.out.println("\n" + "=".repeat(60) + "\n");

		// Exercise 5: Interactive mode
		System.out.println("EXERCISE 5: Interactive Search");
		System.out.println("Task: Allow user to input source and destination cities\n");
		runInteractiveMode(graph, algorithms);
	}

	/**
	 * Test BFS algorithm and display results
	 */
	private static void runBFSTest(UninformedSearches graph, SearchAlgorithms algorithms, 
			int srcCity, int destCity) {
		algorithms.resetStatistics();
		
		UninformedSearches.Node src = graph.getCities().get(srcCity);
		UninformedSearches.Node dest = graph.getCities().get(destCity);
		
		ArrayList<UninformedSearches.Node> path = algorithms.bfs(src, dest);
		
		printPath("BFS", path, algorithms.getNumOfNodesGenerated(), 
				algorithms.getMaxNumOfNodesInMemory(), graph);
	}

	/**
	 * Test DFS algorithm and display results
	 */
	private static void runDFSTest(UninformedSearches graph, SearchAlgorithms algorithms, 
			int srcCity, int destCity) {
		algorithms.resetStatistics();
		
		UninformedSearches.Node src = graph.getCities().get(srcCity);
		UninformedSearches.Node dest = graph.getCities().get(destCity);
		
		ArrayList<UninformedSearches.Node> path = algorithms.dfs(src, dest);
		
		printPath("DFS", path, algorithms.getNumOfNodesGenerated(), 
				algorithms.getMaxNumOfNodesInMemory(), graph);
	}

	/**
	 * Test UCS algorithm and display results
	 */
	private static void runUCSTest(UninformedSearches graph, SearchAlgorithms algorithms, 
			int srcCity, int destCity) {
		algorithms.resetStatistics();
		
		UninformedSearches.Node src = graph.getCities().get(srcCity);
		UninformedSearches.Node dest = graph.getCities().get(destCity);
		
		ArrayList<UninformedSearches.Node> path = algorithms.ucs(src, dest);
		
		printPath("UCS", path, algorithms.getNumOfNodesGenerated(), 
				algorithms.getMaxNumOfNodesInMemory(), graph);
	}

	/**
	 * Compare all three algorithms on multiple test cases
	 */
	private static void runComparativeAnalysis(UninformedSearches graph, SearchAlgorithms algorithms) {
		// Test Case 1: Oradea to Bucharest
		System.out.println("Test Case 1: " + getCityName(ORADEA) + " (" + ORADEA + ") to " 
				+ getCityName(BUCHAREST) + " (" + BUCHAREST + ")\n");
		
		algorithms.resetStatistics();
		ArrayList<UninformedSearches.Node> bfsPath = algorithms.bfs(
			graph.getCities().get(ORADEA), graph.getCities().get(BUCHAREST));
		int bfsNodes = algorithms.getNumOfNodesGenerated();
		int bfsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		algorithms.resetStatistics();
		ArrayList<UninformedSearches.Node> dfsPath = algorithms.dfs(
			graph.getCities().get(ORADEA), graph.getCities().get(BUCHAREST));
		int dfsNodes = algorithms.getNumOfNodesGenerated();
		int dfsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		algorithms.resetStatistics();
		ArrayList<UninformedSearches.Node> ucsPath = algorithms.ucs(
			graph.getCities().get(ORADEA), graph.getCities().get(BUCHAREST));
		int ucsNodes = algorithms.getNumOfNodesGenerated();
		int ucsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		printComparison("Test Case 1", bfsPath, bfsNodes, bfsMemory, 
				dfsPath, dfsNodes, dfsMemory, ucsPath, ucsNodes, ucsMemory, graph);
		
		// Test Case 2: Arad to Bucharest
		System.out.println("\n\nTest Case 2: " + getCityName(ARAD) + " (" + ARAD + ") to " 
				+ getCityName(BUCHAREST) + " (" + BUCHAREST + ")\n");
		
		algorithms.resetStatistics();
		bfsPath = algorithms.bfs(graph.getCities().get(ARAD), graph.getCities().get(BUCHAREST));
		bfsNodes = algorithms.getNumOfNodesGenerated();
		bfsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		algorithms.resetStatistics();
		dfsPath = algorithms.dfs(graph.getCities().get(ARAD), graph.getCities().get(BUCHAREST));
		dfsNodes = algorithms.getNumOfNodesGenerated();
		dfsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		algorithms.resetStatistics();
		ucsPath = algorithms.ucs(graph.getCities().get(ARAD), graph.getCities().get(BUCHAREST));
		ucsNodes = algorithms.getNumOfNodesGenerated();
		ucsMemory = algorithms.getMaxNumOfNodesInMemory();
		
		printComparison("Test Case 2", bfsPath, bfsNodes, bfsMemory, 
				dfsPath, dfsNodes, dfsMemory, ucsPath, ucsNodes, ucsMemory, graph);
		
		// Analysis Questions
		System.out.println("\n\n--- ANALYSIS QUESTIONS ---");
		System.out.println("1. Which algorithm finds the shortest path in terms of hops?");
		System.out.println("   Answer: ___________");
		System.out.println("\n2. Which algorithm finds the lowest-cost path?");
		System.out.println("   Answer: ___________");
		System.out.println("\n3. Which algorithm uses the least memory?");
		System.out.println("   Answer: ___________");
		System.out.println("\n4. Compare path lengths from Test Case 1:");
		System.out.println("   BFS length: " + bfsPath.size());
		System.out.println("   DFS length: " + dfsPath.size());
		System.out.println("   UCS length: " + ucsPath.size());
	}

	/**
	 * Interactive mode for testing arbitrary routes
	 */
	private static void runInteractiveMode(UninformedSearches graph, SearchAlgorithms algorithms) {
		Scanner scanner = new Scanner(System.in);
		boolean continueSearch = true;
		
		while (continueSearch) {
			try {
				System.out.print("\nEnter source city (0-19): ");
				int src = scanner.nextInt();
				
				System.out.print("Enter destination city (0-19): ");
				int dest = scanner.nextInt();
				
				System.out.print("Choose algorithm (1=BFS, 2=DFS, 3=UCS, 4=All): ");
				int choice = scanner.nextInt();
				
				if (src < 0 || src > 19 || dest < 0 || dest > 19) {
					System.out.println("Invalid city indices. Please use 0-19.");
					continue;
				}
				
				UninformedSearches.Node srcNode = graph.getCities().get(src);
				UninformedSearches.Node destNode = graph.getCities().get(dest);
				
				switch (choice) {
					case 1:
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> bfsPath = algorithms.bfs(srcNode, destNode);
						printPath("BFS", bfsPath, algorithms.getNumOfNodesGenerated(), 
								algorithms.getMaxNumOfNodesInMemory(), graph);
						break;
					case 2:
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> dfsPath = algorithms.dfs(srcNode, destNode);
						printPath("DFS", dfsPath, algorithms.getNumOfNodesGenerated(), 
								algorithms.getMaxNumOfNodesInMemory(), graph);
						break;
					case 3:
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> ucsPath = algorithms.ucs(srcNode, destNode);
						printPath("UCS", ucsPath, algorithms.getNumOfNodesGenerated(), 
								algorithms.getMaxNumOfNodesInMemory(), graph);
						break;
					case 4:
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> allBfs = algorithms.bfs(srcNode, destNode);
						System.out.println("\nBFS: " + pathToString(allBfs));
						
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> allDfs = algorithms.dfs(srcNode, destNode);
						System.out.println("DFS: " + pathToString(allDfs));
						
						algorithms.resetStatistics();
						ArrayList<UninformedSearches.Node> allUcs = algorithms.ucs(srcNode, destNode);
						System.out.println("UCS: " + pathToString(allUcs));
						break;
					default:
						System.out.println("Invalid choice.");
				}
				
				System.out.print("\nSearch another route? (y/n): ");
				String response = scanner.next();
				continueSearch = response.equalsIgnoreCase("y");
				
			} catch (Exception e) {
				System.out.println("Invalid input. Please try again.");
				scanner.nextLine();
			}
		}
		
		scanner.close();
		System.out.println("\nLab completed!");
	}

	/**
	 * Helper method to print path results with statistics
	 */
	private static void printPath(String algorithmName, ArrayList<UninformedSearches.Node> path, 
			int nodesGenerated, int maxInMemory, UninformedSearches graph) {
		System.out.println("\n" + algorithmName + " Results:");
		System.out.println("  Nodes Generated: " + nodesGenerated);
		System.out.println("  Max Nodes in Memory: " + maxInMemory);
		System.out.print("  Path: ");
		for (int i = 0; i < path.size(); i++) {
			System.out.print(getCityName(path.get(i).getCity()));
			if (i < path.size() - 1) {
				System.out.print(" -> ");
			}
		}
		System.out.println();
	}

	/**
	 * Convert path to string format
	 */
	private static String pathToString(ArrayList<UninformedSearches.Node> path) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < path.size(); i++) {
			sb.append(getCityName(path.get(i).getCity()));
			if (i < path.size() - 1) {
				sb.append(" -> ");
			}
		}
		return sb.toString();
	}

	/**
	 * Print comparison table for three algorithms
	 */
	private static void printComparison(String testCase, 
			ArrayList<UninformedSearches.Node> bfsPath, int bfsNodes, int bfsMemory,
			ArrayList<UninformedSearches.Node> dfsPath, int dfsNodes, int dfsMemory,
			ArrayList<UninformedSearches.Node> ucsPath, int ucsNodes, int ucsMemory, 
			UninformedSearches graph) {
		
		System.out.printf("%-20s | %-15s | %-17s | %-17s%n", "Algorithm", "Path Length", "Nodes Generated", "Max Memory");
		System.out.println("-".repeat(75));
		System.out.printf("%-20s | %-15d | %-17d | %-17d%n", "BFS", bfsPath.size(), bfsNodes, bfsMemory);
		System.out.printf("%-20s | %-15d | %-17d | %-17d%n", "DFS", dfsPath.size(), dfsNodes, dfsMemory);
		System.out.printf("%-20s | %-15d | %-17d | %-17d%n", "UCS", ucsPath.size(), ucsNodes, ucsMemory);
		
		System.out.println("\nPaths:");
		System.out.println("BFS: " + pathToString(bfsPath));
		System.out.println("DFS: " + pathToString(dfsPath));
		System.out.println("UCS: " + pathToString(ucsPath));
	}

	/**
	 * Get city name from city index
	 */
	private static String getCityName(int cityIndex) {
		String[] cities = {
			"Oradea", "Zerind", "Arad", "Timisora", "Lugoj", "Mehadia",
			"Drobeta", "Craiova", "Rimnicu Vilcea", "Sibiu", "Fagaras",
			"Pitesti", "Bucharest", "Giurgiu", "Urziceni", "Vaslui",
			"Iasi", "Neamt", "Hirsova", "Eforie"
		};
		if (cityIndex >= 0 && cityIndex < cities.length) {
			return cities[cityIndex];
		}
		return "Unknown";
	}
}
