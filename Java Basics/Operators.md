# 1️⃣ Definition

An **operator** is a symbol that performs an operation on one, two, or three operands and produces a result.

Java operators are classified as:

```text
Operators
│
├── Arithmetic
├── Unary
├── Relational
├── Logical
├── Bitwise
├── Shift
├── Assignment
└── Ternary
```

---

# 2️⃣ Visual Representation

---

## 🔹 Unary Operator (1 Operand)

```text
   ++a
   │
Operator
   │
Operand
```

---

## 🔹 Binary Operator (2 Operands)

```text
a + b

Operand  Operator  Operand
```

---

## 🔹 Ternary Operator (3 Operands)

```text
condition ? value1 : value2
```

---

# 3️⃣ Key Features / Properties

---

## 🟢 1. Arithmetic Operators

| Operator | Meaning        |
| -------- | -------------- |
| +        | Addition       |
| -        | Subtraction    |
| *        | Multiplication |
| /        | Division       |
| %        | Modulus        |

Example:

```java
int a = 10, b = 3;
System.out.println(a / b); // 3
System.out.println(a % b); // 1
```

⚠ Integer division removes decimal.

---

## 🔵 2. Unary Operators

| Operator | Meaning     |
| -------- | ----------- |
| +        | Unary plus  |
| -        | Unary minus |
| ++       | Increment   |
| --       | Decrement   |
| !        | Logical NOT |

### Pre vs Post Increment

```java
int a = 5;
System.out.println(++a); // 6
System.out.println(a++); // 6
System.out.println(a);   // 7
```

---

## 🟣 3. Relational Operators

| Operator | Meaning          |
| -------- | ---------------- |
| ==       | Equal            |
| !=       | Not Equal        |
| >        | Greater          |
| <        | Less             |
| >=       | Greater or Equal |
| <=       | Less or Equal    |

Returns boolean.

---

## 🟠 4. Logical Operators

| Operator | Meaning     |
| -------- | ----------- |
| &&       | Logical AND |
| ||       | Logical OR  |
| !        | NOT         |

Example:

```java
if (a > 0 && b > 0)
```

### Short-Circuit Important

```java
if (false && method())  // method() not executed
```

---

## 🟡 5. Bitwise Operators

Used on integer types.

| Operator | Meaning    |
| -------- | ---------- |
| &        | AND        |
| |        | OR         |
| ^        | XOR        |
| ~        | Complement |

Example:

```java
int a = 5;  // 0101
int b = 3;  // 0011
System.out.println(a & b); // 1
```

---

## 🔴 6. Shift Operators

| Operator | Meaning              |
| -------- | -------------------- |
| <<       | Left Shift           |
| >>       | Right Shift          |
| >>>      | Unsigned Right Shift |

Example:

```java
int a = 4;     // 0100
System.out.println(a << 1); // 8
```

---

## 🟤 7. Assignment Operators

| Operator | Meaning           |
| -------- | ----------------- |
| =        | Assign            |
| +=       | Add & assign      |
| -=       | Subtract & assign |
| *=       | Multiply & assign |
| /=       | Divide & assign   |
| %=       | Modulus & assign  |

Example:

```java
int a = 5;
a += 3;  // a = a + 3
```

---

## ⚫ 8. Ternary Operator

```java
int a = 10;
String result = (a > 5) ? "Yes" : "No";
```

Shortcut for if-else.

---

# 4️⃣ Operator Precedence (Important)

Highest → Lowest (simplified)

```text
Unary (++ -- !)
*
/ %
+ -
Relational
Logical AND (&&)
Logical OR (||)
Ternary
Assignment
```

---

# 5️⃣ Code Example

```java
int a = 10;
int b = 5;

System.out.println(a + b);  // 15
System.out.println(a > b);  // true
System.out.println(a > 5 && b < 10); // true
```

---

# 6️⃣ Use Cases

Arithmetic → Calculations
Relational → Comparisons
Logical → Decision making
Bitwise → Low-level programming
Shift → Performance optimizations
Ternary → Compact conditions

---

# 7️⃣ Pitfalls / Notes (VERY IMPORTANT)

---

### ⚠ 1. Integer Division

```java
System.out.println(5 / 2);   // 2
System.out.println(5 / 2.0); // 2.5
```

---

### ⚠ 2. == with Objects

```java
String s1 = new String("Hi");
String s2 = new String("Hi");

System.out.println(s1 == s2);       // false
System.out.println(s1.equals(s2));  // true
```

---

### ⚠ 3. Short-Circuit Behavior

```java
if (a != 0 && 10/a > 1)
```

Second condition runs only if first is true.

---

### ⚠ 4. Overflow

```java
int x = Integer.MAX_VALUE;
x++;
System.out.println(x); // overflow
```

---

### ⚠ 5. Assignment inside Condition

```java
if (a = 5)  // compile error (int)
```

---

# 8️⃣ Real-World Analogy

Arithmetic → Calculator
Relational → Comparing marks
Logical → Multiple rules to approve loan
Bitwise → Electrical switches
Ternary → Quick decision shortcut

---

# 9️⃣ Best Practices

✔ Use parentheses for clarity
✔ Avoid complex nested ternary
✔ Prefer && over & in conditions
✔ Be careful with integer division
✔ Use equals() for object comparison

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. What is difference between & and && ?

& → Evaluates both sides
&& → Short-circuit (may skip second)

---

### ❓ 2. Output?

```java
int a = 5;
System.out.println(a++ + ++a);
```

Step-by-step:

* a++ → 5 (a becomes 6)
* ++a → 7
  Result = 5 + 7 = 12

---

### ❓ 3. What is result of 10 / 3?

3 (integer division)

---

### ❓ 4. What is result of 10.0 / 3?

3.3333…

---

### ❓ 5. Can we overload operators in Java?

No (except + for String concatenation).

---

### ❓ 6. Difference between >> and >>> ?

> > → Preserves sign
> >
> > > → Fills with zero

---

### ❓ 7. Is ternary operator faster than if-else?

No significant performance difference.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Operators
---------

Arithmetic → + - * / %
Unary → ++ -- !
Relational → == != > <
Logical → && || !
Bitwise → & | ^ ~
Shift → << >> >>>
Assignment → = += -=
Ternary → condition ? a : b

Important:
• Integer division removes decimal
• && short-circuits
• Use equals() for objects
• Watch ++ tricky expressions
```

---
