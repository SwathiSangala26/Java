## 1️⃣ Definition

**Sorting** is the process of arranging elements of an array in a specific order:

* Ascending (small → large)
* Descending (large → small)

In Java, sorting is mainly done using:

```java
Arrays.sort()
```

---

## 2️⃣ Visual Representation

### Before Sorting

```text
Index:   0   1   2   3
        ----------------
Array → | 5 | 2 | 9 | 1 |
        ----------------
```

### After Sorting (Ascending)

```text
Index:   0   1   2   3
        ----------------
Array → | 1 | 2 | 5 | 9 |
        ----------------
```

Sorting rearranges elements in-place.

---

## 3️⃣ Key Features / Properties

✔ Default order → Ascending
✔ Works for primitive & object arrays
✔ In-place sorting (modifies original array)
✔ Time Complexity → O(n log n)
✔ Stable sorting for objects
✔ Uses optimized internal algorithms

### Internal Algorithms Used

| Type             | Algorithm Used       |
| ---------------- | -------------------- |
| Primitive arrays | Dual-Pivot QuickSort |
| Object arrays    | TimSort              |

---

## 4️⃣ Syntax

### Import

```java
import java.util.Arrays;
```

### Basic Sorting

```java
Arrays.sort(arrayName);
```

---

## 5️⃣ Code Example

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
```

Output:

```
[1, 2, 5, 9]
```

---

## 6️⃣ Sorting in Descending Order

For primitive arrays, no direct method.

### Method 1: Sort + Reverse

```java
Arrays.sort(arr);

for(int i = 0; i < arr.length / 2; i++) {
    int temp = arr[i];
    arr[i] = arr[arr.length - 1 - i];
    arr[arr.length - 1 - i] = temp;
}
```

---

### Method 2: Using Wrapper Class

```java
Integer[] arr = {5,2,9,1};
Arrays.sort(arr, Collections.reverseOrder());
```

Note:

* reverseOrder() works only with objects (Integer, not int)

---

## 7️⃣ Use Cases

✔ Arranging data before searching
✔ Ranking systems
✔ Data processing
✔ Preparing data for binary search
✔ Organizing user input

---

## 8️⃣ Pitfalls / Notes

⚠ Sorting modifies original array

⚠ Cannot use reverseOrder() with primitive types

❌ Wrong:

```java
int[] arr = {5,2,9};
Arrays.sort(arr, Collections.reverseOrder()); // Error
```

---

⚠ Sorting must be done before binarySearch()

⚠ For objects, Comparable or Comparator must be defined

---

## 9️⃣ Real-World Analogy

Think of it like:

📚 Arranging books in order of price

Before:

```
₹500  ₹200  ₹900  ₹100
```

After Sorting:

```
₹100  ₹200  ₹500  ₹900
```

Sorting makes searching easier and faster.

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Does Arrays.sort() return a new array?

❌ No
It modifies original array (in-place).

---

### 2️⃣ What is time complexity?

✔ O(n log n)

---

### 3️⃣ Is sorting stable?

* Primitive → Not guaranteed stable
* Object (TimSort) → Stable

---

### 4️⃣ What is output?

```java
int[] arr = {3,1,2};
Arrays.sort(arr);
System.out.println(arr[0]);
```

✔ Output: 1

---

### 5️⃣ What happens here?

```java
int[] arr = null;
Arrays.sort(arr);
```

✔ Runtime → NullPointerException

---

### 6️⃣ Can we sort partial array?

✔ Yes

```java
Arrays.sort(arr, 1, 4);
```

Sorts from index 1 to 3 (end exclusive)

---

### 7️⃣ Why can’t reverseOrder() work with int[]?

Because reverseOrder() requires Object type
int is primitive, not object

---

### 8️⃣ Difference between Comparable and Comparator in sorting?

* Comparable → Natural ordering
* Comparator → Custom ordering

---

## 🧾 Quick Recap / Cheat Sheet

✔ Sorting = arranging elements
✔ Arrays.sort()
✔ Default → Ascending
✔ Time → O(n log n)
✔ Primitive → Dual-Pivot QuickSort
✔ Object → TimSort
✔ In-place modification
✔ reverseOrder() only for wrapper types
✔ Can sort partial array

---
