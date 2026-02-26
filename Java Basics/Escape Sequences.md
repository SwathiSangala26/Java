# 1️⃣ Definition

An **escape sequence** is a special character combination used inside character or string literals to represent characters that are difficult or impossible to type directly.

They start with a **backslash (`\`)**.

Example:

```java
System.out.println("Hello\nWorld");
```

Here, `\n` is an escape sequence.

---

# 2️⃣ Visual Representation

---

## 🔹 Without Escape

```text
HelloWorld
```

---

## 🔹 With Escape (\n)

```text
Hello
World
```

In code:

```text
"Hello\nWorld"
        ↑
   Escape sequence
```

---

# 3️⃣ List of Escape Sequences

| Escape | Meaning         | Example Output           |
| ------ | --------------- | ------------------------ |
| `\n`   | New line        | Line break               |
| `\t`   | Tab space       | Horizontal tab           |
| `\b`   | Backspace       | Removes previous char    |
| `\r`   | Carriage return | Moves cursor to start    |
| `\f`   | Form feed       | Page break (rarely used) |
| `\'`   | Single quote    | '                        |
| `\"`   | Double quote    | "                        |
| `\\`   | Backslash       | \                        |

---

# 4️⃣ Code Examples

---

## 🔹 1. New Line (`\n`)

```java
System.out.println("Java\nBasics");
```

Output:

```
Java
Basics
```

---

## 🔹 2. Tab (`\t`)

```java
System.out.println("Name:\tSwathi");
```

Output:

```
Name:   Swathi
```

---

## 🔹 3. Double Quote (`\"`)

```java
System.out.println("She said \"Hello\"");
```

Output:

```
She said "Hello"
```

---

## 🔹 4. Backslash (`\\`)

```java
System.out.println("C:\\Users\\Swathi");
```

Output:

```
C:\Users\Swathi
```

---

## 🔹 5. Backspace (`\b`)

```java
System.out.println("Java\bX");
```

Output:

```
JavX
```

---

## 🔹 6. Carriage Return (`\r`)

```java
System.out.println("Hello\rJava");
```

Output:

```
Javao
```

Explanation:
`\r` moves cursor to start and overwrites characters.

---

# 5️⃣ Where Escape Sequences Are Used

✔ Inside String literals
✔ Inside char literals
✔ Printing formatted text
✔ File paths (Windows)
✔ Writing special characters

---

# 6️⃣ Important Rules

---

### ⚠ 1. Must Be Inside Quotes

```java
\n   // Error
```

✔ Must be inside string or char.

---

### ⚠ 2. Only One Character Allowed in char

```java
char c = '\n';   // Valid
char c = '\nn';  // Error
```

---

### ⚠ 3. Backslash is Special

```java
System.out.println("C:\Users");
```

❌ Compile error

✔ Correct:

```java
System.out.println("C:\\Users");
```

---

# 7️⃣ Difference Between Escape Sequence & Unicode

Escape sequence:

```java
'\n'
```

Unicode:

```java
'\u0041'  // 'A'
```

Unicode represents character using hexadecimal code.

---

# 8️⃣ Real-World Analogy

Escape sequence is like telling the printer:

* “Go to next line”
* “Insert tab”
* “Print a quote”

You are instructing formatting behavior inside text.

---

# 9️⃣ Best Practices

✔ Use `\n` instead of multiple println
✔ Use `\\` in file paths
✔ Avoid overusing `\r` unless needed
✔ Use proper formatting for readable output

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Can we write double quotes inside string without escape?

No.

---

### ❓ 2. What happens if we write:

```java
System.out.println("C:\new");
```

Error — because `\n` is treated as newline.

---

### ❓ 3. What is output?

```java
System.out.println("A\tB");
```

A    B (tab space)

---

### ❓ 4. Is '\n' a string or char?

It is a char literal.

---

### ❓ 5. What is difference between '\n' and "\n"?

* '\n' → char
* "\n" → String

---

### ❓ 6. What does \r do?

Moves cursor to beginning of line.

---

# 🧾 Quick Recap / Cheat Sheet

```
Escape Sequences
----------------

\n → New line
\t → Tab
\" → Double quote
\' → Single quote
\\ → Backslash
\b → Backspace
\r → Carriage return
\f → Form feed

Important:
• Used inside quotes only
• Backslash is special
• '\n' ≠ "\n"
```

---
