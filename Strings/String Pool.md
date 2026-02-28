## 1️⃣ Definition

**String Constant Pool (SCP)** is a special memory area inside the **Heap** where Java stores **string literals**.

Purpose:

* Avoid duplicate objects
* Improve memory efficiency
* Enable string sharing

Only **string literals** go into the pool automatically.

---

## 2️⃣ Visual Representation

---

### 🔹 Case 1: String Literals

```java
String s1 = "Java";
String s2 = "Java";
```

Memory:

```
Heap
 └── String Constant Pool

     ┌───────────────┐
     │    "Java"     │
     └───────────────┘
         ↑        ↑
        s1       s2
```

✔ Only ONE object created
✔ Both references point to same object

---

### 🔹 Case 2: Using new Keyword

```java
String s1 = new String("Java");
```

Memory:

```
Heap
 ├── String Constant Pool
 │      ┌───────────────┐
 │      │    "Java"     │
 │      └───────────────┘
 │
 └── Normal Heap
        ┌───────────────┐
        │    "Java"     │  ← s1
        └───────────────┘
```

✔ Two objects created
✔ One in SCP
✔ One in normal heap

---

### 🔹 Case 3: intern() Method

```java
String s1 = new String("Java");
String s2 = s1.intern();
```

Memory:

```
Heap
 └── String Constant Pool
      ┌───────────────┐
      │    "Java"     │  ← s2
      └───────────────┘

Normal Heap
      ┌───────────────┐
      │    "Java"     │  ← s1
      └───────────────┘
```

`intern()` → returns reference from pool.

---

## 3️⃣ Key Features / Properties

* Stored inside Heap
* Stores only string literals
* No duplicate objects allowed
* Improves memory usage
* Works because String is immutable
* Shared across application

---

## 4️⃣ Syntax

### Literal

```java
String s = "Hello";
```

### new Keyword

```java
String s = new String("Hello");
```

### intern()

```java
String s = new String("Hello").intern();
```

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // true
    }
}
```

---

## 6️⃣ Use Cases

* Memory optimization
* Common constant values
* Configuration keys
* Logging messages
* Large-scale applications with repeated strings

---

## 7️⃣ Pitfalls / Notes

⚠ `==` compares references
⚠ `equals()` compares content
⚠ `new String()` creates extra object
⚠ String pool works only because String is immutable
⚠ Too many dynamic strings may increase memory usage

---

## 8️⃣ Real-World Analogy

Think of String Pool like:

📚 **Library Book System**

If 100 students want same book:

* Library keeps ONE copy
* Everyone shares reference to that copy

But if someone buys personal copy (`new String()`),
that is separate object.

---

## 9️⃣ Best Practices

✔ Use string literals whenever possible
✔ Avoid unnecessary `new String()`
✔ Use `equals()` for comparison
✔ Use `intern()` only when required
✔ Prefer constants for repeated values

---

## 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ How many objects are created?

```java
String s = new String("Java");
```

Answer: 2
One in SCP, one in heap.

---

### 2️⃣ What will be output?

```java
String s1 = "Java";
String s2 = new String("Java");
System.out.println(s1 == s2);
```

Answer: false
Different references.

---

### 3️⃣ What about this?

```java
String s1 = "Java";
String s2 = "Ja" + "va";
System.out.println(s1 == s2);
```

Answer: true
Compiler optimization → stored in pool.

---

### 4️⃣ What about this?

```java
String s1 = "Java";
String s2 = "Ja";
String s3 = s2 + "va";
System.out.println(s1 == s3);
```

Answer: false
Runtime concatenation → new object in heap.

---

### 5️⃣ Where is String Pool stored?

In **Heap memory**.

(Java 7 onwards → moved from PermGen to Heap)

---

### 6️⃣ Why String Pool is possible?

Because String is immutable.

If mutable → shared reference would cause data corruption.

---

### 7️⃣ What does intern() do?

Returns reference from String Constant Pool.

---

### 8️⃣ Why is String Pool important?

* Reduces memory usage
* Improves performance
* Avoids duplicate objects

---

# 🧾 Quick Recap / Cheat Sheet

* SCP is inside Heap
* Stores string literals only
* No duplicate literals
* `new String()` → 2 objects
* `==` → reference compare
* `equals()` → content compare
* `intern()` → moves/returns pool reference
* Works because String is immutable

---
