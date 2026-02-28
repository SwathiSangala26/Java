# 🔹 Runtime Data Areas

* Stack
* Heap
* Method Area / Metaspace
* PC Register
* Native Method Stack

No extra topics. No unnecessary theory. Only what matters.

---

# 1️⃣ Definition

**Runtime Data Areas** are memory regions created by the JVM at runtime to execute Java programs.

They are divided into:

```text
Shared Memory Areas:
   → Heap
   → Method Area / Metaspace

Thread-Specific Memory Areas:
   → Stack
   → PC Register
   → Native Method Stack
```

They store:

* Objects
* Class metadata
* Method execution data
* Thread execution state

---

# 2️⃣ Visual Representation

```text
                      JVM MEMORY
================================================
|            Method Area / Metaspace          |  (Shared)
================================================
|                    Heap                     |  (Shared)
================================================

Thread-1:
   → Stack
   → PC Register
   → Native Method Stack

Thread-2:
   → Stack
   → PC Register
   → Native Method Stack
```

---

# 3️⃣ Key Features / Properties

---

## 🔹 Stack

* Thread-specific
* Stores method calls (stack frames)
* Stores local variables
* Stores references (not objects)
* LIFO structure
* Automatically managed
* Small memory size

Stack Frame Structure:

```text
-------------------------
Local Variables
Operand Stack
Return Address
-------------------------
```

Error:

```text
StackOverflowError
```

---

## 🔹 Heap

* Shared among all threads
* Stores objects and instance variables
* Managed by Garbage Collector
* Large memory area
* Created when JVM starts

Error:

```text
OutOfMemoryError
```

---

## 🔹 Method Area / Metaspace

* Shared memory
* Stores class metadata
* Stores static variables
* Stores method bytecode
* Stores runtime constant pool
* Java 8+ → Metaspace (uses native memory)

Error:

```text
Metaspace OutOfMemoryError
```

---

## 🔹 PC Register

* Thread-specific
* Stores address of current instruction
* Used in multithreading
* Very small memory
* Undefined during native method execution

---

## 🔹 Native Method Stack

* Thread-specific
* Used for native (C/C++) method execution
* Works with `native` keyword
* Not managed by GC

---

# 4️⃣ Syntax

Heap Object Creation:

```java
Demo d = new Demo();
```

Static Variable (Method Area):

```java
static int x = 10;
```

Native Method:

```java
public native void display();
```

---

# 5️⃣ Code Example

```java
class Example {
    static int a = 100;

    public static void main(String[] args) {
        int x = 10;
        Example e = new Example();
    }
}
```

Memory Allocation:

```text
Method Area:
   Class metadata
   static a = 100

Stack:
   x = 10
   e → reference

Heap:
   Example object
```

---

# 6️⃣ Use Cases

Stack:

* Method execution
* Recursion handling

Heap:

* Object storage
* Shared data access

Method Area:

* Class loading
* Static data management

PC Register:

* Thread switching
* Instruction tracking

Native Method Stack:

* OS-level operations
* Database drivers
* JNI calls

---

# 7️⃣ Pitfalls / Notes

* Objects are always in Heap
* References stored in Stack
* Static variables in Method Area
* Each thread has separate Stack
* Heap is shared → needs synchronization
* GC works only on Heap
* Deep recursion → StackOverflowError
* Excess objects → OutOfMemoryError

---

# 8️⃣ Real-World Analogy

Think of JVM like a company:

Heap → Warehouse storing products
Stack → Employee desk (current tasks)
Method Area → Company blueprint & policies
PC Register → Task pointer
Native Stack → External contractor workspace

---

# 9️⃣ Best Practices

* Avoid deep recursion
* Avoid unnecessary object creation
* Remove unused object references
* Close resources properly
* Use memory profiling tools
* Understand static vs instance memory

---

# 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Where are objects stored?

👉 Heap.

---

### 2️⃣ Where are local variables stored?

👉 Stack.

---

### 3️⃣ Where are static variables stored?

👉 Method Area / Metaspace.

---

### 4️⃣ Is Heap thread-safe?

👉 No. It is shared but not inherently thread-safe.

---

### 5️⃣ Does Garbage Collector clean Stack?

👉 No. Only Heap.

---

### 6️⃣ What causes StackOverflowError?

👉 Infinite recursion or too many nested method calls.

---

### 7️⃣ What causes OutOfMemoryError?

👉 Heap full or Metaspace full.

---

### 8️⃣ Is Method Area part of Heap?

👉 Logically separate.

---

### 9️⃣ What is stored inside a Stack Frame?

👉 Local variables, operand stack, return address.

---

### 🔟 What changed in Java 8?

👉 PermGen removed → Replaced by Metaspace.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Heap        → Objects (Shared)
Stack       → Local variables + references (Per Thread)
Method Area → Class metadata + static variables (Shared)
PC Register → Current instruction pointer (Per Thread)
Native Stack → Native method execution (Per Thread)
```

Errors:

```text
StackOverflowError → Stack full
OutOfMemoryError   → Heap full
Metaspace OOME     → Too many classes
```

Shared vs Thread:

```text
Shared → Heap, Method Area
Thread → Stack, PC Register, Native Method Stack
```

---
