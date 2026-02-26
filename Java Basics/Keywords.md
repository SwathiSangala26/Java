## 1️⃣ Definition

Keywords are **reserved words in Java** that have predefined meaning.

They cannot be used as identifiers (variable name, class name, method name, etc.).

---

## 2️⃣ Visual Representation

```id="k1a7xz"
Keywords → Reserved Words

Examples:
class
public
static
void
int
if
else
return
new
```

These words are reserved by the Java language.

---

## 3️⃣ Key Features / Properties

* Reserved by Java language
* Have fixed meaning
* Cannot be used as identifiers
* All keywords are lowercase
* Case-sensitive

Example:

```java id="9otq1c"
int class = 10;   // ❌ Error
```

Because `class` is a keyword.

---

## 4️⃣ Syntax Examples

```java id="6ye3fz"
public class Demo {

    public static void main(String[] args) {

        int number = 10;

        if(number > 5) {
            System.out.println("Greater");
        } else {
            System.out.println("Smaller");
        }

        return;
    }
}
```

Keywords used here:

* public
* class
* static
* void
* int
* if
* else
* return

---

## 5️⃣ Categories of Keywords

Java has 50+ keywords (depending on version).

### 🔹 Data Type Keywords

int, double, float, char, boolean, byte, short, long

### 🔹 Access Modifiers

public, private, protected

### 🔹 Control Flow

if, else, switch, case, break, continue, return

### 🔹 Looping

for, while, do

### 🔹 Class Related

class, interface, extends, implements, new

### 🔹 Exception Handling

try, catch, finally, throw, throws

### 🔹 Object Related

this, super

### 🔹 Other Important

static, final, abstract, synchronized, volatile, transient, instanceof

---

## 6️⃣ Use Cases

Keywords are used to:

* Define classes
* Control flow
* Declare variables
* Handle exceptions
* Control access
* Define inheritance

Without keywords, Java syntax cannot exist.

---

## 7️⃣ Pitfalls / Notes

* Cannot use keyword as identifier
* Keywords are lowercase only
  `Class` is identifier
  `class` is keyword
* `goto` and `const` are reserved but not used
* From Java 9, `_` is reserved

---

## 8️⃣ Real-World Analogy

Keywords are like **reserved government words**.

You cannot use them for your personal naming because they already have official meaning.

---

## 9️⃣ Best Practices

* Memorize common keywords
* Understand purpose instead of memorizing blindly
* Be careful with case sensitivity
* Do not attempt to redefine keywords

---

## 🔟 Tricky Questions (With Answers)

Q1: Can we use keyword as variable name?
No.

Q2: Are keywords case-sensitive?
Yes.

Q3: Is `Class` a keyword?
No. `class` is keyword. `Class` is an identifier.

Q4: How many keywords are there in Java?
Around 50+ (depends on version).

Q5: Is `goto` used in Java?
No, but it is reserved.

Q6: Is `_` a keyword?
From Java 9, it is reserved and cannot be used as identifier.

---

## 🧾 Quick Recap / Cheat Sheet

```id="z3mhre"
Keywords:
- Reserved words in Java
- Cannot be used as identifiers
- All lowercase
- Fixed meaning

Examples:
class, public, static, void, int,
if, else, return, new, try, catch
```

---
