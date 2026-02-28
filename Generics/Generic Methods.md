## 1️⃣ Definition

A **Generic Method** is a method that declares its own type parameter(s) independently of the class.

It allows the method to:

* Accept arguments of different types
* Return different types
* Maintain compile-time type safety
* Avoid casting

⚠ Important:
A generic method can exist:

* Inside a non-generic class
* Inside a generic class
* As a static method

---

## 2️⃣ Visual Representation (Line Diagram)

```text
Generic Method Structure
-------------------------

< T > returnType methodName(T parameter) {
}

          ↓

Example Call
-------------------------

Integer result = method(10)
String  result = method("Java")

          ↓

Type Inference Happens at Compile Time
---------------------------------------
T → Integer
T → String
```

---

### Method vs Class Generic

```text
Generic Class
--------------
class Box<T> { }

Generic Method
--------------
<T> void print(T value) { }
```

👉 Type parameter before return type → That means method-level generic.

---

## 3️⃣ Key Features / Properties

---

### 1. Declared Before Return Type

```java
<T> T methodName(T param)
```

⚠ If `<T>` is missing → It is NOT a generic method.

---

### 2. Type Inference

Compiler automatically determines type:

```java
print(10);        // T → Integer
print("Hello");   // T → String
```

You can also explicitly specify:

```java
ClassName.<Integer>method(10);
```

---

### 3. Can Have Multiple Type Parameters

```java
<K, V> void display(K key, V value)
```

---

### 4. Can Be Static

```java
static <T> void print(T value)
```

✔ Unlike generic class type parameter, method generic works with static.

---

### 5. Can Have Bounded Type Parameters

```java
<T extends Number> double square(T num)
```

T must be Number or subclass.

---

## 4️⃣ Syntax

---

### Basic Generic Method

```java
public <T> void print(T value) {
    System.out.println(value);
}
```

---

### Generic Method With Return Type

```java
public <T> T getValue(T value) {
    return value;
}
```

---

### Multiple Type Parameters

```java
public <K, V> void display(K key, V value) {
    System.out.println(key + " " + value);
}
```

---

### Bounded Generic Method

```java
public <T extends Number> double square(T number) {
    return number.doubleValue() * number.doubleValue();
}
```

---

## 5️⃣ Code Example

---

### Example 1 – Simple Generic Method

```java
class Utility {

    public <T> void print(T value) {
        System.out.println(value);
    }
}

public class Main {
    public static void main(String[] args) {

        Utility u = new Utility();

        u.print(100);
        u.print("Java");
        u.print(3.14);
    }
}
```

---

### Example 2 – Return Type Generic

```java
class Utility {

    public <T> T echo(T value) {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {

        Utility u = new Utility();

        String str = u.echo("Hello");
        Integer num = u.echo(10);
    }
}
```

---

### Example 3 – Bounded Generic Method

```java
class Calculator {

    public <T extends Number> double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }
}
```

---

## 6️⃣ Use Cases

* Utility/helper methods
* Swap methods
* Generic algorithms
* Collection utilities
* Factory methods
* Static utility classes

---

## 7️⃣ Pitfalls / Notes

---

### ❌ 1. Forgetting `<T>` Before Return Type

```java
public T method(T value) ❌
```

Correct:

```java
public <T> T method(T value) ✅
```

---

### ❌ 2. Cannot Use Primitive Types

```java
method(10)  // works because autoboxing → Integer
```

Generics always use wrapper classes.

---

### ❌ 3. Type Erasure Applies Here Too

At runtime:

```text
<T>
```

is removed.

---

### ❌ 4. Method-Level T Is Independent

```java
class Test<T> {

    public <T> void method(T value) {
    }
}
```

⚠ The method T is DIFFERENT from class T.

This is tricky and interview favorite.

---

### ❌ 5. Cannot Use instanceof with Parameterized Type

Same restriction as generic classes.

---

## 8️⃣ Real-World Analogy

Think of a **Generic Method like a Universal Printer** 🖨

```text
<T> void print(T value)
```

It doesn’t care what you print:

* Document
* Image
* Excel file

It prints whatever you pass.

The machine doesn’t change — only the content changes.

---

## 9️⃣ Best Practices

✔ Keep generic methods short and reusable
✔ Use bounded types when behavior depends on specific class
✔ Prefer type inference instead of explicit type declaration
✔ Avoid shadowing class-level generic types
✔ Use meaningful type parameter names when needed

Example:

```java
public <K, V> Map<K, V> createMap()
```

Better readability.

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to **Generic Methods**

---

### Q1: What is the difference between Generic Class and Generic Method?

**Answer:**

| Generic Class                         | Generic Method                         |
| ------------------------------------- | -------------------------------------- |
| Type parameter defined at class level | Type parameter defined at method level |
| Applies to entire class               | Applies only to that method            |
| Cannot use in static context          | Can be static                          |

---

### Q2: Can a static method be generic?

**Answer:**
Yes.

```java
static <T> void method(T value)
```

Because type parameter belongs to method, not class.

---

### Q3: What happens if we remove `<T>`?

```java
public T method(T value)
```

**Answer:**
Compilation error.
Compiler cannot recognize T as type parameter.

---

### Q4: What is type inference in generic methods?

**Answer:**
Compiler automatically determines type based on arguments.

```java
method(10);   // T → Integer
```

---

### Q5: What if class and method both declare `<T>`?

```java
class Test<T> {
    public <T> void method(T value) {}
}
```

**Answer:**
Method-level T shadows class-level T.
They are completely independent.

---

### Q6: Can we overload generic methods?

Yes.

```java
<T> void method(T value)
<T> void method(T value1, T value2)
```

Valid.

---

### Q7: Can generic method throw generic exception?

❌ No.

```java
class Test<T extends Exception> {
    void method() throws T ❌
}
```

Not allowed due to type erasure.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Generic Method = Method with its own type parameter

Syntax:
<T> returnType methodName(T param)

Rules:
✔ Can be static
✔ Can have multiple type parameters
✔ Supports bounded types
✔ Supports type inference

Important:
❌ Must declare <T> before return type
❌ No primitive types
❌ Type erased at runtime
❌ Method T can shadow class T

Interview Focus:
• Difference between class & method generics
• Static generic method
• Shadowing
• Type inference
• Bounded generic method
```

---
