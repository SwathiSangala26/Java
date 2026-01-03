# 📘 Java String Creation – COMPLETE NOTES

## 1️⃣ String Literal (`"java"`)

![Image](https://www.baeldung.com/wp-content/uploads/2021/02/stringpool.png)

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20200820073435/JVMMemoryArea2.png)

![Image](https://miro.medium.com/0%2A6cD5Hjq2fqzScUVk.png)

### Definition

A **String literal** is a string value written directly in code using double quotes.

```java
String s1 = "java";
String s2 = "java";
```

---

### How JVM Handles String Literals

1. During **class loading**, JVM scans all string literals
2. Each literal is placed in the **String Constant Pool (SCP)**
3. If the same literal already exists → reference is reused

📌 SCP is part of **Heap memory** (Java 7+)

---

### Memory Behavior

```java
s1 == s2        // true (same reference)
s1.equals(s2)  // true
```

✔ Only **one object** created
✔ Multiple references point to it

---

### Why Java Uses String Literals

* Strings are used everywhere (logs, SQL, JSON, config)
* Pooling avoids duplicate objects
* Strings are immutable → safe to share
* Improves memory and performance

---

### Interview Line (Say This)

> “String literals are stored in the String Constant Pool and reused by the JVM to save memory.”

---

## 2️⃣ `new String("java")`

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20200820073435/JVMMemoryArea2.png)

![Image](https://i.sstatic.net/BRUZb.png)

![Image](https://www.scientecheasy.com/wp-content/uploads/2019/04/allocating-memory-string-objects.png)

### Definition

Creates a **new String object explicitly in heap memory**.

```java
String s1 = "java";
String s2 = new String("java");
```

---

### JVM Execution (VERY IMPORTANT)

1. `"java"` literal is loaded into SCP (class loading)
2. `new String("java")` creates a **new heap object**
3. Heap object copies characters from SCP

📌 Heap creation happens **every time**

---

### Memory Behavior

```java
s1 == s2        // false
s1.equals(s2)  // true
```

❌ Extra memory usage
❌ Avoid in normal code

---

### Why Java Allows `new String()`

* Explicit object identity
* Backward compatibility
* Framework / low-level JVM usage
* Defensive copying

---

### Interview Line

> “`new String()` always creates a new heap object even if the same value exists in the pool.”

---

## 3️⃣ `.intern()`

![Image](https://media.geeksforgeeks.org/wp-content/uploads/20230621110622/Interning-of-String-in-Java-3-768.png)

![Image](https://miro.medium.com/0%2A7c5FYHgYRSK7SgHu.png)

![Image](https://blog.jamesdbloom.com/images_2013_11_17_17_56/JVM_Internal_Architecture.png)

### Definition

Returns the **canonical pooled reference** of a String.

```java
String s1 = new String("java");
String s2 = s1.intern();
```

---

### How `intern()` Works

1. JVM checks SCP
2. If string exists → return pooled reference
3. If not → add string to SCP
4. Return SCP reference

📌 `intern()` does **not prevent heap creation**

---

### Memory Behavior

```java
s2 == "java"   // true
s1 == s2      // false
```

---

### Java Version Difference (INTERVIEW GOLD)

| Version | SCP Location |
| ------- | ------------ |
| Java 6  | PermGen      |
| Java 7+ | Heap         |

Java 7+ optimization:

* SCP may point to existing heap object
* But heap allocation already occurred

---

### Interview Line

> “`intern()` returns the String Constant Pool reference and ensures a single shared instance.”

---

## 🔥 IMPORTANT RULES (MEMORIZE)

### Rule 1

```java
new String() → ALWAYS creates heap object
```

### Rule 2

```java
intern() → controls reference, not creation
```

### Rule 3

```java
Only literals create strings directly in SCP
```

---

## 🧠 Object Creation Count

```java
String s = new String("java");
```

| Java Version | Objects |
| ------------ | ------- |
| Java 6       | 2       |
| Java 7+      | 1 or 2  |

---

## 🔍 `==` vs `.equals()`

| Operator    | Checks    |
| ----------- | --------- |
| `==`        | Reference |
| `.equals()` | Content   |

---

## 🧵 Thread Safety Connection

* Strings are immutable
* Safe to share across threads
* Pooling + immutability = thread-safe

---

## 📊 Comparison Table (Perfect for Interview)

| Feature          | Literal | new String | intern() |
| ---------------- | ------- | ---------- | -------- |
| Stored in SCP    | ✅       | ❌          | ✅        |
| Heap Object      | ❌       | ✅          | ❌        |
| Memory Efficient | ✅       | ❌          | ✅        |
| `==` Safe        | ✅       | ❌          | ✅        |
