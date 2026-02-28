## 1️⃣ Definition

### 🔹 StringBuffer

* Mutable sequence of characters
* Thread-safe
* Introduced in Java 1.0

### 🔹 StringBuilder

* Mutable sequence of characters
* Not thread-safe
* Introduced in Java 1.5

Both are in:

```
java.lang package
```

Both are used when **frequent string modifications** are required.

---

## 2️⃣ Visual Representation

---

### 🔹 String (Immutable)

```java
String s = "Java";
s = s + " World";
```

Memory:

```
Before:
 ┌───────────┐
 │  "Java"   │
 └───────────┘

After:
 ┌───────────┐
 │  "Java"   │
 └───────────┘

 ┌───────────────┐
 │ "Java World"  │
 └───────────────┘
```

New object created.

---

### 🔹 StringBuilder (Mutable)

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" World");
```

Memory:

```
Heap

 ┌──────────────────┐
 │  "Java World"    │  (same object modified)
 └──────────────────┘
```

Same object modified — no new object created.

---

## 3️⃣ Key Features / Properties

| Feature         | StringBuffer | StringBuilder |
| --------------- | ------------ | ------------- |
| Mutable         | Yes          | Yes           |
| Thread-safe     | Yes          | No            |
| Performance     | Slower       | Faster        |
| Introduced      | Java 1.0     | Java 1.5      |
| Synchronization | Yes          | No            |

---

## 4️⃣ Syntax

### 🔹 StringBuffer

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" 8");
```

### 🔹 StringBuilder

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" 8");
```

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("Hello");
        sb1.append(" World");
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer("Hello");
        sb2.append(" Java");
        System.out.println(sb2);
    }
}
```

Output:

```
Hello World
Hello Java
```

---

## 6️⃣ Use Cases

### 🔹 Use StringBuilder when:

* Single-threaded environment
* Performance critical applications
* Loops with heavy concatenation

### 🔹 Use StringBuffer when:

* Multi-threaded environment
* Shared mutable string required

---

## 7️⃣ Pitfalls / Notes

⚠ String is immutable → creates many objects
⚠ StringBuffer methods are synchronized
⚠ Synchronization causes performance overhead
⚠ StringBuilder is not safe in multithreading

Example (Bad practice):

```java
String s = "";
for(int i=0; i<1000; i++) {
    s = s + i;
}
```

Better:

```java
StringBuilder sb = new StringBuilder();
for(int i=0; i<1000; i++) {
    sb.append(i);
}
```

---

## 8️⃣ Real-World Analogy

Think of:

String → 🧾 Printed paper (cannot edit)

StringBuilder → 📝 Whiteboard (editable, single user)

StringBuffer → 📝 Whiteboard with security guard (multiple users, controlled access)

---

## 9️⃣ Best Practices

✔ Use String for fixed text
✔ Use StringBuilder for frequent modifications
✔ Avoid StringBuffer unless multithreading needed
✔ Use StringBuilder in loops
✔ Convert to String using `toString()` when needed

---

## 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Why is StringBuilder faster than StringBuffer?

Because StringBuilder methods are **not synchronized**, so no locking overhead.

---

### 2️⃣ Are StringBuilder and StringBuffer immutable?

No. They are mutable.

---

### 3️⃣ How do you convert StringBuilder to String?

```java
String s = sb.toString();
```

---

### 4️⃣ What happens internally when we use `+` operator in loops?

Compiler converts it to **StringBuilder** internally.

Example:

```java
String s = "A" + "B";
```

Internally:

```
new StringBuilder().append("A").append("B").toString();
```

---

### 5️⃣ Which one should you prefer?

In most cases → **StringBuilder**

---

### 6️⃣ Are they stored in String Pool?

No.
Only String literals go to String Constant Pool.

---

### 7️⃣ What is default capacity?

* Default capacity = 16
* If initialized with string → capacity = 16 + string length

---

## 🧾 Quick Recap / Cheat Sheet

* String → Immutable
* StringBuilder → Mutable, Fast, Not thread-safe
* StringBuffer → Mutable, Thread-safe, Slower
* StringBuilder preferred in most cases
* Use append() for modification
* Default capacity = 16
* Convert using toString()

---
