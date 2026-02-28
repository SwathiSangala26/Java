## 1️⃣ Definition

A **Single-Dimensional Array** is a linear data structure that stores multiple values of the **same data type** in a **contiguous memory location**, accessed using a single index.

* Fixed size
* Homogeneous elements
* Indexed starting from 0
* Stored in heap memory (for objects)

---

## 2️⃣ Visual Representation

### Memory Layout (int[] arr = {10,20,30,40})

```
Index:      0       1       2       3
          --------------------------------
Memory →  |  10  |  20  |  30  |  40  |
          --------------------------------
Address →   100     104     108     112
```

* Each element is accessed using:
  `arr[index]`
* Address calculation (conceptually):
  `base_address + (index * size_of_type)`

---

## 3️⃣ Key Features / Properties

✔ Fixed size (cannot grow or shrink)
✔ Stores elements of same data type
✔ Supports random access (O(1))
✔ Default values assigned automatically
✔ Stored in contiguous memory
✔ Array is an object in Java
✔ Length property → `arr.length`

### Default Values

| Data Type | Default Value |
| --------- | ------------- |
| int       | 0             |
| double    | 0.0           |
| boolean   | false         |
| char      | '\u0000'      |
| Object    | null          |

---

## 4️⃣ Syntax

### Declaration

```
dataType[] arrayName;
```

OR

```
dataType arrayName[];
```

### Instantiation

```
arrayName = new dataType[size];
```

### Declaration + Instantiation

```
int[] arr = new int[5];
```

### Initialization

```
int[] arr = {10,20,30};
```

---

## 5️⃣ Code Example

```java
public class Main {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        // Access
        System.out.println(arr[0]);  // 10

        // Update
        arr[2] = 99;

        // Traverse
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

---

## 6️⃣ Use Cases

✔ Storing fixed-size data (marks of students)
✔ Iterative processing
✔ Searching (Linear/Binary Search)
✔ Sorting (Bubble, Selection, etc.)
✔ Implementing stacks/queues manually

---

## 7️⃣ Pitfalls / Notes

⚠ ArrayIndexOutOfBoundsException
If index < 0 or ≥ length

⚠ Size is fixed
Cannot resize after creation

⚠ Stores only same type
Cannot mix int and String

⚠ Memory wastage
If declared size > used elements

⚠ NullPointerException
If array reference is not initialized

```
int[] arr;
System.out.println(arr[0]); // Compilation error (not initialized)
```

---

## 8️⃣ Real-World Analogy

Think of it like:

🎬 A row of theatre seats.

```
Seat Number →   0    1    2    3
               -------------------
People      → | A  | B  | C  | D |
               -------------------
```

* Fixed number of seats
* Each seat has position number
* You access by seat number

---

## 9️⃣ Best Practices

✔ Always use `arr.length` in loops
✔ Prefer enhanced for-loop when modification is not needed
✔ Validate index before accessing
✔ Use meaningful variable names
✔ Avoid magic numbers in size

Example:

```java
for(int value : arr) {
    System.out.println(value);
}
```

---

## 🔟 Tricky Questions (With Answers)

### 1️⃣ Is array a primitive type in Java?

❌ No.
Array is an object. Even `int[]` is an object stored in heap.

---

### 2️⃣ Where is array stored?

* Array object → Heap
* Reference variable → Stack (if local)

---

### 3️⃣ What is the output?

```java
int[] arr = new int[3];
System.out.println(arr[1]);
```

✔ Output: 0
(Because default value of int is 0)

---

### 4️⃣ What happens here?

```java
int[] arr = new int[-5];
```

✔ Runtime Exception: NegativeArraySizeException

---

### 5️⃣ Is this valid?

```java
int arr[] = new int[5];
```

✔ Yes. But not recommended style.

---

### 6️⃣ What is length of array?

```java
int[] arr = new int[5];
System.out.println(arr.length);
```

✔ Output: 5
Length is fixed and final.

---

### 7️⃣ Can we change size of array?

❌ No.
You must create a new array.

---

### 8️⃣ Difference between:

```
int[] arr = new int[3];
```

vs

```
int[] arr = {1,2,3};
```

First → default values
Second → initialized values

---

### 9️⃣ What is time complexity of accessing arr[5]?

✔ O(1) (Constant time)

---

### 🔟 Will this compile?

```java
int[] arr = {1,2,3};
System.out.println(arr[3]);
```

✔ Compiles
❌ Runtime → ArrayIndexOutOfBoundsException

---

# 🧾 Quick Recap / Cheat Sheet

✔ Linear structure
✔ Same data type
✔ Fixed size
✔ Index starts at 0
✔ Stored in contiguous memory
✔ Access time → O(1)
✔ Length → arr.length
✔ Default values assigned
✔ Heap memory allocation
✔ Cannot resize

---
