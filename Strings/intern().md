## 1️⃣ Definition

`intern()` is a method of the `String` class that:

> Returns the reference of the string from the **String Constant Pool (SCP)**.

If the string already exists in the pool → it returns that reference.
If not → it adds it to the pool and returns that reference.

---

## 2️⃣ Method Signature

```java
public native String intern();
```

* It is a **native method**
* Returns a `String` reference
* Works with String Constant Pool

---

## 3️⃣ Visual Representation

---

### 🔹 Case 1: Without intern()

```java
String s1 = new String("Java");
String s2 = "Java";
```

Memory:

```
Heap
 ├── String Constant Pool
 │      ┌───────────────┐
 │      │   "Java"      │ ← s2
 │      └───────────────┘
 │
 └── Normal Heap
        ┌───────────────┐
        │   "Java"      │ ← s1
        └───────────────┘
```

`s1 == s2` → false

---

### 🔹 Case 2: With intern()

```java
String s1 = new String("Java");
String s2 = s1.intern();
```

Memory:

```
Heap
 ├── String Constant Pool
 │      ┌───────────────┐
 │      │   "Java"      │ ← s2
 │      └───────────────┘
 │
 └── Normal Heap
        ┌───────────────┐
        │   "Java"      │ ← s1
        └───────────────┘
```

`s2` now points to pool reference.

---

## 4️⃣ How intern() Works

Step-by-step:

1. Checks if identical string exists in SCP
2. If exists → returns existing reference
3. If not → adds it to pool
4. Returns pool reference

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = "Java";
        String s3 = s1.intern();

        System.out.println(s1 == s2); // false
        System.out.println(s2 == s3); // true
    }
}
```

---

## 6️⃣ Important Scenario (Very Frequently Asked)

```java
String s1 = new String("Hello").intern();
String s2 = "Hello";

System.out.println(s1 == s2);
```

Answer: **true**

Because both point to same pool object.

---

## 7️⃣ When is intern() Useful?

* When you create many dynamic strings
* When memory optimization is required
* When you want to force string into pool
* Large-scale systems with repeated string values

Example:

```java
String value = databaseValue.intern();
```

---

## 8️⃣ Pitfalls / Notes

⚠ Not required in normal applications
⚠ Excessive use may increase pool size
⚠ Mostly used in low-level memory optimization
⚠ Works only because String is immutable

---

## 9️⃣ Real-World Analogy

Think of String Pool like:

📦 Warehouse with labeled boxes.

If you bring a new box:

* If label already exists → warehouse gives you existing box
* If not → adds new one

`intern()` = asking warehouse to check official stock.

---

## 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ How many objects are created?

```java
String s = new String("Java").intern();
```

Answer:

* If "Java" not in pool → 2 objects
* If already present → 1 new heap object + reference to existing pool object

---

### 2️⃣ What will be output?

```java
String s1 = new String("Hi");
String s2 = s1.intern();
String s3 = "Hi";

System.out.println(s2 == s3);
```

Answer: true

---

### 3️⃣ Does intern() modify the original object?

No.
It only returns pool reference.

---

### 4️⃣ Where is String Pool stored?

Heap (Java 7+)

---

### 5️⃣ Why does intern() work?

Because String is immutable → safe to share references.

---

### 6️⃣ Difference Between Literal and intern()

* Literal → automatically stored in pool
* intern() → manually force into pool

---

## 🧾 Quick Recap / Cheat Sheet

* `intern()` returns String Pool reference
* If exists → returns existing reference
* If not → adds to pool
* Helps memory optimization
* Works due to immutability
* Frequently asked with `==` comparison

---
