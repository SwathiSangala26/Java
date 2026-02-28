## 1️⃣ Definition

**Bounded Types** restrict the type parameter to a specific type or its subclasses.

Instead of allowing any type:

```java
<T>
```

We restrict it:

```java
<T extends SomeClass>
```

This ensures:

* Type safety
* Access to specific methods of the bound type
* Compile-time validation

---

## 2️⃣ Visual Representation (Line Diagram)

### 🔹 Unbounded Generic

```text
<T>

T can be:
Integer
String
Object
Employee
Anything
```

---

### 🔹 Upper Bounded Generic

```text
<T extends Number>

            Number
           /   |    \
     Integer  Double  Float

T → can be Number or any subclass
```

---

### 🔹 Multiple Bounds

```text
<T extends ClassA & InterfaceB & InterfaceC>

T must:
✔ Extend ClassA
✔ Implement InterfaceB
✔ Implement InterfaceC
```

⚠ Only ONE class allowed.
⚠ Interfaces can be multiple.

---

## 3️⃣ Key Features / Properties

---

### 1. Upper Bound Using `extends`

```java
<T extends Number>
```

Means:

* T must be Number
* Or subclass of Number

---

### 2. Access Bound Methods

Because of bound:

```java
<T extends Number>
```

You can use:

```java
num.doubleValue()
```

Without casting.

---

### 3. Multiple Bounds

```java
<T extends ClassA & InterfaceB>
```

Rules:

* Class must come first
* Interfaces next

---

### 4. `super` Not Allowed in Type Parameter

❌ Invalid:

```java
<T super Number>
```

✔ Only allowed in wildcards.

---

### 5. Works in Both Class and Method Level

```java
class Test<T extends Number>
```

```java
public <T extends Number> void method(T value)
```

---

## 4️⃣ Syntax

---

### Basic Upper Bound

```java
class Test<T extends Number> {
}
```

---

### Bounded Generic Method

```java
public <T extends Number> double square(T num) {
    return num.doubleValue() * num.doubleValue();
}
```

---

### Multiple Bounds

```java
class Test<T extends Number & Comparable<T>> {
}
```

---

## 5️⃣ Code Example

---

### Example 1 – Bounded Generic Class

```java
class Calculator<T extends Number> {

    public double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }
}

public class Main {
    public static void main(String[] args) {

        Calculator<Integer> c1 = new Calculator<>();
        System.out.println(c1.square(10));

        Calculator<Double> c2 = new Calculator<>();
        System.out.println(c2.square(5.5));

        // Calculator<String> c3 = new Calculator<>(); ❌ Compile error
    }
}
```

---

### Example 2 – Multiple Bounds

```java
class Test<T extends Number & Comparable<T>> {

    public int compare(T a, T b) {
        return a.compareTo(b);
    }
}
```

Here:

* T must extend Number
* T must implement Comparable

---

## 6️⃣ Use Cases

* Mathematical utilities
* Sorting utilities
* Comparable constraints
* Framework-level generic restrictions
* Custom data structures

---

## 7️⃣ Pitfalls / Notes

---

### ❌ 1. Only One Class Allowed

```java
<T extends A & B> ❌ if both are classes
```

Correct:

```java
<T extends A & Interface1 & Interface2> ✅
```

---

### ❌ 2. Class Must Come First

```java
<T extends Interface1 & ClassA> ❌
```

Correct:

```java
<T extends ClassA & Interface1> ✅
```

---

### ❌ 3. Cannot Use `super` Here

```java
class Test<T super Number> ❌
```

---

### ❌ 4. Bound Restricts Usability

```java
class Test<T extends Number>
```

Now:

```java
Test<String> ❌
```

---

### ❌ 5. Type Erasure Still Applies

At runtime:

```text
<T extends Number>
```

becomes:

```text
Number
```

---

## 8️⃣ Real-World Analogy

Think of Bounded Types like **Job Eligibility Criteria** 🎯

```text
Job: Accountant
Requirement: Must have Commerce degree
```

Only people with Commerce degree can apply.

Similarly:

```java
<T extends Number>
```

Only numeric types allowed.

It prevents invalid candidates at compile time.

---

## 9️⃣ Best Practices

✔ Use bounded types when method depends on specific behavior
✔ Use multiple bounds carefully
✔ Keep class bound first
✔ Avoid over-restricting types
✔ Use meaningful generic names

Example:

```java
<T extends Comparable<T>>
```

Used in sorting utilities.

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to **Bounded Types**

---

### Q1: Why do we use `extends` keyword even for interfaces?

**Answer:**
Because in generics, `extends` means:

> "is-a" relationship

It works for:

* Class inheritance
* Interface implementation

---

### Q2: Can we use `super` in type parameter?

**Answer:**
No.

```java
<T super Number> ❌
```

`super` is only allowed in wildcards (`? super Type`).

---

### Q3: Why only one class allowed in multiple bounds?

**Answer:**
Java does not support multiple inheritance of classes.
So generic bound also follows same rule.

---

### Q4: What happens after type erasure for `<T extends Number>`?

**Answer:**
T is replaced with Number.

So:

```java
<T extends Number>
```

Becomes:

```java
Number
```

---

### Q5: What is the difference between unbounded and bounded generic?

| Unbounded                     | Bounded                  |
| ----------------------------- | ------------------------ |
| `<T>`                         | `<T extends Type>`       |
| Any type allowed              | Restricted types only    |
| No access to specific methods | Can access bound methods |

---

### Q6: Why is this valid?

```java
<T extends Number & Comparable<T>>
```

**Answer:**
Because:

* One class (Number)
* One interface (Comparable)
* Correct order

---

### Q7: What happens if order is wrong?

```java
<T extends Comparable<T> & Number> ❌
```

Compilation error.
Class must come first.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Bounded Type = Restrict generic type parameter

Syntax:
<T extends Type>

Supports:
✔ Upper bound
✔ Multiple bounds
✔ Works in class and method

Rules:
✔ Only one class allowed
✔ Class must come first
✔ Interfaces can be multiple
❌ No super keyword
❌ Type erased at runtime

Interview Focus:
• Why extends used for interface?
• Multiple bounds rules
• Type erasure behavior
• Difference from unbounded
```

---
