## 1️⃣ Definition

A **Generic Class** in Java is a class that is parameterized with a type.
It allows you to define a class with a placeholder type (like `T`) that is specified when the object is created.

It provides:

* **Type safety at compile time**
* **Code reusability**
* **Elimination of type casting**
* **Prevention of ClassCastException at runtime**

---

## 2️⃣ Visual Representation (Line Diagram)

```
Generic Class Definition
------------------------

class Box<T> {
    T value;
}

         ↓

Object Creation
------------------------

Box<Integer> b1 = new Box<>();
Box<String>  b2 = new Box<>();

         ↓

Actual Type Replaces T at Compile Time
--------------------------------------

T → Integer
T → String
```

### Memory View

```
Box<Integer>
-----------------
value → 10

Box<String>
-----------------
value → "Hello"
```

⚠ Important: At runtime, due to **Type Erasure**, both are just `Box`.

---

## 3️⃣ Key Features / Properties

### 1. Type Parameter

* Represented using `<T>`
* Can use any valid identifier, but convention:

  * `T` → Type
  * `E` → Element
  * `K` → Key
  * `V` → Value
  * `N` → Number

---

### 2. Compile-Time Type Safety

```
Box<Integer> box = new Box<>();
box.set("Hello"); ❌ Compile-time error
```

---

### 3. No Primitive Types

```
Box<int> ❌
Box<Integer> ✅
```

Because generics work only with reference types.

---

### 4. Type Erasure

* Generic type information is removed at runtime.
* JVM does not know about `T`.

---

### 5. Multiple Type Parameters

```
class Pair<K, V> {
    K key;
    V value;
}
```

---

### 6. Bounded Type Parameters

```
class NumberBox<T extends Number> {
}
```

Means T must be:

* Number
* Or subclass of Number

---

## 4️⃣ Syntax

### Basic Generic Class

```java
class ClassName<T> {
    T variable;

    public void set(T variable) {
        this.variable = variable;
    }

    public T get() {
        return variable;
    }
}
```

---

### Multiple Type Parameters

```java
class Pair<K, V> {
    private K key;
    private V value;
}
```

---

### Bounded Generic Class

```java
class MyClass<T extends Number> {
}
```

---

## 5️⃣ Code Example

### Example 1 – Simple Generic Class

```java
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());

        Box<String> strBox = new Box<>();
        strBox.set("Java");
        System.out.println(strBox.get());
    }
}
```

---

### Example 2 – Bounded Generic

```java
class Calculator<T extends Number> {

    public double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }
}
```

---

## 6️⃣ Use Cases

* Collection classes (`ArrayList<T>`, `HashMap<K,V>`)
* Wrapper containers
* Data transfer objects
* Utility classes
* Repository patterns
* Custom reusable frameworks

---

## 7️⃣ Pitfalls / Notes

### ❌ 1. Cannot Create Generic Object Directly

```java
T obj = new T(); ❌
```

Because of type erasure.

---

### ❌ 2. Cannot Use Primitive Types

```java
Box<int> ❌
```

---

### ❌ 3. Cannot Create Array of Generic Type

```java
T[] arr = new T[10]; ❌
```

---

### ❌ 4. Static Members Cannot Use Type Parameter

```java
class Test<T> {
    static T value; ❌
}
```

Because static belongs to class, not instance.

---

### ❌ 5. instanceof with Generics Not Allowed

```java
if(obj instanceof Box<String>) ❌
```

Only raw type allowed:

```java
if(obj instanceof Box) ✅
```

---

## 8️⃣ Real-World Analogy

Think of a **Generic Class like a Template Box** 📦

```
Box<T>
```

It’s like a labeled empty container:

* At design time → It says “Box of something”
* At usage time → You decide:

  * Box<Integer>
  * Box<String>

Like ordering a customizable gift box:

* Same box design
* Contents change

---

## 9️⃣ Best Practices

✔ Always use Generics instead of raw types
✔ Follow naming conventions (T, E, K, V)
✔ Use bounded types when necessary
✔ Avoid unchecked warnings
✔ Prefer diamond operator `<>` (Java 7+)

```java
Box<String> box = new Box<>();
```

✔ Don’t mix raw types and generics

```java
Box box = new Box<Integer>(); ❌
```

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to **Generic Classes**.

---

### Q1: Why can't we use primitive types in generics?

**Answer:**
Because generics work only with reference types.
During type erasure, generics are replaced with Object.
Primitive types are not subclasses of Object.

---

### Q2: What is Type Erasure?

**Answer:**
Type erasure is the process where generic type information is removed at compile time.
After compilation:

```
Box<Integer>
Box<String>
```

Both become:

```
Box
```

---

### Q3: Why can't we create `new T()` inside generic class?

**Answer:**
Because type information is erased at runtime.
JVM doesn’t know what `T` is.

---

### Q4: Why can't static members use generic type?

**Answer:**
Because static belongs to class level.
Generic type is determined at object creation time.

---

### Q5: What happens if we use raw types?

```java
Box box = new Box();
box.set("Hello");
Integer i = (Integer) box.get();
```

**Answer:**
It compiles but may cause **ClassCastException at runtime**.
Type safety is lost.

---

### Q6: Can we overload generic classes?

Yes. Example:

```java
class MyClass<T> {}
class MyClass<T, U> {}
```

Valid.

---

### Q7: Can generic class extend another generic class?

Yes.

```java
class Parent<T> {}
class Child<T> extends Parent<T> {}
```

---

### Q8: What is the difference between `<T extends Number>` and `<T super Number>`?

❗ Trick question.

* `extends` is allowed in type parameter declaration.
* `super` is NOT allowed in class type parameter.

Correct:

```java
class Test<T extends Number> {}
```

Incorrect:

```java
class Test<T super Number> {} ❌
```

`super` is used only in wildcards.

---

# 🧾 Quick Recap / Cheat Sheet

```
Generic Class = Class with type parameter <T>

Advantages:
✔ Compile-time type safety
✔ No casting
✔ Reusable code

Syntax:
class Box<T> {}

Rules:
❌ No primitive types
❌ No new T()
❌ No static T
❌ No generic array creation
❌ No instanceof with parameterized type

Supports:
✔ Multiple type parameters
✔ Bounded types (extends)
✔ Inheritance with generics

Runtime:
→ Type Erasure
```

---
