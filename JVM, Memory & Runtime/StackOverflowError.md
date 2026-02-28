# 1️⃣ Definition

`StackOverflowError` occurs when the JVM stack memory for a thread is exhausted.

It typically happens due to:

* Infinite recursion
* Deep recursive calls
* Excessive nested method calls

It is a subclass of:

```text id="so1"
java.lang.Error
```

Important:

```text id="so2"
It is NOT an Exception.
```

---

# 2️⃣ Visual Representation

### 🔹 Normal Stack Growth

```text id="so3"
Top
-----------------
Method C
-----------------
Method B
-----------------
Method A
-----------------
Bottom
```

Each method call creates a **Stack Frame**.

---

### 🔹 Stack Overflow

```text id="so4"
Top
-----------------
Method X
-----------------
Method X
-----------------
Method X
-----------------
Method X
-----------------
Stack limit reached → StackOverflowError
```

---

# 3️⃣ Key Features / Properties

* Happens in **Stack memory**
* Each thread has its own stack
* Stack stores:

  * Local variables
  * Method calls
  * Return addresses
* Caused by excessive stack frames
* Usually due to recursion
* Memory size is limited per thread

Important:

```text id="so5"
More method calls → More stack frames → Stack fills → Error
```

---

# 4️⃣ Common Causes

---

## 🔹 1️⃣ Infinite Recursion

```java id="so6"
class Test {
    static void test() {
        test();  // infinite call
    }
}
```

---

## 🔹 2️⃣ Missing Base Condition

```java id="so7"
static void count(int n) {
    System.out.println(n);
    count(n + 1);  // no stopping condition
}
```

---

## 🔹 3️⃣ Deep Recursion

```java id="so8"
static void recursive(int n) {
    if(n == 0) return;
    recursive(n - 1);
}
```

If `n` is too large → StackOverflowError.

---

# 5️⃣ Code Example

```java id="so9"
public class Demo {
    public static void main(String[] args) {
        recursive();
    }

    static void recursive() {
        recursive();
    }
}
```

Output:

```text id="so10"
Exception in thread "main"
java.lang.StackOverflowError
```

---

# 6️⃣ Use Cases (Where It Happens)

* Recursive algorithms
* Large tree traversal
* Deep JSON/XML parsing
* Recursive sorting (if poorly written)
* Framework misconfiguration
* Circular method calls

---

# 7️⃣ Pitfalls / Notes

* StackOverflowError ≠ Heap problem
* GC does NOT fix Stack issues
* Increasing heap size won’t help
* Increasing stack size may help temporarily
* Iterative solution often better than deep recursion

Important Difference:

```text id="so11"
StackOverflowError → Stack full
OutOfMemoryError → Heap / Metaspace full
```

---

# 8️⃣ Real-World Analogy

Think of Stack like a **pile of plates**.

Each method call = one plate.

If you keep stacking without removing (returning) →
Pile becomes too tall → Falls (StackOverflowError).

---

# 9️⃣ Best Practices

* Always define base condition in recursion
* Prefer iterative solution when depth unknown
* Avoid unnecessary nested calls
* Be careful with recursive data structures
* Monitor thread stack size in large systems

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What causes StackOverflowError?

👉 Excessive stack frames due to deep or infinite method calls.

---

### 2️⃣ Is StackOverflowError an Exception?

👉 No. It is an Error.

---

### 3️⃣ Does GC fix StackOverflowError?

👉 No. GC works only on Heap.

---

### 4️⃣ Where does it occur?

👉 Stack memory (per thread).

---

### 5️⃣ Can increasing heap size fix it?

👉 No.

---

### 6️⃣ Can increasing stack size fix it?

👉 Possibly, but not recommended as permanent solution.

---

### 7️⃣ Does each thread have its own stack?

👉 Yes.

---

### 8️⃣ What is stored inside Stack Frame?

👉 Local variables, operand stack, return address.

---

### 9️⃣ Which is more common cause: recursion or loop?

👉 Recursion.

---

### 🔟 What is safer: recursion or iteration?

👉 Iteration (for deep calls).

---

# 🧾 Quick Recap / Cheat Sheet

```text id="so12"
StackOverflowError = Stack memory exhausted
```

Cause:

```text id="so13"
Infinite recursion
Deep nested method calls
```

Memory Type:

```text id="so14"
Stack → StackOverflowError
Heap → OutOfMemoryError
```

Important:

```text id="so15"
Each method call = One Stack Frame
```

---
