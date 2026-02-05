## 1. Definition

• A multi-dimensional array is an **array of arrays**
• Each element of the main array holds a **reference to another array**
• Most commonly used: **2D array**
• Java does **not** support true matrix memory like C/C++

---

## 2. 2D Array (Most Important)

• Represents data in **rows and columns**
• Accessed using **two indices**
• Syntax:

```java
int[][] arr;
```

---

## 3. Array of Arrays Concept

• 2D array is **not stored in one contiguous block**
• Each row is a **separate array object**

```
arr
 ├── row 0 → [ ][ ][ ]
 ├── row 1 → [ ][ ][ ]
 └── row 2 → [ ][ ][ ]
```

---

## 4. Declaration

```java
int[][] arr;
int arr[][];
int[] arr[];
```

• All valid
• `int[][] arr` is preferred

---

## 5. Initialization Using new

```java
int[][] arr = new int[3][4];
```

Meaning:
• 3 rows
• 4 columns per row
• Total elements = 12

---

## 6. Memory Allocation (2D Array)

```
STACK
-----
arr ───────────────► HEAP

HEAP
----
arr → references
      ├── row 0 → int[4]
      ├── row 1 → int[4]
      └── row 2 → int[4]
```

• One main array
• Multiple child arrays

---

## 7. Default Values

• int → 0
• double → 0.0
• boolean → false
• char → '\u0000'
• Object → null

Applied to **each cell**

---

## 8. Declaration + Initialization Together

```java
int[][] arr = {
    {1, 2, 3},
    {4, 5, 6}
};
```

• Rows = 2
• Columns = variable per row (allowed)

---

## 9. Accessing Elements

```java
arr[0][0];
arr[1][2];
```

• First index → row
• Second index → column

---

## 10. Index Rules

• Row index range: `0 → arr.length - 1`
• Column index range: `0 → arr[row].length - 1`

---

## 11. Length in 2D Arrays

```
arr.length          → number of rows
arr[i].length       → number of columns in row i
```

Example:

```java
int rows = arr.length;
int cols = arr[0].length;
```

---

## 12. Traversing 2D Array (for Loop)

```java
for(int i = 0; i < arr.length; i++) {
    for(int j = 0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
    }
}
```

• Full index control
• Required for most logic problems

---

## 13. Traversing 2D Array (Enhanced for-Loop)

```java
for(int[] row : arr) {
    for(int value : row) {
        System.out.print(value + " ");
    }
}
```

• Cleaner syntax
• No index access
• Read-only style

---

## 14. Jagged Array (VERY IMPORTANT)

• Rows can have **different column sizes**
• Default behavior in Java

Example:

```java
int[][] arr = new int[3][];
arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[1];
```

Memory:

```
row 0 → [ ][ ]
row 1 → [ ][ ][ ][ ]
row 2 → [ ]
```

---

## 15. Why Java Supports Jagged Arrays

• Flexible memory usage
• Avoids wasted space
• Easier dynamic row handling

---

## 16. Empty vs Null in 2D Arrays

### Empty 2D Array

```java
int[][] arr = new int[0][0];
```

```
STACK → arr
HEAP  → array object
        rows = 0
```

---

### Null 2D Array

```java
int[][] arr = null;
```

```
STACK → arr = null
HEAP  → no array object
```

---

## 17. Partial Initialization

```java
int[][] arr = new int[3][];
```

```
arr → [null, null, null]
```

• Rows exist
• Columns not allocated
• Accessing arr[i][j] → NullPointerException

---

## 18. Runtime Exceptions

• `ArrayIndexOutOfBoundsException`
– Invalid row or column index

• `NullPointerException`
– Row array is null

---

## 19. Passing 2D Array to Method

• Passed by reference value
• Modifications affect original array

---

## 20. Returning 2D Array from Method

• Allowed
• Returned as object reference

---

## 21. Time Complexity

• Access element → O(1)
• Traversal → O(rows × columns)

---

## 22. Space Complexity

• O(rows × columns)

---

## 23. JVM Internal Handling

```
Heap Structure:
┌──────────────┐
│ int[][] arr  │
│ length = r   │
│ row refs     │───► int[]
│              │───► int[]
└──────────────┘
```

• Main array stores row references
• Each row is a separate array object
• Bounds checking at each dimension

---

## 24. Performance Characteristics

• Slower than 1D arrays
• Extra indirection (row reference)
• Flexible memory layout

---

## 25. 2D Array vs Matrix (Interview Point)

• Java uses **array of arrays**
• Not a true matrix
• Rows may not be contiguous

---

## 26. Multi-Dimensional Arrays (>2D)

Example:

```java
int[][][] arr = new int[2][3][4];
```

• 3D array = array of 2D arrays
• Same principles apply

---

## 27. Use Cases

• Matrix problems
• Grids
• Tables
• Dynamic row-based data

---

## 28. When to Avoid 2D Arrays

• Large sparse data
• Dynamic resizing
• Prefer collections for flexibility
