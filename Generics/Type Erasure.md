## 1️⃣ Definition

**Type Erasure** is the process by which the Java compiler removes all generic type information during compilation.

After compilation:

* Generic type parameters (`<T>`) are removed
* Replaced with their bounds (or `Object` if unbounded)
* Type casts are inserted where necessary

⚠ Generics exist only at **compile time**, not at runtime.

---

## 2️⃣ Visual Representation (Line Diagram)

---

### 🔹 Before Compilation

```text
class Box<T> {
    T value;
    T get() { return value; }
}
```

---

### 🔹 After Compilation (Type Erasure)

If unbounded:

```text
class Box {
    Object value;
    Object get() { return value; }
}
```

---

If bounded:

```text
class Box<T extends Number>
```

Becomes:

```text
class Box {
    Number value;
    Number get() { return value; }
}
```

---

### 🔹 What Happens During Compilation

```text
Step 1 → Remove <T>
Step 2 → Replace T with bound (or Object)
Step 3 → Insert casts where needed
```

---

## 3️⃣ Key Features / Properties

---

### 1️⃣ Generics Are Compile-Time Only

At runtime:

```text
Box<Integer>
Box<String>
```

Both become:

```text
Box
```

---

### 2️⃣ Replacement Rules

| Generic Type             | After Erasure |
| ------------------------ | ------------- |
| `<T>`                    | `Object`      |
| `<T extends Number>`     | `Number`      |
| `<T extends Comparable>` | `Comparable`  |

---

### 3️⃣ Compiler Inserts Casts

Example:

```java
Box<Integer> box = new Box<>();
Integer value = box.get();
```

After erasure:

```java
Integer value = (Integer) box.get();
```

Compiler adds cast automatically.

---

### 4️⃣ No Runtime Type Information

Because erased:

```java
box instanceof Box<String> ❌
```

Not allowed.

---

### 5️⃣ Bridge Methods

When overriding generic methods, compiler may generate synthetic bridge methods to maintain polymorphism.

(Advanced interview point.)

---

## 4️⃣ Syntax

There is no direct syntax for type erasure.
It happens automatically by compiler.

Example source:

```java
class Test<T> {
    T value;
}
```

After compilation → T removed.

---

## 5️⃣ Code Example

---

### Example 1 – Unbounded Generic

```java
class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}
```

After type erasure:

```text
class Box {
    Object value;

    void set(Object value) {
        this.value = value;
    }

    Object get() {
        return value;
    }
}
```

---

### Example 2 – Bounded Generic

```java
class Box<T extends Number> {
    T value;
}
```

After erasure:

```text
class Box {
    Number value;
}
```

---

### Example 3 – Generic Method

```java
public <T> T method(T value) {
    return value;
}
```

After erasure:

```text
public Object method(Object value)
```

---

## 6️⃣ Use Cases (Why Java Chose Type Erasure)

* Backward compatibility (Java 1.4 code works with generics)
* No JVM modification required
* Legacy libraries support

---

## 7️⃣ Pitfalls / Notes

---

### ❌ 1️⃣ Cannot Use `instanceof` With Parameterized Type

```java
if(obj instanceof List<String>) ❌
```

Because type info removed.

---

### ❌ 2️⃣ Cannot Create Generic Array

```java
T[] arr = new T[10]; ❌
```

Reason: Runtime type unknown.

---

### ❌ 3️⃣ Cannot Overload Methods That Erase to Same Signature

```java
void method(List<String> list)
void method(List<Integer> list) ❌
```

After erasure:

```java
void method(List list)
void method(List list)
```

Same signature → Compilation error.

🔥 Very important interview question.

---

### ❌ 4️⃣ Generic Exception Not Allowed

```java
class Test<T extends Exception> {
    void method() throws T ❌
}
```

Because JVM doesn’t know T at runtime.

---

### ❌ 5️⃣ Static Context Doesn't Know Generic Type

Because static exists at class level, and generic type erased.

---

## 8️⃣ Real-World Analogy

Think of Type Erasure like **Exam Hall Attendance Sheet** 📄

Before exam:

* You have name + department + subject

During exam:

* Only name is visible
* Department info removed

Generics work during compile time
But runtime only sees raw class.

---

## 9️⃣ Best Practices

✔ Understand erasure when designing APIs
✔ Avoid overloading methods with same erased signature
✔ Don’t rely on runtime generic type
✔ Use bounded types carefully
✔ Avoid generic arrays

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to Type Erasure.

---

### Q1: What is Type Erasure?

**Answer:**
Process where compiler removes generic type information and replaces it with bounds or Object.

---

### Q2: Why does Java use Type Erasure?

**Answer:**
To maintain backward compatibility with pre-Java 5 code and avoid JVM changes.

---

### Q3: What replaces `<T>` during erasure?

**Answer:**

* Object (if unbounded)
* Bound type (if bounded)

---

### Q4: Why can't we overload these?

```java
void method(List<String> list)
void method(List<Integer> list)
```

**Answer:**
After erasure both become:

```java
void method(List list)
```

Signature clash.

---

### Q5: Why can't we use `instanceof List<String>`?

**Answer:**
Because generic type info does not exist at runtime.

---

### Q6: What is a Bridge Method?

**Answer:**
A synthetic method generated by compiler to preserve polymorphism after type erasure.

---

### Q7: Does Type Erasure affect performance?

**Answer:**
No significant runtime overhead.
Generics are compile-time feature only.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Type Erasure = Remove generic info at compile time

Steps:
1. Remove <T>
2. Replace with Object or bound
3. Insert casts

Rules:
✔ Generics exist only at compile time
✔ No runtime type info
❌ Cannot overload erased signatures
❌ Cannot use instanceof with parameterized type
❌ Cannot create generic arrays

After Erasure:
<T> → Object
<T extends Number> → Number
```

---
