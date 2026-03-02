# 1️⃣ Definition

A **Wrapper Class** is a class that wraps (converts) a primitive data type into an object.

Each primitive type in Java has a corresponding wrapper class inside `java.lang` package.

---

# 2️⃣ Visual Representation

## 🔹 Primitive (Direct Value)

```
int a = 10;

Stack
-----
a  ───► 10
```

---

## 🔹 Wrapper (Object)

```
Integer x = 10;

Stack                    Heap
------                  ----------
x  ───────────────►     [ Integer Object ]
                         value = 10
```

✔ Wrapper stores value inside an object in heap.
✔ Variable holds reference (address).

---

# 3️⃣ Key Features / Properties

## 🔹 Primitive ↔ Wrapper Mapping

| Primitive | Wrapper Class |
| --------- | ------------- |
| byte      | Byte          |
| short     | Short         |
| int       | Integer       |
| long      | Long          |
| float     | Float         |
| double    | Double        |
| char      | Character     |
| boolean   | Boolean       |

---

### ✔ Important Properties

* Located in `java.lang` package
* Immutable
* Can be null
* Required for Collections
* Provides utility methods (parse, compare, valueOf, etc.)

---

# 4️⃣ Syntax

## 🔹 Before Java 5 (Manual Boxing)

```java
Integer x = new Integer(10);
```

⚠ Deprecated.

---

## 🔹 Using valueOf()

```java
Integer x = Integer.valueOf(10);
```

---

## 🔹 Autoboxing (Java 5+)

```java
Integer x = 10;   // Autoboxing
```

---

## 🔹 Unboxing

```java
int y = x;        // Unboxing
```

---

# 5️⃣ Code Example

```java
int a = 20;
Integer b = a;        // Autoboxing

int c = b;            // Unboxing

System.out.println(b); // 20
```

---

### 🔹 Using Utility Methods

```java
String str = "100";
int num = Integer.parseInt(str);

System.out.println(num + 10); // 110
```

---

# 6️⃣ Use Cases

✔ When working with Collections:

```java
ArrayList<Integer> list = new ArrayList<>();
```

✔ When null values are required
✔ When using utility methods
✔ In generics (Generics work only with objects)

---

# 7️⃣ Pitfalls / Notes (VERY IMPORTANT)

---

### ⚠ 1. Wrapper Classes Are Immutable

```java
Integer x = 10;
x = 20;
```

✔ A new object is created.

---

### ⚠ 2. Integer Caching (-128 to 127)

```java
Integer a = 100;
Integer b = 100;

System.out.println(a == b); // true
```

```java
Integer x = 200;
Integer y = 200;

System.out.println(x == y); // false
```

✔ Cache range = -128 to 127

---

### ⚠ 3. NullPointerException During Unboxing

```java
Integer x = null;
int y = x;   // Runtime error
```

✔ Unboxing null → NullPointerException

---

### ⚠ 4. == vs equals()

```java
Integer a = 200;
Integer b = 200;

System.out.println(a == b);       // false
System.out.println(a.equals(b));  // true
```

✔ `==` → compares references
✔ `equals()` → compares values

---

# 8️⃣ Real-World Analogy

Primitive = Raw number written on paper.

Wrapper = Number stored inside a box with extra features (methods).

You don’t just have the value — you also get tools to work with it.

---

# 9️⃣ Best Practices

✔ Use primitives for performance-critical code
✔ Use wrappers when working with collections
✔ Always use `.equals()` for value comparison
✔ Avoid unnecessary boxing/unboxing
✔ Prefer `valueOf()` over `new`

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Why can't we use int in ArrayList?

Because collections store objects, not primitives.

---

### ❓ 2. Is Integer mutable?

No. Wrapper classes are immutable.

---

### ❓ 3. What is Autoboxing?

Automatic conversion of primitive to wrapper object.

---

### ❓ 4. What is Unboxing?

Automatic conversion of wrapper object to primitive.

---

### ❓ 5. Why does Integer 100 == 100 return true?

Because of Integer cache (-128 to 127).

---

### ❓ 6. Can wrapper objects be null?

Yes.

---

### ❓ 7. What happens when unboxing null?

NullPointerException.

---

### ❓ 8. Difference between parseInt() and valueOf()?

| parseInt()            | valueOf()              |
| --------------------- | ---------------------- |
| Returns primitive int | Returns Integer object |

---

# 🧾 Quick Recap / Cheat Sheet

```
Wrapper Class
-------------
• Converts primitive → object
• Immutable
• Required for collections
• Supports utility methods
• Can be null
• Integer cache (-128 to 127)
• Autoboxing / Unboxing supported
```

---
