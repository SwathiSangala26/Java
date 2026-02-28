## 1️⃣ Definition

**String Immutability** means:

> Once a String object is created, its value **cannot be changed**.

Any modification operation creates a **new String object**, instead of modifying the existing one.

---

## 2️⃣ Visual Representation

### Example 1

```java
String s = "Hello";
s = s.concat(" World");
```

### Memory View

Before concat:

```
String Constant Pool

 ┌───────────────┐
 │   "Hello"     │ ← s
 └───────────────┘
```

After concat:

```
String Constant Pool

 ┌───────────────┐
 │   "Hello"     │
 └───────────────┘

 ┌───────────────┐
 │ "Hello World" │ ← s (now pointing here)
 └───────────────┘
```

⚠️ Original `"Hello"` is NOT modified.
A new object `"Hello World"` is created.

---

### Example 2 (More Clear)

```java
String s1 = "Java";
String s2 = s1;
s1 = "Python";
```

Memory:

```
String Constant Pool

 ┌───────────────┐
 │   "Java"      │ ← s2
 └───────────────┘

 ┌───────────────┐
 │  "Python"     │ ← s1
 └───────────────┘
```

`s2` still points to `"Java"`
Original object unchanged.

---

## 3️⃣ Key Features / Properties

* Value cannot change after creation
* Class is declared as `final`
* Internal character array is `private final`
* Thread-safe by design
* Hashcode is cached
* Enables String Constant Pool

---

## 4️⃣ Syntax (How Immutability Works Internally)

Inside `String` class (conceptually):

```java
public final class String {

    private final char[] value;

}
```

Because:

* Class is `final` → cannot be inherited
* Character array is `final`
* No setter methods provided

So modification is impossible.

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s = "Code";
        s.concat(" Java");

        System.out.println(s);
    }
}
```

Output:

```
Code
```

Because `concat()` created new object but reference not reassigned.

---

Correct way:

```java
s = s.concat(" Java");
```

---

## 6️⃣ Use Cases (Why Java Made String Immutable)

### 🔹 1. Security

* URLs
* File paths
* Database credentials
* Network connections

If mutable → values could be changed after validation.

---

### 🔹 2. Thread Safety

Multiple threads can share same string safely.

```
Thread 1 → uses "Hello"
Thread 2 → uses "Hello"

No risk of modification.
```

---

### 🔹 3. String Constant Pool

If mutable, sharing same object would cause data corruption.

```
String s1 = "Java";
String s2 = "Java";
```

Both share same memory safely because immutable.

---

### 🔹 4. HashMap Efficiency

Hashcode is cached.

```java
Map<String, String> map = new HashMap<>();
```

If String was mutable → hashcode would change → lookup fails.

---

## 7️⃣ Pitfalls / Notes

⚠️ Every modification creates new object
⚠️ Heavy concatenation → memory waste
⚠️ Use `StringBuilder` for loops

Bad practice:

```java
for(int i=0; i<1000; i++) {
    s = s + i;
}
```

Better:

```java
StringBuilder sb = new StringBuilder();
```

---

## 8️⃣ Real-World Analogy

Think of String like:

📜 **Carved stone**

Once text is carved, you cannot edit it.
You must create a new stone.

Whereas:

📝 StringBuilder = whiteboard (editable)

---

## 9️⃣ Best Practices

✔ Use String for fixed text
✔ Use StringBuilder for modification
✔ Reassign result after operations
✔ Avoid unnecessary concatenation in loops
✔ Prefer literals over `new String()`

---

## 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ If String is immutable, how does `replace()` work?

**Answer:**
It creates a new String object and returns it.

---

### 2️⃣ What happens here?

```java
String s = "Java";
s.concat(" World");
System.out.println(s);
```

Output: `Java`
Because reference not updated.

---

### 3️⃣ Why String class is final?

To prevent subclass from breaking immutability.

---

### 4️⃣ Is String 100% immutable?

Yes.
Because:

* final class
* final char array
* no setters

---

### 5️⃣ Can we break immutability?

Using reflection (advanced), but normally NO.

Interview safe answer:
"No, String is immutable."

---

### 6️⃣ Why String is used as HashMap key?

Because immutable → hashcode remains constant.

---

### 7️⃣ How many objects created?

```java
String s = "A";
s = s + "B";
```

Answer: 2 objects
"A" and "AB"

---

### 8️⃣ Why is immutability good for multi-threading?

Because no synchronization needed.

---

# 🧾 Quick Recap / Cheat Sheet

* String is immutable
* Modification → new object
* Class is final
* Internal array is final
* Thread-safe
* Enables String Pool
* Hashcode cached
* Use StringBuilder for modifications
* Reassign result after operations

---
