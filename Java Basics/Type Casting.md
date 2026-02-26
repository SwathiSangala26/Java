# 1️⃣ Definition

**Type Casting** is the process of converting one data type into another data type.

In Java, type casting happens in two categories:

```
Type Casting
│
├── Primitive Casting
│     ├── Widening (Implicit)
│     └── Narrowing (Explicit)
│
└── Reference Casting
      ├── Upcasting
      └── Downcasting
```

---

# 2️⃣ Visual Representation

---

## 🔹 Primitive Widening (Small → Large)

```text
byte → short → int → long → float → double
```

Example:

```java
int a = 10;
double d = a;   // automatic
```

Memory View:

```
int a = 10
double d = 10.0
```

✔ No data loss
✔ Automatic

---

## 🔹 Primitive Narrowing (Large → Small)

```java
double d = 10.5;
int a = (int) d;
```

Memory View:

```
double d = 10.5
int a = 10
```

✔ Explicit casting required
✔ Data loss possible

---

## 🔹 Reference Casting

### Upcasting (Child → Parent)

```java
class Animal {}
class Dog extends Animal {}

Animal a = new Dog();  // Upcasting
```

✔ Automatic
✔ Safe

---

### Downcasting (Parent → Child)

```java
Animal a = new Dog();
Dog d = (Dog) a;   // Downcasting
```

✔ Explicit
✔ Risk of ClassCastException

---

# 3️⃣ Key Features / Properties

---

## 🟢 Primitive Casting

### Widening

* Automatic
* Safe
* No data loss

### Narrowing

* Manual (explicit)
* Risk of overflow / precision loss
* Required when converting larger type to smaller type

---

## 🔵 Reference Casting

### Upcasting

* Implicit
* Used for runtime polymorphism
* Parent reference → child object

### Downcasting

* Explicit
* Must ensure object is correct type
* Use `instanceof` for safety

---

# 4️⃣ Syntax

---

## Primitive

```java
// Widening
int a = 10;
double d = a;

// Narrowing
double x = 10.5;
int y = (int) x;
```

---

## Reference

```java
// Upcasting
Animal a = new Dog();

// Downcasting
Dog d = (Dog) a;
```

---

# 5️⃣ Code Example

---

## Primitive Example

```java
int a = 130;
byte b = (byte) a;

System.out.println(b);  // -126 (overflow)
```

Why?

```
byte range = -128 to 127
130 exceeds range → overflow
```

---

## Reference Example

```java
class Animal {}
class Dog extends Animal {}

Animal a = new Dog();

if (a instanceof Dog) {
    Dog d = (Dog) a;
}
```

✔ Safe downcasting.

---

# 6️⃣ Use Cases

### Primitive Casting

* Mathematical calculations
* API conversions
* Handling numeric data

### Reference Casting

* Polymorphism
* Framework design
* Generic object handling

---

# 7️⃣ Pitfalls / Notes (Very Important)

---

### ⚠ 1. Data Loss in Narrowing

```java
double d = 9.99;
int x = (int) d;   // 9
```

Decimal part lost.

---

### ⚠ 2. Overflow

```java
int a = 130;
byte b = (byte) a;
```

Result: -126

---

### ⚠ 3. Cannot Cast Between Unrelated Classes

```java
String s = "hello";
Integer i = (Integer) s;  // Compile-time error
```

---

### ⚠ 4. ClassCastException

```java
Animal a = new Animal();
Dog d = (Dog) a;   // Runtime error
```

---

### ⚠ 5. Boolean Cannot Be Casted

```java
boolean b = true;
int x = (int) b;   // Not allowed
```

---

# 8️⃣ Real-World Analogy

Widening → Pouring water from small glass into big bucket. Safe.

Narrowing → Pouring water from bucket into small glass. Some water spills.

Upcasting → Referring to a Dog as an Animal. General view.

Downcasting → Saying “That Animal is actually a Dog.” Needs confirmation.

---

# 9️⃣ Best Practices

✔ Avoid unnecessary casting
✔ Always check with `instanceof` before downcasting
✔ Be careful with numeric narrowing
✔ Use proper data type to avoid casting
✔ Prefer polymorphism instead of frequent casting

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Is widening primitive casting automatic?

Yes.

---

### ❓ 2. Is narrowing primitive casting automatic?

No. Explicit cast required.

---

### ❓ 3. Can we cast int to boolean?

No.

---

### ❓ 4. What happens if you downcast incorrectly?

Runtime ClassCastException.

---

### ❓ 5. Why does (byte)130 give -126?

Because byte range is -128 to 127 → overflow occurs.

---

### ❓ 6. Can parent object be cast to child?

Only if parent reference actually refers to child object.

---

### ❓ 7. Is upcasting required explicitly?

No. It happens automatically.

---

### ❓ 8. What is difference between compile-time and runtime casting error?

* Unrelated classes → Compile-time error
* Wrong object type → Runtime error

---

# 🧾 Quick Recap / Cheat Sheet

```
Type Casting
------------

Primitive
---------
Widening → Automatic, Safe
Narrowing → Explicit, Risk of data loss

Reference
---------
Upcasting → Implicit, Safe
Downcasting → Explicit, Risky

Important:
• Use instanceof before downcasting
• Watch overflow
• Boolean cannot be casted
```

---
