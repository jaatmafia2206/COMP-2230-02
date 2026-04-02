/**
 * Uninformed Search - Graph Infrastructure
 * 
 * This class sets up the graph structure, initializes cities and connections,
 * and provides helper methods for search algorithms.
 * 
 * Author: Yasser Ghamlouch
 * Student Number: 6276898
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class UninformedSearches {

	public final static int NUM_OF_CITIES = 20;

	// Every city is assigned an integer
	private final static int ORADEA = 0;
	private final static int ZERIND = 1;
	private final static int ARAD = 2;
	private final static int TIMISORA = 3;
	private final static int LUGOJ = 4;
	private final static int MEHADIA = 5;
	private final static int DROBETA = 6;
	private final static int CRAIOVA = 7;
	private final static int RIMNICU_VILCEA = 8;
	private final static int SIBIU = 9;
	private final static int FAGARAS = 10;
	private final static int PITESTI = 11;
	private final static int BUCHAREST = 12;
	private final static int GIURGIU = 13;
	private final static int URZICENI = 14;
	private final static int VASLUI = 15;
	private final static int IASI = 16;
	private final static int NEAMT = 17;
	private final static int HIRSOVA = 18;
	private final static int EFORIE = 19;

	// Every city is represented by a Node instance
	private Node oradea;
	private Node zerind;
	private Node arad;
	private Node timisora;
	private Node lugoj;
	private Node mehadia;
	private Node drobeta;
	private Node craiova;
	private Node rimnicuVilcea;
	private Node sibiu;
	private Node fagaras;
	private Node pitesti;
	private Node bucharest;
	private Node giurgiu;
	private Node urziceni;
	private Node vaslui;
	private Node iasi;
	private Node neamt;
	private Node hirsova;
	private Node eforie;

	// This is an adjacency matrix that defines what cities connect
	private Integer[][] map = new Integer[NUM_OF_CITIES][NUM_OF_CITIES];
	// This is a map that stores each city as a node with a key value
	// corresponding to the integer associated to that city.
	private HashMap<Integer, Node> cities = new HashMap<Integer, UninformedSearches.Node>(); 
	
	/**
	 * Constructor: Initializes the adjacency matrix and creates the nodes
	 */
	public UninformedSearches(){
		initData(this.map);
		createNodes();
		initHashMap();
	}

	/**
	 * This initializes the adjacency matrix with all the connected cities
	 * and the cost of going from one city to another.
	 * @param map: a 2x2 Array
	 */
	private void initData(Integer[][] map){
		map[ORADEA][ZERIND] = 71;
		map[ORADEA][SIBIU] = 151;
		map[ZERIND][ORADEA] = 71;
		map[ZERIND][ARAD] = 75;
		map[ARAD][ZERIND] = 75;
		map[ARAD][SIBIU] = 140;
		map[ARAD][TIMISORA] = 118;
		map[TIMISORA][ARAD] = 118;
		map[TIMISORA][LUGOJ] = 111;
		map[LUGOJ][TIMISORA] = 111;
		map[LUGOJ][MEHADIA] = 70;
		map[MEHADIA][LUGOJ] = 70;
		map[MEHADIA][DROBETA] = 75;
		map[DROBETA][MEHADIA] = 75;
		map[DROBETA][CRAIOVA] = 120;
		map[CRAIOVA][RIMNICU_VILCEA] = 146;
		map[CRAIOVA][DROBETA] = 120;
		map[CRAIOVA][PITESTI] = 138;
		map[RIMNICU_VILCEA][SIBIU] = 80;
		map[RIMNICU_VILCEA][PITESTI] = 97;
		map[RIMNICU_VILCEA][CRAIOVA] = 146;
		map[SIBIU][ORADEA] = 151;
		map[SIBIU][ARAD] = 140;
		map[SIBIU][FAGARAS] = 99;
		map[SIBIU][RIMNICU_VILCEA] = 80;
		map[FAGARAS][SIBIU] = 99;
		map[FAGARAS][BUCHAREST] = 211;
		map[PITESTI][RIMNICU_VILCEA] = 87;
		map[PITESTI][CRAIOVA] = 138;
		map[PITESTI][BUCHAREST] = 101;
		map[BUCHAREST][PITESTI] = 101;
		map[BUCHAREST][FAGARAS] = 211;
		map[BUCHAREST][GIURGIU] = 90;
		map[BUCHAREST][URZICENI] = 85;
		map[GIURGIU][BUCHAREST] = 90;
		map[URZICENI][BUCHAREST] = 85;
		map[URZICENI][VASLUI] = 142;
		map[URZICENI][HIRSOVA] = 98;
		map[VASLUI][IASI] = 92;
		map[VASLUI][URZICENI] = 142;
		map[IASI][NEAMT] = 87;
		map[IASI][VASLUI] = 92;
		map[NEAMT][IASI] = 87;
		map[HIRSOVA][URZICENI] = 98;
		map[HIRSOVA][EFORIE] = 86;
		map[EFORIE][HIRSOVA] = 86;
	}
	
	/**
	 * This method is called by the constructor to initialize the node
	 * corresponding to each city
	 */
	private void createNodes(){
		oradea = new Node(ORADEA);
		zerind = new Node(ZERIND);
		arad = new Node(ARAD);
		timisora = new Node(TIMISORA);
		lugoj = new Node(LUGOJ);
		mehadia = new Node(MEHADIA);
		drobeta = new Node(DROBETA);
		craiova = new Node(CRAIOVA);
		rimnicuVilcea = new Node(RIMNICU_VILCEA);
		sibiu = new Node(SIBIU);
		fagaras = new Node(FAGARAS);
		pitesti = new Node(PITESTI);
		bucharest = new Node(BUCHAREST);
		giurgiu = new Node(GIURGIU);
		urziceni = new Node(URZICENI);
		vaslui = new Node(VASLUI);
		iasi = new Node(IASI);
		neamt = new Node(NEAMT);
		hirsova = new Node(HIRSOVA);
		eforie = new Node(EFORIE);
	}
	
	/**
	 * This method initializes the values of the hashmap with the cities and
	 * their corresponding integers
	 */
	private void initHashMap(){
		this.cities.put(ORADEA, oradea);
		this.cities.put(ZERIND, zerind);
		this.cities.put(ARAD, arad);
		this.cities.put(TIMISORA, timisora);
		this.cities.put(LUGOJ, lugoj);
		this.cities.put(MEHADIA, mehadia);
		this.cities.put(DROBETA, drobeta);
		this.cities.put(CRAIOVA, craiova);
		this.cities.put(RIMNICU_VILCEA, rimnicuVilcea);
		this.cities.put(SIBIU, sibiu);
		this.cities.put(FAGARAS, fagaras);
		this.cities.put(PITESTI, pitesti);
		this.cities.put(BUCHAREST, bucharest);
		this.cities.put(GIURGIU, giurgiu);
		this.cities.put(URZICENI, urziceni);
		this.cities.put(VASLUI, vaslui);
		this.cities.put(IASI, iasi);
		this.cities.put(NEAMT, neamt);
		this.cities.put(HIRSOVA, hirsova);
		this.cities.put(EFORIE, eforie);
	}
	
	/**
	 * This method finds all the nodes that are adjacent to the provided node
	 * and returns them in a list
	 * @param n
	 * @return adjNodes: an array list holding the adjacent nodes to the
	 * provided node
	 */
	public ArrayList<Node> findAdjNodes(int n){
		ArrayList<Node> adjNodes = new ArrayList<UninformedSearches.Node>();
		for(int i = 0; i < NUM_OF_CITIES; i++){
			if(map[n][i] != null){
				adjNodes.add(cities.get(i));
			}
		}
		return adjNodes;
	}

	/**
	 * This method finds all the edges that are adjacent to the provided node
	 * and returns them in a list
	 * @param n
	 * @return adjEdges: an array list holding the adjacent edges to the
	 * provided node
	 */
	public ArrayList<Edge> findAdjEdges(int n){
		ArrayList<Edge> adjEdges = new ArrayList<UninformedSearches.Edge>();
		for(int i = 0; i < NUM_OF_CITIES; i++){
			if(map[n][i] != null){
				Node child = new Node(i);
				adjEdges.add(new Edge(cities.get(n), child, map[n][i]));
			}
		}
		return adjEdges;
	}

	/**
	 * Get the cost from source city to destination city
	 * @param src source city index
	 * @param dest destination city index
	 * @return cost of traversal, or -1 if not connected
	 */
	public int getCost(int src, int dest) {
		return map[src][dest] != null ? map[src][dest] : -1;
	}

	/**
	 * Get HashMap of all cities
	 * @return HashMap of cities
	 */
	public HashMap<Integer, Node> getCities() {
		return cities;
	}

	/*--------------------------------------------------------------------------
	 * Inner Classes
	 -------------------------------------------------------------------------*/
	
	/**
	 * Class Node which is an inner class of the main class UninformedSearches,
	 * a node is used to represent a city, it holds the value of the city as an
	 * integer, the list of adjacent nodes and the list of adjacent edges to
	 * that node
	 */
	public class Node{
		private int city;
		private ArrayList<Node> adjNodes;
		private ArrayList<Edge> adjEdges;
		private int tempCost = 0;

		public Node(int value){
			this.city = value;
		}
		
		public void updateCost(int cost){
			tempCost += cost;
		}
		
		public int getCost(){
			return this.tempCost;
		}
		
		@SuppressWarnings("unused")
		public void resetCost(){
			tempCost = 0;
		}

		public void expandNode(ArrayList<Node> adjNodes, 
				ArrayList<Edge> adjEdges){
			this.adjNodes = adjNodes;
			this.adjEdges = adjEdges;
		}
		
		@SuppressWarnings("unused")
		public void print(){
			String s = "";
			s = s + ("Node: "+this.city);
			if(adjNodes != null){
				s = s + " --> Children --> ";
				for(int i = 0; i < adjNodes.size(); i++){
					s = s + "Node "+adjNodes.get(i).city + ": ";
					s = s + adjEdges.get(i).cost + ", ";
				}
			}
			System.out.println(s);
		}

		public int getCity() {
			return city;
		}

		public ArrayList<Node> getAdjNodes() {
			return adjNodes;
		}

		public ArrayList<Edge> getAdjEdges() {
			return adjEdges;
		}
	}

	/**
	 * Class Edge represents a connection between cities with associated cost
	 */
	public class Edge{
		private Node src;
		private Node dest;
		private int cost;

		public Edge(Node src, Node dest, int cost){
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}

		public Node getSrc() {
			return src;
		}

		public Node getDest() {
			return dest;
		}

		public int getCost() {
			return cost;
		}
	}
	
	/**
	 * This class is a comparator that defines how to compare two nodes based
	 * on the cost difference between them.
	 */
	public class NodeComparator implements Comparator<Node>
	{
		@Override
		public int compare(Node x, Node y)
		{
			if (x.getCost() < y.getCost()) {
				return -1;
			}
			if (x.getCost() > y.getCost()) {
				return 1;
			}
			return 0;
		}
	}
}
