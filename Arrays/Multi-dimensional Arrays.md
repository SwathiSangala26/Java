## 1️⃣ Definition

A **Multi-Dimensional Array** is an array that contains other arrays as its elements.

In Java, multi-dimensional arrays are actually **arrays of arrays**.

Most common type:
✔ **2D Array** (rows and columns)

---

## 2️⃣ Visual Representation

### 2D Array Example

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6}
};
```

### Memory Structure (Array of Arrays)

```
matrix
   |
   v
+---------+---------+
|  row0   |  row1   |
+---------+---------+
     |           |
     v           v

  +---+---+---+   +---+---+---+
  | 1 | 2 | 3 |   | 4 | 5 | 6 |
  +---+---+---+   +---+---+---+
```

Important:

* `matrix` stores references to row arrays
* Each row is a separate array object in heap
* Not truly continuous 2D block (like C)

---

## 3️⃣ Key Features / Properties

✔ Array of arrays
✔ Can be 2D, 3D, etc.
✔ Rows can have different lengths (Jagged array)
✔ Fixed size once created
✔ Access using multiple indices → `arr[row][column]`
✔ Default values applied to each element

### Default Values (same as single array)

| Data Type | Default |
| --------- | ------- |
| int       | 0       |
| boolean   | false   |
| Object    | null    |

---

## 4️⃣ Syntax

### Declaration

```java
dataType[][] arrayName;
```

OR

```java
dataType arrayName[][];
```

---

### Instantiation

```java
arrayName = new dataType[rows][columns];
```

Example:

```java
int[][] matrix = new int[2][3];
```

---

### Initialization

```java
int[][] matrix = {
    {1,2,3},
    {4,5,6}
};
```

---

## 5️⃣ Code Example

```java
public class Main {
    public static void main(String[] args) {

        int[][] matrix = new int[2][3];

        // Assigning values
        matrix[0][0] = 10;
        matrix[1][2] = 50;

        // Traversing
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## 6️⃣ Use Cases

✔ Matrix representation
✔ Tabular data (rows & columns)
✔ Game boards (Tic-Tac-Toe)
✔ Image processing (pixels)
✔ Graph adjacency matrix

---

## 7️⃣ Pitfalls / Notes

⚠ Rows may have different lengths (Jagged array)

```java
int[][] arr = new int[3][];
arr[0] = new int[2];
arr[1] = new int[5];
arr[2] = new int[1];
```

Memory view:

```
Row 0 → [ _  _ ]
Row 1 → [ _  _  _  _  _ ]
Row 2 → [ _ ]
```

⚠ Access carefully

```java
arr[0][3]; // ArrayIndexOutOfBoundsException
```

⚠ matrix.length → number of rows
⚠ matrix[i].length → number of columns in that row

⚠ NullPointerException if row not initialized

```java
int[][] arr = new int[3][];
System.out.println(arr[0][0]); // Runtime error
```

---

## 8️⃣ Real-World Analogy

Think of it like:

📊 Excel Sheet

```
        Col0   Col1   Col2
Row0 →   1      2      3
Row1 →   4      5      6
```

* Rows → horizontal
* Columns → vertical
* Access like: row number + column number

---

## 9️⃣ Best Practices

✔ Always use `arr.length` for rows
✔ Always use `arr[i].length` for columns
✔ Validate row before accessing column
✔ Use enhanced for-loop when modification not needed

Example:

```java
for(int[] row : matrix) {
    for(int value : row) {
        System.out.print(value + " ");
    }
}
```

✔ Initialize jagged rows properly before access

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Is Java 2D array stored in continuous memory?

❌ No.
It is an array of arrays (separate objects).

---

### 2️⃣ What is the output?

```java
int[][] arr = new int[2][3];
System.out.println(arr[1][2]);
```

✔ Output: 0 (default int value)

---

### 3️⃣ What is length?

```java
int[][] arr = new int[3][4];
System.out.println(arr.length);
```

✔ Output: 3 (number of rows)

---

### 4️⃣ What is the output?

```java
int[][] arr = {
    {1,2},
    {3,4,5}
};
System.out.println(arr[1].length);
```

✔ Output: 3
(Jagged array — row 1 has 3 elements)

---

### 5️⃣ Will this compile?

```java
int[][] arr = new int[2][];
arr[0][0] = 5;
```

✔ Compiles
❌ Runtime → NullPointerException
(Row not initialized)

---

### 6️⃣ Can we create 3D array?

✔ Yes

```java
int[][][] cube = new int[2][3][4];
```

---

### 7️⃣ Time complexity to access arr[i][j]?

✔ O(1)

---

### 8️⃣ Difference between:

```java
int[][] arr = new int[2][3];
```

vs

```java
int[][] arr = new int[2][];
```

First → All rows + columns created
Second → Only row references created

---

# 🧾 Quick Recap / Cheat Sheet

✔ Array of arrays
✔ Can be 2D, 3D, etc.
✔ Rows may have different sizes (Jagged)
✔ matrix.length → rows
✔ matrix[i].length → columns
✔ Stored in heap
✔ Default values assigned
✔ Access time → O(1)
✔ Not continuous 2D memory block

---
