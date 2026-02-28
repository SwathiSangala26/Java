## 1️⃣ Definition

A **Method Reference** is a shorthand notation of a lambda expression that directly refers to an existing method.

Instead of writing a lambda that calls a method, we can reference the method using `::` operator.

It works only with **Functional Interfaces**.

---

## 2️⃣ Visual Representation

### Lambda Form

```java
x -> System.out.println(x)
```

Flow:

```
Parameter (x)
      ↓
Call existing method
      ↓
Return result
```

---

### Method Reference Form

```java
System.out::println
```

Flow:

```
ClassName::methodName
      ↓
JVM maps to functional interface method
```

---

### Syntax Pattern

```
ReferenceType :: methodName
```

---

## 3️⃣ Types of Method References

There are **4 types**.

---

### 1️⃣ Static Method Reference

```
ClassName::staticMethod
```

Example:

```java
Math::max
```

Visual:

```
Class
   ↓
Static Method
```

---

### 2️⃣ Instance Method of Particular Object

```
objectRef::instanceMethod
```

Example:

```java
System.out::println
```

Visual:

```
Object
   ↓
Instance Method
```

---

### 3️⃣ Instance Method of Arbitrary Object of a Particular Type

```
ClassName::instanceMethod
```

Example:

```java
String::toLowerCase
```

Visual:

```
Object passed later
       ↓
Instance method invoked
```

Equivalent Lambda:

```java
str -> str.toLowerCase()
```

---

### 4️⃣ Constructor Reference

```
ClassName::new
```

Example:

```java
ArrayList::new
```

Visual:

```
Functional Interface
       ↓
Calls constructor
       ↓
Creates new object
```

---

## 4️⃣ Syntax

General form:

```java
ReferenceType::methodName
```

Mapping rule:

```
Functional Interface method signature
          ↓
Must match
          ↓
Referenced method signature
```

---

## 5️⃣ Code Examples

---

### 🔹 Static Method

```java
@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

Calculator c = Math::max;
System.out.println(c.operate(10, 20));
```

---

### 🔹 Instance Method (Specific Object)

```java
PrintStream ps = System.out;
Consumer<String> c = ps::println;
c.accept("Hello");
```

---

### 🔹 Instance Method (Arbitrary Object)

```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(System.out::println);
```

---

### 🔹 Constructor Reference

```java
Supplier<List<String>> s = ArrayList::new;
List<String> list = s.get();
```

---

## 6️⃣ Use Cases

1. Simplifying lambda expressions
2. Stream API operations
3. Sorting
4. Mapping functions
5. Object creation
6. Cleaner event handling
7. Functional programming style

---

## 7️⃣ Pitfalls / Notes

1. Works only if signature matches functional interface
2. May cause ambiguity in overloaded methods
3. Cannot change argument order
4. Cannot add extra logic
5. Less readable if overused
6. Type inference must resolve correctly
7. Constructor reference must match parameters

---

## 8️⃣ Real-World Analogy

Lambda:

You tell someone:
“Take this value and print it.”

Method Reference:

You say:
“Just use that printer.”

Instead of explaining the action, you directly refer to the tool that already does it.

---

## 9️⃣ Best Practices

1. Use when lambda only calls one method
2. Prefer readability over cleverness
3. Avoid if logic is more than one statement
4. Ensure method signature clarity
5. Be careful with overloaded methods
6. Use constructor references for factories
7. Combine with Streams effectively

---

# 🔥 Tricky Questions (Interview Level)

---

### 1️⃣ What is the difference between lambda and method reference?

Lambda defines behavior explicitly.
Method reference reuses existing method.

---

### 2️⃣ When can we replace lambda with method reference?

When lambda only calls a single existing method.

---

### 3️⃣ What happens if method signature does not match?

Compilation error.

---

### 4️⃣ Can method reference refer to private method?

Only if accessible in that scope.

---

### 5️⃣ What does `String::toUpperCase` mean?

For each String object passed, call `toUpperCase()`.

Equivalent:

```java
str -> str.toUpperCase()
```

---

### 6️⃣ Can constructor reference call parameterized constructor?

Yes, if functional interface matches.

Example:

```java
Function<Integer, ArrayList> f = ArrayList::new;
```

---

### 7️⃣ What happens with overloaded methods?

Compiler may show ambiguity error.

---

### 8️⃣ Is `System.out::println` static or instance method reference?

Instance method of particular object.

---

### 9️⃣ Can method reference modify parameters?

No. It just forwards call.

---

### 🔟 How does JVM implement method reference?

Uses `invokedynamic` instruction similar to lambda.

---

### 1️⃣1️⃣ Can method reference be generic?

Yes, if functional interface is generic.

---

### 1️⃣2️⃣ What is difference between

```
String::length
```

and

```
str -> str.length()
```

No functional difference. Second is lambda; first is method reference.

---

### 1️⃣3️⃣ Can we chain method references?

No. It references only one method.

---

### 1️⃣4️⃣ Can method reference throw checked exception?

Yes, if functional interface method declares it.

---

### 1️⃣5️⃣ What happens internally when we use constructor reference?

JVM binds it to functional interface’s abstract method and creates object at runtime.

---

# 🧾 Quick Recap / Cheat Sheet

* Uses `::` operator
* Shorthand for lambda calling existing method
* Works only with functional interfaces
* 4 types:

  * Static method
  * Instance method (specific object)
  * Instance method (arbitrary object)
  * Constructor reference
* Must match method signature
* Reduces boilerplate
* Internally uses `invokedynamic`
* Cannot add extra logic
* May cause overload ambiguity

---
