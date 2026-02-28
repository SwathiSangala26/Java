## 1️⃣ Definition

A **Functional Interface** is an interface that contains **exactly one abstract method**.

It may contain:

* Multiple **default methods**
* Multiple **static methods**
* Methods from `Object` class

Used primarily with **Lambda Expressions**.

---

## 2️⃣ Visual Representation

### Structure

```
Interface
   |
   |-- 1 Abstract Method  ✅ (Mandatory)
   |
   |-- Default Methods    ✅ (Optional)
   |
   |-- Static Methods     ✅ (Optional)
```

---

### Example Structure

```
@FunctionalInterface
interface A {
    void run();        ← Only ONE abstract method
    default void test() {}
    static void demo() {}
}
```

---

### Compilation Rule

```
If Abstract Methods Count > 1
        ↓
Compilation Error (if annotated)
```

---

## 3️⃣ Key Features / Properties

1. Must have **only one abstract method**
2. Can have multiple default methods
3. Can have multiple static methods
4. Can extend another interface (only if still 1 abstract method)
5. Can override `Object` methods (`toString`, `equals`, `hashCode`)
6. Marked optionally with `@FunctionalInterface`
7. Target type for Lambda Expressions
8. Supports method references
9. Introduced in Java 8

---

## 4️⃣ Syntax

### Basic Syntax

```java
@FunctionalInterface
interface InterfaceName {
    returnType methodName(parameters);
}
```

---

### Example

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

---

### Without Annotation (Still Functional)

```java
interface Test {
    void show();
}
```

Still valid if only one abstract method.

---

## 5️⃣ Code Example

### Using Lambda

```java
@FunctionalInterface
interface Message {
    void print(String msg);
}

Message m = (msg) -> System.out.println(msg);
m.print("Hello");
```

---

### Extending Interface

```java
interface A {
    void show();
}

@FunctionalInterface
interface B extends A {
}
```

Valid because total abstract methods = 1

---

### Invalid Case

```java
@FunctionalInterface
interface C {
    void show();
    void test();   // ❌ Two abstract methods
}
```

Compilation error.

---

## 6️⃣ Use Cases

1. Lambda Expressions
2. Stream API
3. Method References
4. Callback implementations
5. Strategy Pattern
6. Comparator logic
7. Thread creation
8. Event handling

---

## 7️⃣ Pitfalls / Notes

1. If more than one abstract method → Not functional
2. `@FunctionalInterface` is optional but recommended
3. Default methods do not affect abstract count
4. Static methods do not affect abstract count
5. Methods from `Object` class do not count
6. Private methods allowed (Java 9+)
7. Be careful when extending multiple interfaces

---

### Important Edge Case

```
interface A {
    void show();
}

interface B {
    void show();
}

@FunctionalInterface
interface C extends A, B {
}
```

Valid → Because both abstract methods have same signature → considered one.

---

## 8️⃣ Real-World Analogy

Think of it like a **remote control with only one main button**.

It may have:

* Extra helper features (default methods)
* Static utility options

But only **one main action** is allowed.

---

## 9️⃣ Best Practices

1. Always use `@FunctionalInterface`
2. Keep method purpose clear and single-focused
3. Prefer built-in functional interfaces from `java.util.function`
4. Avoid unnecessary custom interfaces
5. Use meaningful method names
6. Do not overload abstract methods

---

# 🔥 Tricky Questions (Interview Level)

---

### 1️⃣ What makes an interface functional?

Exactly one abstract method.

---

### 2️⃣ Does `@FunctionalInterface` make an interface functional?

No. It only enforces compile-time validation.

---

### 3️⃣ Can a functional interface have default methods?

Yes. Any number.

---

### 4️⃣ Can it have static methods?

Yes. Any number.

---

### 5️⃣ Do methods from Object class count?

No.

Example:

```java
interface A {
    void show();
    String toString();  // Does NOT count
}
```

Still functional.

---

### 6️⃣ Can it extend another interface?

Yes, if total abstract methods remain one.

---

### 7️⃣ What happens if two parent interfaces have same abstract method?

Still functional. Treated as single method.

---

### 8️⃣ What happens if two parent interfaces have different abstract methods?

Not functional → compilation error.

---

### 9️⃣ Can a functional interface be generic?

Yes.

```java
@FunctionalInterface
interface Converter<T, R> {
    R convert(T input);
}
```

---

### 🔟 Can functional interface have private methods?

Yes (Java 9+), but they don’t affect abstract count.

---

### 1️⃣1️⃣ Can we use lambda without functional interface?

No. Lambda requires a target functional interface.

---

### 1️⃣2️⃣ Is Runnable a functional interface?

Yes. It has one abstract method `run()`.

---

### 1️⃣3️⃣ Is Comparator a functional interface?

Yes. One abstract method `compare()`.

---

### 1️⃣4️⃣ Can functional interface have constructors?

No. Interfaces cannot have constructors.

---

### 1️⃣5️⃣ What happens if we remove abstract keyword?

All interface methods are implicitly abstract (unless default/static/private).

---

# 🧾 Quick Recap / Cheat Sheet

* Exactly one abstract method
* Default & static methods allowed
* Object class methods don’t count
* `@FunctionalInterface` optional but recommended
* Used as target for Lambda
* Can be generic
* Can extend interfaces (with restriction)
* Java 8 feature
* Supports method reference
* Core of functional programming in Java

---
