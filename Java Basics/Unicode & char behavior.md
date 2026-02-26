# 1️⃣ Definition

### 🔹 Unicode

**Unicode** is a universal character encoding standard that assigns a unique number (code point) to every character across languages.

### 🔹 `char` in Java

* `char` is a **16-bit unsigned data type**
* It stores a **Unicode value**
* Size = **2 bytes**
* Range = **0 to 65,535 (0 to 2¹⁶ − 1)**

---

# 2️⃣ Visual Representation

---

## 🔹 Unicode Storage in Java

```text
char ch = 'A';

Memory (16 bits)
----------------
0000 0000 0100 0001
        ↑
      65 (Unicode of 'A')
```

---

## 🔹 Relationship Between char & int

```java
char ch = 'A';
int x = ch;
System.out.println(x);  // 65
```

Visual:

```text
'A'  → Unicode 65 → Stored as number internally
```

✔ `char` is internally numeric.

---

# 3️⃣ Key Properties of char

| Property        | Value      |
| --------------- | ---------- |
| Size            | 2 bytes    |
| Type            | Primitive  |
| Encoding        | UTF-16     |
| Range           | 0 to 65535 |
| Signed/Unsigned | Unsigned   |

---

# 4️⃣ Unicode Basics

Every character has a Unicode value.

Examples:

| Character | Unicode (Decimal) | Unicode (Hex) |
| --------- | ----------------- | ------------- |
| A         | 65                | \u0041        |
| a         | 97                | \u0061        |
| 0         | 48                | \u0030        |
| ₹         | 8377              | \u20B9        |

---

## 🔹 Unicode Syntax in Java

```java
char ch = '\u0041';
System.out.println(ch);  // A
```

✔ `\u` followed by 4 hexadecimal digits.

---

# 5️⃣ char as Integer Type (Very Important)

---

## 🔹 char → int (Implicit Widening)

```java
char ch = 'A';
int x = ch;
System.out.println(x);  // 65
```

✔ Automatic conversion.

---

## 🔹 int → char (Explicit Narrowing)

```java
int x = 66;
char ch = (char) x;
System.out.println(ch);  // B
```

✔ Explicit cast required.

---

# 6️⃣ Arithmetic with char

Because char is numeric internally:

```java
char ch = 'A';
ch++;

System.out.println(ch);  // B
```

Explanation:

```text
'A' → 65
65 + 1 = 66
66 → 'B'
```

---

### Example

```java
System.out.println('A' + 1);  
```

Output:

```
66
```

Why?

Because:

* 'A' → 65
* 65 + 1 = 66 (int result)

---

# 7️⃣ Special Behaviors (Important)

---

### ⚠ 1. char + char = int

```java
System.out.println('A' + 'B');
```

Output:

```
131
```

Because:

* 65 + 66 = 131

---

### ⚠ 2. char Cannot Store Negative Value

```java
char ch = -1;  // Compile error
```

✔ Range is 0 to 65535.

---

### ⚠ 3. char vs String

```java
char c = 'A';      // single character
String s = "A";    // object
```

✔ char → primitive
✔ String → reference type

---

### ⚠ 4. Surrogate Pairs (Advanced but Important)

Unicode characters beyond 65535 (like emojis 😄)
Require **two char values** (UTF-16 surrogate pair).

Example:

```java
System.out.println("😊".length());
```

Output:

```
2
```

✔ Because emoji uses 2 char units.

---

# 8️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        char ch = 'A';
        System.out.println((int) ch);   // 65

        char next = (char)(ch + 1);
        System.out.println(next);       // B

        char unicode = '\u20B9';
        System.out.println(unicode);    // ₹
    }
}
```

---

# 9️⃣ Use Cases

✔ Storing single character
✔ Character manipulation
✔ ASCII arithmetic
✔ Parsing characters
✔ Working with Unicode symbols

---

# 🔟 Pitfalls / Notes (Interview Critical)

---

### ⚠ Default char value

Instance variable:

```java
char ch;
```

Default value:

```
'\u0000'
```

(Not space, not null)

---

### ⚠ char is unsigned

Unlike byte/short/int, char cannot store negative values.

---

### ⚠ Length of String ≠ Number of Characters Always

Because:

* Some characters require 2 UTF-16 units.

---

### ⚠ Comparing char

```java
if (ch == 'A')
```

✔ Works because comparison is numeric.

---

# 1️⃣1️⃣ Real-World Analogy

Think of char as a **numeric code label** for characters.

When you see 'A', Java sees number 65.

Characters are just numbers with symbols attached.

---

# 1️⃣2️⃣ Best Practices

✔ Use char for single characters only
✔ Use String for text
✔ Be careful with Unicode beyond 65535
✔ Cast explicitly when converting int → char
✔ Remember char arithmetic returns int

---

# 1️⃣3️⃣ Tricky Questions (With Answers)

---

### ❓ 1. What is size of char in Java?

2 bytes (16 bits).

---

### ❓ 2. Is char signed or unsigned?

Unsigned.

---

### ❓ 3. What is output?

```java
System.out.println('A' + 1);
```

66

---

### ❓ 4. What is output?

```java
char ch = 65;
System.out.println(ch);
```

A

---

### ❓ 5. Can char store emoji?

Partially.
Some emojis require two char values (surrogate pair).

---

### ❓ 6. What is default value of char?

'\u0000'

---

### ❓ 7. Why does 'A' + 'B' return int?

Because arithmetic promotion converts char to int.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Unicode & char
--------------

• char = 2 bytes
• Stores Unicode (UTF-16)
• Range: 0 to 65535
• Unsigned type
• 'A' = 65
• char + char → int
• '\u0041' → A
• Default value → '\u0000'
• Emojis may use 2 chars
```

---
