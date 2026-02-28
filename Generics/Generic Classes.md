## 1️⃣ Definition

A **Generic Class** is a class defined with one or more type parameters, allowing it to operate on different data types while providing compile-time type safety.

The type parameter acts as a placeholder and is replaced with an actual type during object creation.

---

## 2️⃣ Visual Representation

### 2.1 Without Generics

```text
Class Box
   |
   └── Object value
           |
           ├── String
           ├── Integer
           └── Double

Problems:
- Requires explicit casting
- Not type-safe
- Runtime ClassCastException possible
```

---

### 2.2 With Generics

```text
Class Box<T>
   |
   └── T value
           |
           ├── Box<String>
           |       └── "Hello"
           |
           ├── Box<Integer>
           |       └── 100
           |
           └── Box<Double>
                   └── 45.6

Advantages:
- No casting
- Compile-time safety
- Cleaner and reusable code
```

---

### 2.3 Type Binding Flow

```text
Step 1: Declaration
class Box<T>

Step 2: Object Creation
Box<String> box = new Box<>();

Step 3: Type Mapping
T → String

After Compilation (Type Erasure)
Box<String> → Box
```

---

## 3️⃣ Key Features / Properties

3.1 Provides compile-time type checking
3.2 Eliminates explicit casting
3.3 Improves code reusability
3.4 Prevents most ClassCastException cases
3.5 Uses Type Erasure internally
3.6 Supports multiple type parameters
3.7 Supports bounded type parameters
3.8 Works only with reference types

---

## 4️⃣ Syntax

### 4.1 Basic Generic Class

```java
class ClassName<T> {
    T variable;
}
```

---

### 4.2 Multiple Type Parameters

```java
class Pair<K, V> {
    K key;
    V value;
}
```

---

### 4.3 Bounded Type Parameter

```java
class Box<T extends Number> {
    T value;
}
```

---

### 4.4 Multiple Bounds

```java
class Sample<T extends Number & Comparable<T>> {
    T value;
}
```

Note:

* First must be a class
* Followed by interfaces

---

## 5️⃣ Code Example

### 5.1 Simple Generic Class

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
```

Usage:

```java
Box<String> box1 = new Box<>();
box1.set("Hello");
String data = box1.get();

Box<Integer> box2 = new Box<>();
box2.set(100);
Integer num = box2.get();
```

---

### 5.2 Multiple Type Parameters Example

```java
class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

Usage:

```java
Pair<String, Integer> p = new Pair<>("Age", 25);
```

---

### 5.3 Bounded Generic Example

```java
class NumberBox<T extends Number> {

    private T value;

    public NumberBox(T value) {
        this.value = value;
    }

    public double doubleValue() {
        return value.doubleValue();
    }
}
```

Valid:

```java
NumberBox<Integer> nb = new NumberBox<>(10);
```

Invalid:

```java
NumberBox<String> nb = new NumberBox<>("Hello"); // Compile-time error
```

---

## 6️⃣ Use Cases

6.1 Collection classes (List<String>, Map<K,V>)
6.2 Wrapper or container classes
6.3 Key-value data structures
6.4 Reusable utility classes
6.5 Type-safe APIs

---

## 7️⃣ Pitfalls / Notes

7.1 Type Erasure

During compilation, generic type information is removed.

```text
Box<String>
Box<Integer>

After compilation:
Box
```

Because of this:

* Cannot create `new T()`
* Cannot use `instanceof T`
* Cannot create `T[]`

---

7.2 Primitive Types Not Allowed

```
❌ Box<int>
✅ Box<Integer>
```

Generics work only with reference types.

---

7.3 Static Members Cannot Use Type Parameter

```java
class Test<T> {
    static T value; // Compile-time error
}
```

Reason:
Static belongs to class level, but T belongs to object level.

---

7.4 Cannot Overload Methods Differing Only by Generic Type

```java
void print(List<String> list)
void print(List<Integer> list)
```

After type erasure:

```
void print(List list)
```

Compile-time error.

---

7.5 Raw Types Remove Type Safety

```java
Box box = new Box();
```

Results:

* Compile warning
* Possible runtime ClassCastException

---

7.6 Generic Arrays Not Allowed

```java
T[] arr = new T[10]; // Compile-time error
```

---

## 8️⃣ Real-World Analogy

Think of a template mold.

Instead of creating:

* StringBox
* IntegerBox
* DoubleBox

You create one:

```
Box<T>
```

And decide the type when using it.

Reusable design with type safety.

---

## 9️⃣ Best Practices

9.1 Avoid raw types
9.2 Use bounded types when restriction is required
9.3 Prefer generics over Object
9.4 Follow naming conventions (`T`, `E`, `K`, `V`)
9.5 Keep generic classes focused and simple
9.6 Do not overuse multiple type parameters unnecessarily

---

## 🔟 Tricky Questions (With Answers)

10.1 What is Type Erasure?
Removal of generic type information during compilation and replacing it with Object or the bounded type.

---

10.2 Why can’t we create `new T()`?
Because at runtime T does not exist due to type erasure.

---

10.3 Why are primitive types not allowed in generics?
Generics work only with reference types. Primitive types do not extend Object.

---

10.4 What is the runtime type of `Box<String>`?
Just `Box`.

---

10.5 Why can’t static members use type parameter T?
Static members belong to class level, but type parameter belongs to object level.

---

10.6 Can a generic class extend another generic class?
Yes.

```java
class Child<T> extends Parent<T> { }
```

---

10.7 Why can’t we overload methods only by generic type?
After type erasure both methods have the same signature.

---

10.8 What happens if raw type is used?
Type safety is lost and runtime exceptions may occur.

---

10.9 Can we use multiple bounds in generics?
Yes. First must be a class, followed by interfaces.

---

10.10 Does generic information exist at runtime?
No. It is removed during compilation.

---

# 🧾 Quick Recap / Cheat Sheet

✔ Generic Class → `class Box<T>`
✔ Compile-time type safety
✔ No explicit casting
✔ Uses Type Erasure
✔ Works only with reference types
✔ Supports multiple type parameters
✔ Supports bounded types
✔ Cannot use `new T()`
✔ Cannot create `T[]`
✔ Static cannot use `T`
✔ Avoid raw types

---
