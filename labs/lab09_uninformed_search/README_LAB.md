# Uninformed Search Algorithms Lab

## Overview
In this lab, you will study and test three fundamental uninformed search algorithms: Breadth First Search (BFS), Depth First Search (DFS), and Uniform Cost Search (UCS). These algorithms are used to navigate through state spaces to find paths between nodes. The algorithms are provided, and your task is to understand them and complete analysis questions based on their behavior.

## Lab Structure

The lab is organized into three Java files:

### 1. **UninformedSearches.java** - Graph Infrastructure (Reference)
- **Purpose**: Provides the graph structure and helper methods
- **Contains**:
  - Graph initialization with 20 Romanian cities
  - Inner class `Node` - represents a city
  - Inner class `Edge` - represents connections between cities
  - Inner class `NodeComparator` - for priority queue sorting
  - Helper methods: `findAdjNodes()`, `findAdjEdges()`, `getCost()`
- **Your Role**: Study this file to understand the data structure, but do NOT modify it

### 2. **SearchAlgorithms.java** - Algorithm Implementation (Reference)
- **Purpose**: Contains the three fully-implemented search algorithms
- **Contains**:
  - `bfs()` - Breadth First Search using Queue
  - `dfs()` - Depth First Search using Stack
  - `ucs()` - Uniform Cost Search using PriorityQueue
  - Helper methods for statistics tracking
- **Your Role**: Study and understand how each algorithm works; use these in your testing

### 3. **SearchLab.java** - Testing and Lab Exercises
- **Purpose**: Test the algorithms and complete analysis exercises
- **Contains**:
  - `runBFSTest()` - Tests and displays BFS results
  - `runDFSTest()` - Tests and displays DFS results
  - `runUCSTest()` - Tests and displays UCS results
  - `runComparativeAnalysis()` - Compares all three algorithms on multiple test cases
  - `runInteractiveMode()` - Interactive testing where you can input any source/destination
  - Helper methods for result formatting and visualization
- **Your Role**: Run the main program, observe results, and answer the analysis questions

---

## Tasks and Exercises

### Task 1: Understand the Graph Structure
**Read and understand**: `UninformedSearches.java`
- Study how cities are represented as nodes
- Understand the adjacency matrix `map[][]` that stores edge costs
- Review helper methods for finding adjacent nodes and edges
- Examine the Node, Edge, and NodeComparator inner classes

---

### Task 2: Study the Algorithm Implementations
**File**: `SearchAlgorithms.java`

All three algorithms are fully implemented. Read and understand how they work:

#### BFS (Breadth First Search)
- Uses a **Queue** (FIFO - First In First Out)
- Explores nodes level-by-level (breadth-first)
- Finds the shortest path in terms of number of hops
- May not find the lowest-cost path

#### DFS (Depth First Search)
- Uses a **Stack** (LIFO - Last In First Out)
- Explores as deep as possible before backtracking
- May find a different path than BFS
- Good for exploring deep paths with limited memory

#### UCS (Uniform Cost Search)
- Uses a **PriorityQueue** (sorted by cumulative cost)
- Always explores the lowest-cost node first
- Guaranteed to find the minimum-cost path
- Most thorough but most expensive algorithm

---

### Task 3: Run the Lab
**File**: `SearchLab.java`

Compile and run the program:
```bash
javac UninformedSearches.java SearchAlgorithms.java SearchLab.java
java SearchLab
```

The program will automatically:
1. Run BFS test from Oradea (0) to Bucharest (12)
2. Run DFS test from Oradea (0) to Bucharest (12)
3. Run UCS test from Oradea (0) to Bucharest (12)
4. Compare all three algorithms on two test cases with detailed statistics
5. Display analysis questions
6. Provide interactive mode for testing custom routes

---

### Task 4: Complete the Analysis Questions

After running the lab, you will see output with test cases and a comparison table. Use this data to answer:

1. **Which algorithm finds the shortest path in terms of number of hops?**
   - Look at "Path Length" column in the comparison table
   - Answer: ___________

2. **Which algorithm finds the lowest-cost path?**
   - UCS finds the minimum total edge cost (optimal cost)
   - Compare the actual paths and edge weights
   - Answer: ___________

3. **Which algorithm uses the least memory?**
   - Look at "Max Memory" column in the comparison table
   - Answer: ___________

4. **When would you use each algorithm?**
   - BFS: ___________
   - DFS: ___________
   - UCS: ___________

5. **What are the time and space complexities?**
   - BFS: O(___) time, O(___) space
   - DFS: O(___) time, O(___) space
   - UCS: O(___) time, O(___) space

6. **What do you observe about path length vs. path cost for different algorithms?**
   - Answer: ___________

---

## Test Cases to Try

The lab automatically runs these test cases:

### Test Case 1: Oradea (0) to Bucharest (12)
Compare how each algorithm finds a path between these cities.

### Test Case 2: Arad (2) to Bucharest (12)
See if the algorithms behave differently on this route.

---

## Interactive Mode

After the automated tests, the program enters interactive mode where you can:

1. Enter any source city (0-19)
2. Enter any destination city (0-19)
3. Choose which algorithm to use:
   - Option 1: Run only BFS
   - Option 2: Run only DFS
   - Option 3: Run only UCS
   - Option 4: Run all three and compare
4. Continue testing other routes or exit

This is great for experimenting and answering the analysis questions!

---

## City Reference
| City | Index | City | Index |
|------|-------|------|-------|
| Oradea | 0 | Bucharest | 12 |
| Zerind | 1 | Giurgiu | 13 |
| Arad | 2 | Urziceni | 14 |
| Timisora | 3 | Vaslui | 15 |
| Lugoj | 4 | Iasi | 16 |
| Mehadia | 5 | Neamt | 17 |
| Drobeta | 6 | Hirsova | 18 |
| Craiova | 7 | Eforie | 19 |
| Rimnicu Vilcea | 8 | | |
| Sibiu | 9 | | |
| Fagaras | 10 | | |
| Pitesti | 11 | | |

---

## Submission Checklist

- [ ] Studied `UninformedSearches.java` and understand the graph structure
- [ ] Read through all three algorithm implementations in `SearchAlgorithms.java`
- [ ] Successfully compiled and ran `SearchLab.java`
- [ ] Reviewed output from all test cases
- [ ] Answered all analysis questions
- [ ] Tested custom routes using interactive mode
- [ ] Compared algorithm performance across different routes
- [ ] Understood time and space complexity tradeoffs

---

## Tips & Hints

1. **Understand the output format**: 
   - Path Length = number of cities in the path
   - Nodes Generated = total cities visited during search
   - Max Memory = maximum frontier size at any point

2. **Trace through manually**: 
   - Pick a small test case (e.g., Arad to Sibiu)
   - Manually trace through how BFS would explore it
   - Understand why DFS might take a different path

3. **Compare performance**:
   - BFS usually generates fewer nodes (explores level-by-level)
   - DFS may find longer paths but uses different exploration order
   - UCS takes the middle ground - explores efficiently but considers costs

4. **Interactive testing tips**:
   - Test the same route with all three algorithms
   - Note the differences in path length and nodes generated
   - Try routes with multiple possible paths

5. **Key observations**:
   - Shortest path (hops) ≠ Lowest cost path
   - Memory usage varies significantly between algorithms
   - Algorithm choice depends on your optimization goal (hops, cost, or memory)

---

## References

- **Breadth-First Search**: Explores nodes in layers, guaranteed shortest path in unweighted graphs
- **Depth-First Search**: Explores as deep as possible before backtracking, uses less memory for wide graphs
- **Uniform Cost Search**: Always expands lowest-cost node, guaranteed optimal path in weighted graphs

---

## Questions or Issues?

If you encounter any issues running the lab:
1. Make sure all three `.java` files are in the same directory
2. Compile all files together: `javac UninformedSearches.java SearchAlgorithms.java SearchLab.java`
3. Run the main program: `java SearchLab`
4. Check the graph structure in `UninformedSearches.java` to understand the city connections
5. Review the algorithm implementations in `SearchAlgorithms.java` if results are unexpected

If you have questions about the algorithms:
1. Research the specific algorithm (BFS, DFS, UCS) in your textbook
2. Compare the implementation with the algorithm pseudocode
3. Test with a simple route first and trace through manually
4. Try the interactive mode to see patterns across different routes
