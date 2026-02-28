## 1️⃣ Definition

**Searching** is the process of finding the position (index) of a given element in an array.

If element exists → return index
If not → return -1 (or negative value in binarySearch)

Main types:

1. Linear Search
2. Binary Search

---

## 2️⃣ Visual Representation

### Given Array

```text
Index:   0   1   2   3   4
        ---------------------
Array → | 3 | 7 | 2 | 9 | 5 |
        ---------------------
```

Searching for 9.

---

### Linear Search

```text
3 ❌
7 ❌
2 ❌
9 ✅  → Found at index 3
```

---

### Binary Search (Sorted Array Required)

```text
Sorted → [2, 3, 5, 7, 9]

Step 1: Middle = 5
9 > 5 → Go Right

Step 2: Middle = 7
9 > 7 → Go Right

Step 3: 9 Found
```

---

## 3️⃣ Key Features / Properties

### Linear Search

✔ Works on sorted & unsorted arrays
✔ Simple
✔ Time Complexity → O(n)

---

### Binary Search

✔ Works only on sorted array
✔ Faster
✔ Time Complexity → O(log n)
✔ Divide and conquer approach

---

## 4️⃣ Syntax

### Linear Search (Manual)

```java
for(int i = 0; i < arr.length; i++) {
    if(arr[i] == key) {
        return i;
    }
}
return -1;
```

---

### Binary Search (Using Arrays Class)

```java
Arrays.binarySearch(arr, key);
```

Array must be sorted first:

```java
Arrays.sort(arr);
```

---

## 5️⃣ Code Example

### Linear Search

```java
public class Main {
    public static int linearSearch(int[] arr, int key) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key)
                return i;
        }
        return -1;
    }
}
```

---

### Binary Search

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1};
        Arrays.sort(arr);

        int index = Arrays.binarySearch(arr, 9);

        System.out.println(index);
    }
}
```

---

## 6️⃣ Use Cases

✔ Finding element in array
✔ Checking duplicates
✔ Membership testing
✔ Fast lookup (when sorted)
✔ Competitive programming

---

## 7️⃣ Pitfalls / Notes

⚠ Binary Search requires sorted array

Wrong:

```java
int[] arr = {5, 1, 9};
Arrays.binarySearch(arr, 9); // Unpredictable
```

---

⚠ binarySearch return value when NOT found

Formula:

```
-(insertionPoint) - 1
```

Example:

If element should be inserted at index 2
Return → -3

---

⚠ Linear search best for small arrays
Binary search best for large sorted arrays

---

⚠ Sorting takes O(n log n)
If searching only once → Linear may be better

---

## 8️⃣ Real-World Analogy

### Linear Search

Like checking each book on a messy table one by one.

---

### Binary Search

Like searching a word in a dictionary:

* Open middle
* Go left or right
* Repeat

Much faster.

---

## 9️⃣ Best Practices

✔ Use Linear Search for small/unsorted data
✔ Use Binary Search for large sorted data
✔ Always check return value of binarySearch
✔ Avoid sorting repeatedly if searching multiple times
✔ Use Collections.binarySearch for lists

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ What is time complexity of Linear Search?

✔ O(n)

---

### 2️⃣ What is time complexity of Binary Search?

✔ O(log n)

---

### 3️⃣ What is output?

```java
int[] arr = {1,3,5,7};
System.out.println(Arrays.binarySearch(arr, 4));
```

✔ Output: -3

Why?
Insertion point = 2
Return = -(2) - 1 = -3

---

### 4️⃣ What happens here?

```java
int[] arr = {9,5,2};
Arrays.binarySearch(arr, 5);
```

✔ Compiles
❌ Result unpredictable (not sorted)

---

### 5️⃣ Which is faster?

* Linear → O(n)
* Binary → O(log n)

Binary is faster for large arrays.

---

### 6️⃣ Can binary search work on unsorted array?

❌ No

---

### 7️⃣ Does Arrays.binarySearch modify array?

❌ No
Only returns index

---

### 8️⃣ If array has duplicates, what does binarySearch return?

✔ Any one valid index (not guaranteed first or last)

---

# 🧾 Quick Recap / Cheat Sheet

✔ Searching = finding element index
✔ Linear → O(n)
✔ Binary → O(log n)
✔ Binary requires sorted array
✔ binarySearch returns negative if not found
✔ Formula → -(insertionPoint) - 1
✔ Linear best for small data
✔ Binary best for large sorted data

---
