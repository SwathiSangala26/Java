## 1️⃣ Definition

The **Arrays Utility Class** is a predefined class in:

```java
java.util.Arrays
```

It provides **static methods** to manipulate arrays such as:

* Sorting
* Searching
* Comparing
* Filling
* Converting to String
* Copying

You don’t create an object of Arrays class because all methods are **static**.

---

## 2️⃣ Visual Representation

Think of it like:

```text
Your Array  →  Arrays Utility Methods  →  Modified / Result Array
```

Example:

```text
[5, 2, 9, 1] 
     |
     |  Arrays.sort()
     v
[1, 2, 5, 9]
```

Arrays class acts like a **toolbox for arrays**.

---

## 3️⃣ Key Features / Properties

✔ Located in `java.util` package
✔ Contains only static methods
✔ Works on both primitive and object arrays
✔ Uses optimized sorting algorithms
✔ Provides deep comparison methods

---

## 4️⃣ Syntax

### Import

```java
import java.util.Arrays;
```

### Method Call

```java
Arrays.methodName(array);
```

Example:

```java
Arrays.sort(arr);
```

---

## 5️⃣ Code Example

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};

        // Sort
        Arrays.sort(arr);

        // Convert to String
        System.out.println(Arrays.toString(arr));

        // Binary Search
        int index = Arrays.binarySearch(arr, 5);
        System.out.println("Index: " + index);
    }
}
```

Output:

```
[1, 2, 5, 9]
Index: 2
```

---

## 6️⃣ Important Methods (Must Know for Interview)

---

### 1️⃣ sort()

```java
Arrays.sort(arr);
```

✔ Sorts in ascending order
✔ Uses Dual-Pivot QuickSort (primitive)
✔ Uses TimSort (objects)

---

### 2️⃣ binarySearch()

```java
Arrays.binarySearch(arr, key);
```

✔ Array must be sorted
✔ Returns index if found
✔ If not found → returns `-(insertionPoint) - 1`

Example:

```java
Arrays.binarySearch(arr, 7);
```

If 7 not present → returns negative value.

---

### 3️⃣ toString()

```java
Arrays.toString(arr);
```

✔ Converts 1D array to readable string

Without it:

```java
System.out.println(arr);
```

Output → `[I@15db9742` (hashcode)

---

### 4️⃣ deepToString()

Used for 2D arrays:

```java
Arrays.deepToString(arr2D);
```

---

### 5️⃣ equals()

```java
Arrays.equals(arr1, arr2);
```

✔ Compares content
✔ Not reference comparison

---

### 6️⃣ deepEquals()

Used for multi-dimensional arrays.

---

### 7️⃣ fill()

```java
Arrays.fill(arr, 100);
```

✔ Fills entire array with same value

---

### 8️⃣ copyOf()

```java
int[] newArr = Arrays.copyOf(arr, newLength);
```

✔ Creates new array
✔ Can increase size

---

### 9️⃣ copyOfRange()

```java
Arrays.copyOfRange(arr, from, to);
```

✔ Copies subarray
✔ `to` is exclusive

---

## 7️⃣ Use Cases

✔ Sorting input data
✔ Searching efficiently
✔ Comparing arrays
✔ Debugging (toString)
✔ Creating resized array
✔ Filling default values

---

## 8️⃣ Pitfalls / Notes

⚠ binarySearch requires sorted array

Wrong:

```java
int[] arr = {5,1,9};
Arrays.binarySearch(arr, 9); // Unpredictable result
```

---

⚠ equals() vs ==

```java
arr1 == arr2   // compares reference
Arrays.equals(arr1, arr2)  // compares content
```

---

⚠ toString() works only for 1D arrays
Use deepToString() for 2D.

---

⚠ copyOf() creates new array (does not modify original)

---

## 9️⃣ Real-World Analogy

Think of Arrays class as:

🧰 A toolbox for arrays

Instead of writing your own:

* Sorting logic
* Searching logic
* Copying logic

You just call ready-made optimized tools.

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Is Arrays class object created?

❌ No.
All methods are static.

---

### 2️⃣ What happens?

```java
int[] arr = {5,3,1};
System.out.println(Arrays.binarySearch(arr,3));
```

✔ Compiles
❌ Result unpredictable (array not sorted)

---

### 3️⃣ What is output?

```java
int[] arr = {1,2,3};
System.out.println(arr);
```

✔ Prints hashcode (not content)

---

### 4️⃣ Difference between equals() and deepEquals()?

* equals() → 1D array
* deepEquals() → multi-dimensional arrays

---

### 5️⃣ What is output?

```java
int[] arr = {1,2,3};
int[] newArr = Arrays.copyOf(arr, 5);
System.out.println(Arrays.toString(newArr));
```

✔ Output: `[1, 2, 3, 0, 0]`
(New elements get default value)

---

### 6️⃣ What does binarySearch return if element not found?

✔ Negative value
Formula: `-(insertionPoint) - 1`

---

### 7️⃣ Time Complexity of sort()?

✔ O(n log n)

---

# 🧾 Quick Recap / Cheat Sheet

✔ Located in java.util
✔ Static methods only
✔ sort() → O(n log n)
✔ binarySearch() → requires sorted array
✔ equals() → compares content
✔ deepEquals() → for multi-d arrays
✔ toString() → 1D
✔ deepToString() → multi-d
✔ fill() → fill values
✔ copyOf() → resize array

---
