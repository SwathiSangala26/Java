## 1️⃣ Core Difference Table (MUST REMEMBER)

| Feature         | String             | StringBuilder | StringBuffer      |
| --------------- | ------------------ | ------------- | ----------------- |
| Mutability      | ❌ Immutable        | ✅ Mutable     | ✅ Mutable         |
| Thread-safe     | ✅ Yes              | ❌ No          | ✅ Yes             |
| Performance     | ❌ Slow for changes | ✅ Fastest     | ⚠️ Slower than SB |
| Synchronization | N/A                | ❌ No          | ✅ Yes             |
| Introduced in   | Java 1.0           | Java 1.5      | Java 1.0          |

---

## 2️⃣ What does **Immutable** mean? (Very common)

### ❓ Why is `String` immutable?

```java
String s = "java";
s.concat(" world");
System.out.println(s);
```

Output:

```
java
```

### Explanation:

* `"java"` is **never changed**
* `"java world"` is a **new object**
* `s` still points to old object

📌 Immutability = **cannot modify existing object**

---

## 3️⃣ Memory Behavior (Interview Gold)

### String

```java
String s1 = "java";
String s2 = s1 + " world";
```

* Creates **new String object**
* Old string still exists
* Causes **extra memory usage**

---

### StringBuilder

```java
StringBuilder sb = new StringBuilder("java");
sb.append(" world");
```

* Same object is modified
* No extra object created
* Very efficient

---

## 4️⃣ Why do we need StringBuilder?

### ❓ Why not use String always?

Because this is **very expensive**:

```java
for (int i = 0; i < 1000; i++) {
    s = s + i;
}
```

Each `+`:

* Creates new String
* Copies old content
* O(n²) behavior

### Correct way:

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i);
}
```

👉 **O(n)** time

---

## 5️⃣ StringBuilder vs StringBuffer (MOST ASKED)

### ❓ Difference between StringBuilder and StringBuffer?

| Aspect          | StringBuilder | StringBuffer |
| --------------- | ------------- | ------------ |
| Thread-safe     | ❌ No          | ✅ Yes        |
| Performance     | ✅ Faster      | ❌ Slower     |
| Synchronization | ❌ No          | ✅ Yes        |

---

### ❓ Why is StringBuffer slower?

Because:

```java
public synchronized StringBuffer append(...)
```

* Lock acquired every time
* Multi-thread safety costs performance

---

## 6️⃣ When to use which? (VERY IMPORTANT)

### ✅ Use **String**

* When data **does not change**
* Keys, constants, configuration
* Thread-safe by default

### ✅ Use **StringBuilder**

* When string changes frequently
* Single-threaded environment
* Loops, string concatenation

### ✅ Use **StringBuffer**

* When string changes
* Multi-threaded environment
* Legacy code
---

## 9️⃣ Interview One-Line Summary (MEMORIZE)

> “String is immutable and thread-safe, StringBuilder is mutable and fast but not thread-safe, and StringBuffer is mutable and thread-safe but slower.”
