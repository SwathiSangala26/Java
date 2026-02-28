## 1️⃣ Definition

A **Lambda Expression** in Java is a concise way to represent an implementation of a **functional interface** (an interface with exactly one abstract method).

It provides a clear and compact syntax to implement behavior (method logic) without creating a separate class or anonymous inner class.

Introduced in **Java 8**.

---

## 2️⃣ Visual Representation

### 🔹 Traditional Anonymous Class

```
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
```

Structure:

```
Interface
   ↓
Anonymous Class
   ↓
Method Implementation
```

---

### 🔹 Lambda Version

```
Runnable r = () -> System.out.println("Hello");
```

Structure:

```
(parameters) -> { body }
```

Visual breakdown:

```
( )     ->     { statement }
 ↑             ↑
Parameters     Method Body
```

---

## 3️⃣ Key Features / Properties

1. Works only with **Functional Interfaces**
2. Eliminates boilerplate code
3. Enables functional-style programming
4. Can access effectively final local variables
5. Type inference supported
6. Can be:

   * No parameter
   * Single parameter
   * Multiple parameters
7. Body can be:

   * Single expression
   * Multiple statements
8. Cannot modify non-final local variables
9. `this` refers to enclosing class (not lambda)

---

## 4️⃣ Syntax

### General Form

```
(parameter_list) -> { method_body }
```

### Variations

#### No Parameter

```
() -> System.out.println("Hello")
```

#### One Parameter (type optional)

```
x -> x * x
```

#### Multiple Parameters

```
(int a, int b) -> a + b
```

#### Multiple Statements

```
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

---

## 5️⃣ Code Example

### Functional Interface

```java
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

### Lambda Implementation

```java
Calculator c = (a, b) -> a + b;
System.out.println(c.add(10, 20));
```

---

### Example with Comparator

```java
List<String> list = Arrays.asList("B", "A", "C");

Collections.sort(list, (a, b) -> a.compareTo(b));
```

---

## 6️⃣ Use Cases

1. Sorting collections
2. Thread creation
3. Event handling
4. Stream API
5. Filtering data
6. Map, Reduce operations
7. Replacing anonymous inner classes

---

## 7️⃣ Pitfalls / Notes

1. Works only with functional interfaces
2. Cannot use `break` or `continue` outside its scope
3. Cannot modify local variables (must be effectively final)
4. Overuse reduces readability
5. Checked exceptions must be handled
6. Type inference may cause ambiguity
7. Cannot define constructors
8. Cannot override multiple methods

---

## 8️⃣ Real-World Analogy

Imagine you need someone to perform a task:

### Traditional Way

Hire a full employee (class)

### Lambda Way

Hire a freelancer for one task (just method logic)

You only define:

* What needs to be done
* Not the whole structure

---

## 9️⃣ Best Practices

1. Keep lambdas short and readable
2. Avoid complex logic inside lambda
3. Use method references where possible
4. Prefer meaningful parameter names
5. Use functional interfaces from `java.util.function`
6. Avoid nested lambdas
7. Use `@FunctionalInterface` annotation

---

# 🔥 Tricky Questions (Interview Level)

---

### 1️⃣ What is a functional interface?

An interface with exactly one abstract method.
It may contain default and static methods.

---

### 2️⃣ Can a functional interface have multiple default methods?

Yes. Only one abstract method restriction applies.

---

### 3️⃣ What happens if an interface has two abstract methods?

It is not functional → Lambda cannot be used.

---

### 4️⃣ Is `@FunctionalInterface` mandatory?

No. But recommended. Compiler gives error if violated.

---

### 5️⃣ What is effectively final variable?

A variable whose value is not changed after initialization.

---

### 6️⃣ Why can lambda access only effectively final variables?

Because lambda captures value, not variable itself.
Prevents concurrency issues.

---

### 7️⃣ What does `this` refer to inside lambda?

Refers to enclosing class instance (not lambda).

---

### 8️⃣ Can lambda throw checked exception?

Yes, but functional interface method must declare it.

---

### 9️⃣ Difference between anonymous class and lambda?

| Feature     | Anonymous Class            | Lambda                |
| ----------- | -------------------------- | --------------------- |
| `this`      | Refers to anonymous object | Refers to outer class |
| Scope       | New scope                  | No new scope          |
| Boilerplate | More                       | Less                  |

---

### 🔟 Can we overload methods with functional interfaces?

Yes, but may cause ambiguity.

Example:

```java
void test(Runnable r)
void test(Callable c)
```

Calling:

```java
test(() -> "Hello"); // ambiguity
```

---

### 1️⃣1️⃣ Can lambda implement multiple methods?

No. Only one abstract method allowed.

---

### 1️⃣2️⃣ Can we use return keyword in single expression lambda?

No need. It is implicit.

Wrong:

```
x -> return x+1;
```

Correct:

```
x -> x+1
```

---

### 1️⃣3️⃣ What happens if lambda body has multiple statements?

Must use `{}` and explicit `return`.

---

### 1️⃣4️⃣ Are lambdas compiled to anonymous classes?

No. Internally uses `invokedynamic` (JVM optimization).

---

### 1️⃣5️⃣ Can lambda have instance variables?

No. It has no separate identity like class.

---

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8
* Used to implement Functional Interface
* Syntax: `(params) -> body`
* Only one abstract method allowed
* Can access effectively final variables
* `this` refers to enclosing class
* Reduces boilerplate
* Cannot modify local variables
* Best used with Streams & Collections
* Internally uses `invokedynamic`

---
