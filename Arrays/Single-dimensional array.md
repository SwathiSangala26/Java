## 1. Definition

• Array is a **fixed-size, indexed, linear data structure**
• Stores **multiple values of the same data type**
• Elements stored in **contiguous memory locations**
• Accessed using **zero-based index**

---

**java.util.Arrays**

Overview

• Arrays is a final utility class in java.util package
• Provides static helper methods to work with arrays
• Operates on primitive arrays and object arrays
• Cannot be instantiated

import java.util.Arrays;


## 2. Single-Dimensional Array

• Uses **one index**
• Represents a linear list
• Syntax:

```java
int[] arr;
```

---

## 3. Array as an Object

• Arrays are **objects in Java**
• Created using `new` keyword
• Stored in **heap memory**
• Reference stored in **stack**

```
STACK                     HEAP
-----                     ----
arr  ───────────────►  [ array object ]
```

---

## 4. Declaration

```java
int[] arr;
int arr[];
```

• Both valid
• `int[] arr` preferred for readability

---

## 5. Initialization

```java
arr = new int[5];
```

• JVM allocates memory
• Default values assigned
• Size cannot be changed later

---

## 6. Declaration + Initialization

```java
int[] arr = {10, 20, 30};
```

• Size inferred automatically
• Values stored sequentially

---

## 7. Default Values

• int → 0
• float → 0.0
• double → 0.0
• boolean → false
• char → '\u0000'
• Object → null

Reason:
• JVM avoids garbage values

---

## 8. Null in Arrays

• Only **reference-type arrays** can store `null`
• Primitive arrays cannot store `null`
• `null` represents **absence of object**

---

## 9. Array Length

• Length = number of elements
• Accessed using:

```java
arr.length
```

• `length` is a **property**, not method

---

## 10. Index Rules

• Index starts from **0**
• Last index = `length - 1`

```
Index:   0   1   2
Array:  [A] [B] [C]
```

---

## 11. Why Index Starts from 0

• Index = offset from base address
• Address formula:

```
address = base + (index × size)
```

• Zero offset = first element
• Faster memory access

---

## 12. Fixed Size Nature

• Size decided at creation
• JVM allocates **single contiguous block**
• Resizing requires:
– New array
– Copy elements
• Hence resizing not allowed

---

## 13. Accessing Elements

```java
arr[0];
arr[2];
```

• Time complexity: **O(1)**

---

## 14. Traversing — for Loop

```java
for(int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

• Index available
• Full control
• Can traverse forward/backward

---

## 15. Traversing — Enhanced for-Loop

```java
for(int value : arr) {
    System.out.println(value);
}
```

• Sequential traversal
• No index visibility
• Cleaner syntax
• Best for read-only access

---

## 16. Enhanced for-Loop Internals

• JVM internally uses index
• Iterates from `0` to `length - 1`
• Value variable gets **copy of element**

---

## 17. Why Enhanced for-Loop Cannot Modify Array

```java
for(int v : arr) {
    v = v * 2;   // does NOT change array
}
```

• `v` is a copy
• Actual array element unchanged

Correct approach:

```java
arr[i] = arr[i] * 2;
```

---

## 18. Runtime Exceptions

### ArrayIndexOutOfBoundsException

• Index < 0
• Index ≥ length

### NullPointerException

• Array reference is null

---

## 19. Empty Array vs Null Array

### Empty Array

```java
int[] arr = new int[0];
```

```
STACK → arr
HEAP  → array object
        length = 0
        memory allocated
```

• Object exists
• No elements

---

### Null Array

```java
int[] arr = null;
```

```
STACK → arr = null
HEAP  → no array object
```

• No object
• No memory

---

## 20. Passing Array to Method

• Reference passed by value
• Changes affect original array

```
method(arr)
└── both point to same heap object
```

---

## 21. Returning Array from Method

• Arrays can be returned like objects

---

## 22. Copying Arrays

• Manual loop
• `System.arraycopy()`
• `Arrays.copyOf()`

---

## 23. Time Complexity

• Access → O(1)
• Traversal → O(n)
• Search (linear) → O(n)

---

## 24. Space Complexity

• O(n)

---

## 25. JVM Internal Handling

• Array treated as object
• Length stored internally
• Default initialization
• Runtime bounds checking

```
Heap Array Object:
┌───────────────┐
│ length        │
│ element[0]    │
│ element[1]    │
│ element[n-1]  │
└───────────────┘
```

---

## 26. Performance Characteristics

• Faster than collections
• Direct memory access
• No resizing overhead
• Less memory usage

---

## 27. Array vs ArrayList (Summary)

• Array → fixed size, faster
• ArrayList → dynamic, slower
• Array supports primitives
• ArrayList stores objects only

---

## 28. When to Use Arrays

• Fixed size data
• Performance critical
• Low overhead requirement

---

## 29. When Not to Use Arrays

• Dynamic resizing needed
• Frequent insert/delete
