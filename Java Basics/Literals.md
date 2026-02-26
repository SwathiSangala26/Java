# 1️⃣ Definition

A **literal** is a fixed value assigned directly to a variable in the source code.

It represents a constant value written in the program.

Example:

```java
int a = 10;
```

Here:

* `10` → Literal
* `a` → Variable

---

# 2️⃣ Visual Representation

---

## 🔹 Variable vs Literal

```text
int a = 10;

a  ───► 10
        ↑
     Literal
```

✔ Literal is the actual constant value
✔ Variable stores that value

---

# 3️⃣ Types of Literals

Java supports the following literal types:

```text
Literals
│
├── Integer
├── Floating-point
├── Character
├── String
├── Boolean
└── Null
```

---

# 🟢 1. Integer Literals

Whole numbers.

```java
int a = 10;
```

### 🔹 Forms of Integer Literals

| Type        | Example |
| ----------- | ------- |
| Decimal     | 10      |
| Binary      | 0b1010  |
| Octal       | 012     |
| Hexadecimal | 0xA     |

Example:

```java
int a = 0b1010;  // 10
int b = 012;     // 10 (octal)
int c = 0xA;     // 10
```

---

### 🔹 Long Literal

By default, integer literal is `int`.

To make it `long`:

```java
long x = 100L;
```

⚠ Without `L`, large values cause compile error.

---

# 🔵 2. Floating-Point Literals

Numbers with decimal point.

```java
double d = 10.5;
```

### 🔹 Default Type

Floating literal → `double` by default.

To make it `float`:

```java
float f = 10.5f;
```

⚠ Must use `f` or `F`.

---

# 🟣 3. Character Literals

Single character enclosed in single quotes.

```java
char ch = 'A';
```

---

### 🔹 Unicode Character

```java
char ch = '\u0041';  // 'A'
```

Java uses **UTF-16** (2 bytes for char).

---

### 🔹 Escape Sequences (Important)

| Escape | Meaning      |
| ------ | ------------ |
| \n     | New line     |
| \t     | Tab          |
| "      | Double quote |
| '      | Single quote |
| \      | Backslash    |

Example:

```java
System.out.println("Hello\nWorld");
```

---

# 🟡 4. String Literals

Sequence of characters inside double quotes.

```java
String name = "Swathi";
```

✔ Stored in String Constant Pool
✔ Immutable

---

# 🔴 5. Boolean Literals

Only two values:

```java
true
false
```

Example:

```java
boolean flag = true;
```

---

# ⚫ 6. Null Literal

Represents absence of object reference.

```java
String s = null;
```

✔ Can only assign to reference types
❌ Cannot assign to primitive types

---

# 4️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        int a = 10;        // Integer literal
        long b = 100L;     // Long literal
        double c = 10.5;   // Double literal
        float d = 5.5f;    // Float literal
        char ch = 'A';     // Char literal
        String s = "Java"; // String literal
        boolean flag = true; // Boolean literal

        System.out.println(a);
    }
}
```

---

# 5️⃣ Use Cases

* Assigning constant values
* Initializing variables
* Writing test inputs
* Defining fixed configuration

---

# 6️⃣ Pitfalls / Notes (Very Important)

---

### ⚠ 1. Integer Default is int

```java
long x = 10000000000;  // Compile error
```

✔ Must write:

```java
long x = 10000000000L;
```

---

### ⚠ 2. Floating Default is double

```java
float f = 10.5;  // Compile error
```

✔ Must write:

```java
float f = 10.5f;
```

---

### ⚠ 3. Octal Confusion

```java
int x = 012;  // 10 (not 12)
```

Leading zero → octal.

---

### ⚠ 4. Char vs String

```java
char c = "A";   // Error
String s = 'A'; // Error
```

✔ char → single quotes
✔ String → double quotes

---

### ⚠ 5. Null with Primitive

```java
int x = null;  // Error
```

---

### ⚠ 6. Underscore in Literals (Java 7+)

```java
int x = 1_000_000;
```

✔ Improves readability.

---

# 7️⃣ Real-World Analogy

Literal = Exact number written on a paper.

Variable = Box that holds that number.

You write the literal directly in code — it never changes unless you modify code.

---

# 8️⃣ Best Practices

✔ Use L for long literals
✔ Use f for float literals
✔ Avoid leading zero unless octal needed
✔ Use underscores for readability
✔ Be careful with null

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. What is default type of integer literal?

int

---

### ❓ 2. What is default type of floating literal?

double

---

### ❓ 3. Is 012 equal to 12?

No. 012 is octal → equals 10.

---

### ❓ 4. Can we assign null to int?

No.

---

### ❓ 5. Why does float f = 10.5 give error?

Because 10.5 is double by default.

---

### ❓ 6. What is value of:

```java
char ch = 65;
```

Answer: 'A'

---

### ❓ 7. Can we use underscore at start of literal?

No.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Literals
--------

Integer → 10, 0b1010, 012, 0xA
Long → 100L
Float → 10.5f
Double → 10.5
Char → 'A', '\u0041'
String → "Java"
Boolean → true/false
Null → null

Important:
• Integer default = int
• Floating default = double
• 012 is octal
• null only for reference
• Use L and f when needed
```

---
