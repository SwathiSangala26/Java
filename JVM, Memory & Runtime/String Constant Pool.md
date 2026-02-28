## 1️⃣ Definition

The **String Constant Pool (SCP)** is a special memory area inside the Heap where JVM stores string literals to avoid duplicate object creation.

It ensures:

* Memory optimization
* Reusability of string literals

When you create a string using double quotes (`" "`), it goes into the String Constant Pool.

---

## 2️⃣ Visual Representation

```text id="scp1"
Heap Memory
---------------------------------
|   String Constant Pool        |
|   ------------------------    |
|   "Java"   ← shared object    |
|   "JVM"                      |
|   ------------------------    |
|   Other Objects               |
---------------------------------
```

Example:

```java
String s1 = "Java";
String s2 = "Java";
```

Memory:

```text id="scp2"
Stack:
   s1 → reference
   s2 → reference

Heap (SCP):
   "Java" (only ONE object)
```

---

## 3️⃣ Key Features / Properties

* Located inside Heap
* Stores string literals
* No duplicate literals allowed
* Improves memory efficiency
* Managed by JVM
* Strings in pool are immutable
* Uses `intern()` method to move strings into pool

---

### 🔹 Two Ways to Create Strings

#### 1️⃣ Using Literal

```java id="scp3"
String s = "Hello";
```

→ Stored in String Constant Pool.

---

#### 2️⃣ Using new Keyword

```java id="scp4"
String s = new String("Hello");
```

→ Creates:

* One object in Heap
* One literal in SCP (if not already present)

So this creates **two objects**.

---

## 4️⃣ Syntax

Literal:

```java id="scp5"
String s1 = "Java";
```

Using new:

```java id="scp6"
String s2 = new String("Java");
```

Using intern():

```java id="scp7"
String s3 = s2.intern();
```

---

## 5️⃣ Code Example

```java id="scp8"
String s1 = "Java";
String s2 = "Java";
String s3 = new String("Java");
String s4 = s3.intern();

System.out.println(s1 == s2);
System.out.println(s1 == s3);
System.out.println(s1 == s4);
```

Output:

```text id="scp9"
true
false
true
```

Explanation:

* s1 and s2 → same SCP object
* s3 → new object in Heap
* s4 → points to SCP object

---

## 6️⃣ Use Cases

* Memory optimization
* Reducing duplicate string objects
* Efficient comparison
* Used heavily in frameworks
* Common in configuration strings

---

## 7️⃣ Pitfalls / Notes

* `==` compares references
* `.equals()` compares values
* `new String()` always creates new object
* Strings are immutable
* Too many unique literals → increases memory
* `intern()` returns reference from SCP

Important Interview Rule:

```text id="scp10"
Literal → SCP
new String() → Heap
intern() → SCP reference
```

---

## 8️⃣ Real-World Analogy

Think of SCP like a **shared dictionary**:

If word "Java" already exists → reuse it.
No need to print a new copy every time.

`new String()` → printing a fresh personal copy.

---

## 9️⃣ Best Practices

* Prefer string literals over `new String()`
* Use `.equals()` for comparison
* Avoid unnecessary `intern()` usage
* Be careful in large string-heavy applications
* Use StringBuilder for heavy concatenation

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Where is String Constant Pool located?

👉 Inside Heap.

---

### 2️⃣ How many objects are created here?

```java
String s = new String("Java");
```

👉 Two objects (one in Heap, one in SCP if not present).

---

### 3️⃣ What does intern() do?

👉 Returns reference from String Constant Pool.

---

### 4️⃣ Why are strings immutable?

👉 For security, thread safety, and SCP optimization.

---

### 5️⃣ What is difference between == and equals()?

`==` → Reference comparison
`equals()` → Value comparison

---

### 6️⃣ Is SCP thread-safe?

👉 Yes (because strings are immutable).

---

### 7️⃣ Why avoid new String("Java")?

👉 Creates unnecessary extra object.

---

### 8️⃣ Does GC clean String Pool?

👉 Yes, if no references exist (Java 7+).

---

### 9️⃣ Where was SCP stored before Java 7?

👉 In PermGen (Method Area).

---

### 🔟 Where is SCP stored in Java 7+?

👉 Heap.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="scp11"
String Literal → Stored in SCP
new String() → Creates Heap object
intern() → Returns SCP reference
```

Comparison:

```text id="scp12"
==       → Reference
equals() → Value
```

Memory Rule:

```text id="scp13"
One literal → One SCP object
Multiple same literals → Same reference
```

---
