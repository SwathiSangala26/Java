## Definition

• A jagged array is a **multi-dimensional array where each row can have a different length**
• It is an **array of arrays**
• Rows are **not required to have equal number of columns**
• This is the **default behavior** of 2D arrays in Java

---

## Important Concept

• Java does **not** create a true rectangular matrix
• Each row is a **separate 1D array object**
• Column size can vary per row

```
arr
 ├── row 0 → [ ][ ]
 ├── row 1 → [ ][ ][ ][ ]
 └── row 2 → [ ]
```

---

## Declaration

```java
int[][] arr;
```

• Same as normal 2D array declaration

---

## Creation of Jagged Array (Step-by-Step)

```java
int[][] arr = new int[3][];
```

Meaning:
• Number of rows = 3
• Columns not allocated yet

Memory state:

```
STACK → arr
HEAP  → [ null, null, null ]
```

---

## Allocating Each Row Separately

```java
arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[1];
```

Memory layout:

```
row 0 → [ ][ ]
row 1 → [ ][ ][ ][ ]
row 2 → [ ]
```

---

## Declaration + Initialization Together

```java
int[][] arr = {
    {1, 2},
    {3, 4, 5, 6},
    {7}
};
```

• Row lengths decided at compile time
• Jagged structure created automatically

---

## Default Values in Jagged Arrays

• Default values apply **per row array**
• int → 0
• boolean → false
• char → '\u0000'
• Object → null

---

## Accessing Elements

```java
arr[rowIndex][colIndex];
```

Example:

```java
arr[1][2];  // third element of second row
```

---

## Length Properties

• Number of rows:

```java
arr.length
```

• Number of columns in a specific row:

```java
arr[i].length
```

Important:
• Each row has its **own length**

---

## Traversing Jagged Array (for Loop)

```java
for(int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
    }
}
```

• Always use `arr[i].length`
• Never assume same column size

---

## Traversing Jagged Array (Enhanced for-Loop)

```java
for(int[] row : arr) {
    for(int value : row) {
        System.out.print(value + " ");
    }
}
```

• Clean syntax
• No index access
• Safe for jagged structure

---

## Partial Initialization (Very Important)

```java
int[][] arr = new int[3][];
```

```
arr → [ null, null, null ]
```

• Rows exist
• Columns not allocated
• Accessing `arr[i][j]` causes `NullPointerException`

---

## Runtime Exceptions

• `NullPointerException`
– Row array is not initialized

• `ArrayIndexOutOfBoundsException`
– Invalid row or column index

---

## Memory Representation (Internal)

```
STACK
-----
arr ───────────► HEAP

HEAP
----
arr (main array)
 ├── row 0 reference ──► int[]
 ├── row 1 reference ──► int[]
 └── row 2 reference ──► int[]
```

• Main array stores row references
• Each row stored separately

---

## Time Complexity

• Access element → O(1)
• Traversal → O(total elements)

---

## Space Complexity

• O(total elements)
• Efficient memory usage compared to rectangular arrays

---

## Why Jagged Arrays Are Useful

• Saves memory
• Flexible structure
• Suitable when rows have unequal data
• Avoids wasted space

---

## Jagged Array vs Rectangular 2D Array

• Rectangular → same column size
• Jagged → different column sizes
• Java internally treats both as jagged

---

## Use Cases

• Triangular matrices
• Variable-length records
• Graph adjacency lists
• Sparse data representation

---

## Passing Jagged Array to Method

• Passed by reference value
• Changes affect original structure

---

## Returning Jagged Array from Method

• Allowed
• Returned as object reference
