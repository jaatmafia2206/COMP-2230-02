# Search Algorithm Performance Lab

This project compares the efficiency of **Linear Search** and **Binary Search** using Java. By running a performance test on an array of 1,000,000 elements, we can visually see the difference between  and  time complexities.

## Overview

The lab consists of three main components:

1. **Linear Search**: A sequential search that checks every element.
2. **Binary Search**: An efficient "divide and conquer" search (requires sorted data).
3. **Performance Comparison**: A driver class that measures execution time in nanoseconds.

## Performance Comparison

When searching for the last element in a sorted array of 1,000,000 integers:

| Algorithm | Complexity | Efficiency |
| --- | --- | --- |
| **Linear Search** | O(n) | Checks up to 1,000,000 items |
| **Binary Search** | O(log n) | Checks ~20 items |

### Search Logic Visualized

## How to Run

1. Ensure you have Java (JDK) installed.
2. Compile the files:
```bash
javac PerformanceComparison.java

```


3. Run the comparison:
```bash
java PerformanceComparison

```

## 📝 Key Learning: The Overflow Bug

In the `binarySearch` implementation, we use:
`int mid = low + (high - low) / 2;`

This prevents a potential **Integer Overflow** bug that occurs in very large arrays when using the standard `(low + high) / 2` formula.

---

