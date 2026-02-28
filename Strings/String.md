## 1️⃣ Definition

A **String** in Java is an **immutable sequence of characters** represented by the `java.lang.String` class.

* Strings are **objects**, not primitive types.
* Stored in **Heap memory**.
* String literals are stored inside **String Constant Pool (SCP)**.
* Once created, **cannot be modified** (immutability).

---

## 2️⃣ Visual Representation

### 🔹 String Literal (Stored in SCP)

```
String s1 = "Hello";
String s2 = "Hello";
```

Memory:

```
String Constant Pool (Heap)

   ┌───────────────┐
   │   "Hello"     │  ← s1
   └───────────────┘
           ↑
           s2 (same reference)
```

Only **one object** created.

---

### 🔹 Using new Keyword

```
String s1 = new String("Hello");
```

Memory:

```
Heap Area

   String Constant Pool        Normal Heap
   ┌───────────────┐          ┌───────────────┐
   │   "Hello"     │          │   "Hello"     │ ← s1
   └───────────────┘          └───────────────┘
```

Two objects created.

---

## 3️⃣ Key Features / Properties

* ✅ Immutable
* ✅ Stored in Heap
* ✅ Implements `Serializable`, `Comparable`, `CharSequence`
* ✅ Overrides `equals()` and `hashCode()`
* ✅ Final class (cannot be inherited)
* ✅ Thread-safe (because immutable)
* ✅ String Pool concept

---

## 4️⃣ Syntax

### 🔹 String Literal

```java
String s = "Java";
```

### 🔹 Using new

```java
String s = new String("Java");
```

### 🔹 Important Methods

```java
length()
charAt(int index)
equals()
equalsIgnoreCase()
== 
compareTo()
substring()
concat()
toUpperCase()
toLowerCase()
trim()
contains()
replace()
split()
intern()
```

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println(s1 == s2);       // true
        System.out.println(s1 == s3);       // false
        System.out.println(s1.equals(s3));  // true
    }
}
```

---

## 6️⃣ Use Cases

* Storing text data
* User input handling
* Database values
* Logging messages
* Configuration values
* JSON/XML data handling
* API request/response handling

---

## 7️⃣ Pitfalls / Notes

⚠️ `==` compares **reference**, not content
⚠️ `equals()` compares **content**
⚠️ String is immutable → every modification creates new object
⚠️ Excessive concatenation in loop → performance issue
⚠️ `new String()` creates extra object
⚠️ String pool improves memory efficiency
⚠️ NullPointerException if calling method on null string

Example:

```java
String s = null;
System.out.println(s.length()); // NullPointerException
```

---

## 8️⃣ Real-World Analogy

Think of String like:

🧾 **Printed paper**

Once printed, you cannot change text on that paper.
If you want changes → you print a new paper.

Same way:

```
String s = "Hello";
s = s + " World";
```

Old object untouched → new object created.

---

## 9️⃣ Best Practices

✔ Always use String literal unless necessary
✔ Use `equals()` for comparison
✔ Use `StringBuilder` for heavy modifications
✔ Avoid `new String()` unnecessarily
✔ Check for null before calling methods
✔ Use `intern()` only when needed

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Why is String immutable?

**Answer:**

* Security (URL, DB credentials cannot change)
* Thread-safety
* Caching (String Pool)
* Hashcode caching (used in HashMap)

---

### 2️⃣ What is String Constant Pool?

Special memory area in heap where string literals are stored to avoid duplicate objects.

---

### 3️⃣ What will be output?

```java
String s1 = "Java";
String s2 = new String("Java");
System.out.println(s1 == s2);
```

**Answer:** false
Because references are different.

---

### 4️⃣ Difference between == and equals()?

* `==` → compares reference
* `equals()` → compares content

---

### 5️⃣ How many objects are created?

```java
String s = new String("Java");
```

**Answer:** 2
One in SCP, one in Heap.

---

### 6️⃣ What does intern() do?

Moves string reference to String Constant Pool.

```java
String s1 = new String("Java");
String s2 = s1.intern();
```

`s2` will refer to SCP object.

---

### 7️⃣ What happens internally when we do:

```java
String s = "a" + "b";
```

Compiler optimizes → `"ab"`
Only one object created.

---

### 8️⃣ What about this?

```java
String s1 = "a";
String s2 = s1 + "b";
```

At runtime → new object created in heap.

---

### 9️⃣ Why String is final?

To maintain immutability and security.

---

### 🔟 Why String is used as key in HashMap?

Because:

* Immutable
* hashCode() cached
* Reliable lookup

---

# 🧾 Quick Recap / Cheat Sheet

* String is a class in `java.lang`
* Immutable
* Stored in Heap
* Literals go to String Pool
* `==` → reference compare
* `equals()` → content compare
* `new String()` → 2 objects
* Immutable → thread-safe
* Use StringBuilder for modification
* String is final class

---
