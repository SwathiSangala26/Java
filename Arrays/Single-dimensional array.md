## Array – Core Definition

• Array is a collection of elements of the **same data type**
• Stored in **continuous memory locations**
• Accessed using **index**
• Size is **fixed** once created
• Index starts from **0**

---

## Single-Dimensional Array

• Linear structure with one index
• Elements arranged sequentially
• Example:

```java
int[] arr = {10, 20, 30};
```

---

## Array as an Object

• Arrays are **objects in Java**
• Stored in **heap memory**
• Reference variable stored in **stack**
• Primitive arrays store values
• Object arrays store references

---

## Array Declaration

```java
int[] arr;
int arr[];
```

• Both valid
• `int[] arr` is preferred (type clarity)

---

## Array Initialization

```java
arr = new int[5];
```

• Memory allocated in heap
• Default values assigned by JVM

---

## Declaration and Initialization Together

```java
int[] arr = {1, 2, 3};
```

• Size determined automatically
• Values assigned directly

---

## Default Values

• int → 0
• double → 0.0
• boolean → false
• char → '\u0000'
• Object → null

---

## Null in Arrays

• Only **object arrays** can store `null`
• Primitive arrays cannot store `null`
• `null` represents absence of object reference

---

## Array Length

• `length` gives number of elements
• Accessed as a **property**

```java
arr.length
```

• Not a method

---

## Index Rules

• Index range: `0` to `length - 1`
• Negative index → runtime exception
• Index ≥ length → runtime exception

---

## Why Index Starts from 0

• Index represents offset from base address
• Faster address calculation
• Direct memory mapping

---

## Fixed Size Nature

• Size decided at creation time
• JVM allocates contiguous memory
• Resizing requires new allocation and copy
• Size cannot be changed

---

## Access Time Complexity

• O(1) for accessing any element
• Direct index-based access

---

## Traversing Array – for Loop

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

• Index-based traversal
• Full control over positions
• Supports forward and reverse traversal

---

## Traversing Array – Enhanced for-Loop

```java
for (int value : arr) {
    System.out.println(value);
}
```

• Simplified sequential traversal
• No index handling
• Value-based access
• Best for read-only operations

---

## Enhanced for-Loop Limitations

• Index not accessible
• Cannot skip indices
• Cannot traverse in reverse easily
• Not suitable for index-based logic

---

## Modifying Array Elements

• Use normal `for` loop
• Enhanced for-loop works on copies of values

Correct way:

```java
for (int i = 0; i < arr.length; i++) {
    arr[i] *= 2;
}
```

---

## Runtime Exceptions

• `ArrayIndexOutOfBoundsException`
– Accessing invalid index
• `NullPointerException`
– Accessing array through null reference

---

## Passing Array to Methods

• Arrays are passed by **reference value**
• Changes inside method affect original array

---

## Returning Array from Methods

• Arrays can be returned like objects

---

## Copying Arrays

• Using loop
• `System.arraycopy()`
• `Arrays.copyOf()`

---

## Empty vs Null Array

• Empty array → size = 0, memory allocated
• Null array → no memory allocated

---

## JVM Internal Handling

• Arrays stored as objects in heap
• Length stored internally
• Default values assigned automatically
• Runtime bounds checking performed

---

## Performance Characteristics

• Fast access due to contiguous memory
• Low memory overhead
• No resizing cost

---

## Array vs ArrayList (Quick Notes)

• Array → fixed size, faster
• ArrayList → dynamic size, slower
• Array supports primitives
• ArrayList stores objects only

---

## When to Use Arrays

• Fixed size data
• Performance-critical code
• Simple sequential data

---

## When to Avoid Arrays

• Dynamic resizing needed
• Frequent insert/delete operations
