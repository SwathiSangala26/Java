## 1️⃣ Definition

A **Jagged Array** is a multi-dimensional array where **each row can have a different number of columns**.

In Java, since 2D arrays are arrays of arrays, different row sizes are naturally supported.

So,

> Jagged array = Array of arrays with unequal row lengths

---

## 2️⃣ Visual Representation

### Example

```java
int[][] arr = new int[3][];
arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[1];
```

### Memory Structure

```
arr
 |
 v
+-------+-------+-------+
| row0  | row1  | row2  |
+-------+-------+-------+
    |        |        |
    v        v        v

  +---+---+     +---+---+---+---+     +---+
  | _ | _ |     | _ | _ | _ | _ |     | _ |
  +---+---+     +---+---+---+---+     +---+
```

Notice:

* Row 0 → 2 elements
* Row 1 → 4 elements
* Row 2 → 1 element

Not rectangular. Shape is uneven.

---

## 3️⃣ Key Features / Properties

✔ Rows can have different sizes
✔ Each row is a separate array object
✔ Memory efficient (no unused columns)
✔ Created dynamically row-by-row
✔ Access using `arr[row][column]`
✔ matrix.length → number of rows
✔ matrix[i].length → columns in that row

---

## 4️⃣ Syntax

### Step 1 – Declare

```java
int[][] arr;
```

### Step 2 – Create rows only

```java
arr = new int[3][];
```

### Step 3 – Create each row separately

```java
arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[1];
```

---

### Direct Initialization

```java
int[][] arr = {
    {1, 2},
    {3, 4, 5},
    {6}
};
```

---

## 5️⃣ Code Example

```java
public class Main {
    public static void main(String[] args) {

        int[][] arr = {
            {10, 20},
            {30, 40, 50},
            {60}
        };

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

---

## 6️⃣ Use Cases

✔ Storing variable-length data
✔ Representing triangular matrices
✔ Student marks (different subject counts)
✔ Sparse data representation
✔ Dynamic row sizes

Example:

Different students taking different numbers of subjects.

---

## 7️⃣ Pitfalls / Notes

⚠ Rows must be initialized before accessing

```java
int[][] arr = new int[3][];
System.out.println(arr[0][0]); 
```

✔ Compiles
❌ Runtime → NullPointerException

Because row 0 is not created.

---

⚠ Always use:

```
arr[i].length
```

Never assume fixed column size.

---

⚠ Not a true rectangular matrix

Interview trick:
Jagged array is not same as `new int[3][4]`

---

## 8️⃣ Real-World Analogy

Think of it like:

📚 Bookshelves with different number of books per shelf

```
Shelf 0 → [Book, Book]
Shelf 1 → [Book, Book, Book, Book]
Shelf 2 → [Book]
```

Each shelf has different capacity.

---

## 9️⃣ Best Practices

✔ Always initialize rows before access
✔ Use `arr[i].length` in inner loop
✔ Avoid assuming equal column size
✔ Validate row before accessing column
✔ Use enhanced for-loop for safer traversal

Example:

```java
for(int[] row : arr) {
    for(int value : row) {
        System.out.print(value + " ");
    }
}
```

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Is jagged array special type in Java?

❌ No.
It is simply a 2D array with unequal row sizes.

---

### 2️⃣ What is the output?

```java
int[][] arr = new int[2][];
arr[0] = new int[3];
System.out.println(arr.length);
```

✔ Output: 2
(Number of rows)

---

### 3️⃣ What is the output?

```java
int[][] arr = {
    {1,2},
    {3,4,5}
};
System.out.println(arr[1].length);
```

✔ Output: 3

---

### 4️⃣ What happens here?

```java
int[][] arr = new int[3][];
arr[0][1] = 10;
```

✔ Compiles
❌ Runtime → NullPointerException

---

### 5️⃣ Which is more memory efficient?

```
new int[3][1000]
```

vs

Jagged array with only required sizes?

✔ Jagged array (no unused columns)

---

### 6️⃣ Is this valid?

```java
int[][] arr = new int[3][4];
arr[1] = new int[10];
```

✔ Yes.
Row 1 is replaced with new array of size 10.

---

### 7️⃣ Time complexity to access arr[i][j]?

✔ O(1)

---

# 🧾 Quick Recap / Cheat Sheet

✔ Jagged = unequal row lengths
✔ Array of arrays
✔ Rows created separately
✔ arr.length → rows
✔ arr[i].length → columns
✔ Prevents memory wastage
✔ Can cause NullPointerException if row not initialized
✔ Access time → O(1)

---
