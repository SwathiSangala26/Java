## 1️⃣ Definition

**Default Import** in Java refers to the **packages that are automatically imported by the Java compiler without writing an import statement**.

The most important default package is:

```
java.lang
```

Because of this, classes like:

* `String`
* `System`
* `Math`
* `Object`
* `Integer`

can be used **without explicitly importing them**.

---

## 2️⃣ Visual Representation

### Without Default Import

```
Program
  |
Need to import package
  |
Use classes
```

---

### With Default Import

```
Program
  |
java.lang automatically available
  |
Directly use String, System, Math
```

---

### Compiler Behavior

```
Java Compiler
     |
Adds implicit import
     |
import java.lang.*;
```

---

## 3️⃣ Key Features / Properties

* Automatically imported by compiler
* No need to write import statement
* Only `java.lang` package is default imported
* Available in every Java program
* Contains core Java classes
* Reduces boilerplate code

---

## 4️⃣ Syntax

Default import happens internally as if the compiler adds:

```java
import java.lang.*;
```

Program example:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

Here `System` and `String` come from `java.lang`.

---

## 5️⃣ Code Example

```java
public class Test {

    public static void main(String[] args) {

        String name = "Java";

        System.out.println(Math.sqrt(16));
    }
}
```

Classes used without import:

* `String`
* `System`
* `Math`

All belong to **java.lang**.

---

## 6️⃣ Use Cases

* Using core Java classes
* Basic program execution
* String manipulation
* Mathematical operations
* Exception handling
* Fundamental object operations

---

## 7️⃣ Pitfalls / Notes

* ❌ Only `java.lang` is automatically imported
* ❌ Other packages must be imported manually
* ❌ Confusing default import with wildcard import
* ❌ Custom packages are never default imported
* ❌ Name conflicts may still occur

---

## 8️⃣ Real-World Analogy

🧰 Basic Toolkit

Every worker automatically receives:

* Hammer
* Screwdriver
* Wrench

Other tools must be requested manually.

---

## 9️⃣ Best Practices

* Know common `java.lang` classes
* Import only required packages
* Avoid unnecessary wildcard imports
* Use fully qualified names when conflicts occur
* Keep imports organized

---

## 🔟 Tricky Questions

1. What is default import in Java?
   ➜ Packages automatically imported by compiler.

2. Which package is default imported in Java?
   ➜ `java.lang`.

3. Do we need to import `java.lang` manually?
   ➜ No.

4. Why can we use String without import?
   ➜ Because it belongs to `java.lang`.

5. Can other packages be default imported?
   ➜ No.

6. Is `java.util` default imported?
   ➜ No.

7. Which class belongs to java.lang?
   ➜ `System`.

8. Does default import apply to user-defined packages?
   ➜ No.

9. What is implicitly added by compiler?
   ➜ `import java.lang.*`.

10. Can we override default import?
    ➜ No.

11. Which class prints output in Java?
    ➜ `System.out`.

12. Does default import improve code readability?
    ➜ Yes.

13. Can name conflicts happen with default imports?
    ➜ Yes.

14. Is Object class in java.lang?
    ➜ Yes.

15. Why is java.lang default imported?
    ➜ It contains core Java classes.

---

## 🧾 Quick Recap / Cheat Sheet

* Default import = automatic package import
* `java.lang` is default imported
* No need to write `import java.lang.*`
* Contains core classes
* Examples: String, System, Math
* Available in every Java program
* Other packages require manual import
* Compiler adds default import internally
* Improves code simplicity
* Does not apply to custom packages
* Part of Java core design
* Prevents repetitive imports
* Important for beginners
* Common interview question
* Remember: only java.lang is default imported
