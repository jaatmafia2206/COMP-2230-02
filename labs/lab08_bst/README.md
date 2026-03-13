# Binary Search Tree Activity

**Tags:** Algorithm Analysis  
**Categories:** Lab  
**3 minute read**

Complete the following problems.

## Problem 1

This is not a valid binary search tree. What is wrong with it?

```
     32
    /  \
   16  45
  /  \
 5   38
```

## Problem 2

Use the Binary Search Tree insertion algorithm to insert the keys: 1, 2, 3, 4, 5, 6, 7 into an initially empty BST (in that order!).

**Height**

What is the height of the tree?

## Problem 3

```java
/*
 * What is the big-Theta running time of this method, assuming 
 * that list is
 * 
 * an ArrayList:
 * 
 * a LinkedList:
 * 
 */
public static int sumByIndex(List<Integer> list) {
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
        sum += list.get(i);
    }
    return sum;
}
```

## Problem 4

To determine the number of steps, count all assignments to sum.

```java
/*
 * What is the big-Theta running time of this method, assuming 
 * that list is:
 * 
 * an ArrayList:
 * 
 * a LinkedList:
 * 
 */
public static int sumWithIterator(List<Integer> list) {
    int sum = 0;
    for (int curValue : list) {
        sum += curValue;
    }
    return sum;
}
```

## Problem 5

```java
/*
 * What is the big-Theta running time of this method, 
 * assuming that toList is initially empty, and that both lists are 
 * of type:
 * 
 * ArrayList:
 * 
 * LinkedList:
 * 
 */
public static void copy(List<Integer> fromList,
                        List<Integer> toList) {
    for (int item : fromList) {
        toList.add(item);
    }
}
```

## Problem 6

```java
/*
 * What is the big-Theta running time of this method, assuming
 * that toList is initially empty, and that both lists 
 * are of type:
 * 
 * ArrayList:
 * 
 * LinkedList:
 * 
 */
public static void copyReverseA(List<Integer> fromList, 
                                List<Integer> toList) {
    for (int item : fromList) {
        toList.add(0, item);
    }
}
```

## Problem 7

```java
/*
 * What is the big-Theta running time of this method, assuming that
 * toList is initially empty, and that both lists are of type
 * 
 * ArrayList:
 * 
 * LinkedList:
 * 
 */
public static void copyReverseB(List<Integer> fromList, 
                                List<Integer> toList) {
    int value;
    for (int i = fromList.size() - 1; i >= 0; i--) {
        value = fromList.get(i);
        toList.add(value);
    }
}
```

## Problem 8

```java
/*
 * What is worst-case the big-Theta running time of this method,
 * assuming that toList is initially empty, and that both lists
 * are of the indicated type. Describe the worst case.
 * 
 * 
 * ArrayList:
 * 
 * 
 * LinkedList:
 * 
 * 
 * What is average-case the big-Theta running time of this method, 
 * assuming that toList is initially empty, and that both lists 
 * are of the indicated type.
 * 
 * 
 * ArrayList:
 * 
 * 
 * LinkedList:
 * 
 * 
 */
public static void copyScramble(List<Integer> fromList, 
                                List<Integer> toList) {
    Random gen = new Random();
    int randomIndex;
    int value;
    for (int i = 0; i < fromList.size(); i++) {
        randomIndex = gen.nextInt(fromList.size());
        value = fromList.remove(randomIndex);
        toList.add(value);
    }
}
```