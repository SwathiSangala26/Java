## 1️⃣ Definition

**Memory Allocation** in Java refers to how memory is assigned to variables, objects, and class-level data during program execution inside the JVM.

Allocation happens mainly in:

```text id="ma1"
Stack
Heap
Method Area / Metaspace
```

---

## 2️⃣ Visual Representation

```text id="ma2"
                 JVM MEMORY
=================================================
|           Method Area / Metaspace            |
|     (Class metadata, static variables)       |
=================================================
|                    Heap                      |
|           (Objects, instance data)           |
=================================================

Thread-1:
   → Stack (Local variables, references)

Thread-2:
   → Stack (Local variables, references)
```

---

## 3️⃣ Key Features / Properties

---

## 🔹 1. Stack Allocation

* Memory allocated during method calls
* Stores:

  * Local variables
  * Primitive data
  * Object references
* Automatically deallocated when method ends
* Very fast allocation
* Thread-specific

Example:

```java id="ma3"
int x = 10;
```

Stored in Stack.

---

## 🔹 2. Heap Allocation

* Memory allocated for objects
* Created using `new`
* Shared among threads
* Managed by Garbage Collector
* Slower than stack allocation

Example:

```java id="ma4"
Demo d = new Demo();
```

Object → Heap
Reference `d` → Stack

---

## 🔹 3. Method Area Allocation

* Stores:

  * Class metadata
  * Static variables
  * Method bytecode
* Allocated when class is loaded
* Shared across threads

Example:

```java id="ma5"
static int count = 5;
```

Stored in Method Area.

---

## 4️⃣ Syntax

Object allocation:

```java id="ma6"
Employee emp = new Employee();
```

Primitive allocation:

```java id="ma7"
int salary = 5000;
```

Static allocation:

```java id="ma8"
static int companyId = 101;
```

---

## 5️⃣ Code Example

```java id="ma9"
class Test {
    static int a = 100;

    public static void main(String[] args) {
        int x = 10;
        Test t = new Test();
    }
}
```

Memory Allocation:

```text id="ma10"
Method Area:
   Class metadata
   static a = 100

Stack:
   x = 10
   t → reference

Heap:
   Test object
```

---

## 6️⃣ Use Cases

* Stack → Temporary method execution
* Heap → Dynamic object storage
* Method Area → Class-level storage
* Large applications → Heavy heap usage
* Multithreading → Multiple stacks

---

## 7️⃣ Pitfalls / Notes

* Objects always in Heap
* References stored in Stack
* Static variables in Method Area
* Deep recursion → StackOverflowError
* Too many objects → OutOfMemoryError
* Heap is shared → Needs synchronization
* Stack is faster than Heap

Important Interview Point:

```text id="ma11"
Primitive → Stored directly in Stack
Object → Stored in Heap
Reference → Stored in Stack
```

---

## 8️⃣ Real-World Analogy

Think of JVM like an office:

Heap → Storage warehouse
Stack → Employee desk (temporary work)
Method Area → Company rules & blueprint

---

## 9️⃣ Best Practices

* Avoid creating unnecessary objects
* Reuse objects when possible
* Remove unused references
* Avoid deep recursion
* Monitor heap usage in large systems
* Understand static vs instance memory usage

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Where is memory allocated for objects?

👉 Heap.

---

### 2️⃣ Where are object references stored?

👉 Stack.

---

### 3️⃣ Where are static variables stored?

👉 Method Area / Metaspace.

---

### 4️⃣ Which is faster: Stack or Heap allocation?

👉 Stack.

---

### 5️⃣ When is stack memory freed?

👉 When method execution completes.

---

### 6️⃣ When is heap memory freed?

👉 When Garbage Collector removes unused objects.

---

### 7️⃣ What happens if heap is full?

👉 OutOfMemoryError.

---

### 8️⃣ What happens if stack is full?

👉 StackOverflowError.

---

### 9️⃣ Is heap memory thread-safe?

👉 No. It is shared but requires synchronization.

---

### 🔟 Does GC manage stack memory?

👉 No. Only heap memory.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="ma12"
Stack → Local variables + references (Fast, Thread-specific)
Heap → Objects (Shared, GC-managed)
Method Area → Static variables + Class metadata (Shared)
```

Errors:

```text id="ma13"
StackOverflowError → Stack full
OutOfMemoryError   → Heap full
```

Key Rule:

```text id="ma14"
Primitive → Stack
Object → Heap
Reference → Stack
Static → Method Area
```

---
