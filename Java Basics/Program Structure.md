## 1️⃣ Definition

Program Structure defines the **basic components and layout** of a Java program.

It describes how a Java file is organized so that JVM can execute it.

---

## 2️⃣ Visual Representation

```
---------------------------------
|  Package Statement (Optional) |
---------------------------------
|  Import Statements (Optional) |
---------------------------------
|  Class Declaration (Required) |
|    -------------------------   |
|    | Variables               | |
|    | Methods                 | |
|    | Constructors            | |
|    | main() Method           | |
|    -------------------------   |
---------------------------------
```

---

## 3️⃣ Key Components / Properties

A Java program can contain:

1. Package Declaration (optional)
2. Import Statements (optional)
3. Class Declaration (mandatory)
4. Variables (Instance / Static)
5. Constructors
6. Methods
7. main() Method (entry point)

Important Rule:

* Execution always starts from `main()` method.

---

## 4️⃣ Syntax (Basic Structure)

```java
package packageName;        // optional

import java.util.*;         // optional

public class ClassName {    // mandatory

    // Variables

    // Constructor

    // Methods

    public static void main(String[] args) {
        // Execution starts here
    }
}
```

---

## 5️⃣ Code Example

```java
package demo;

import java.util.Scanner;

public class Example {

    int number;   // instance variable

    public Example(int n) {   // constructor
        number = n;
    }

    void display() {          // method
        System.out.println("Number: " + number);
    }

    🟧 public static void main(String[] args) {   // main method
        Example obj = new Example(10);
        obj.display();
    }
}
```

---

## 6️⃣ Use Cases

* Writing any Java application
* Creating console programs
* Building OOP-based applications
* Creating entry point for execution

---

## 7️⃣ Important Rules

* File name must match public class name
* Only one public class per file
* main() method must be:

```java
public static void main(String[] args)
```

* Java is case-sensitive
* Code must be inside a class

---

## 8️⃣ Real-World Analogy

Think of program structure like a house blueprint:

* Package → Address
* Import → Tools you bring
* Class → Building
* main() → Main door (entry point)
* Methods → Rooms

---

## 9️⃣ Best Practices

* Follow proper naming conventions
* Keep one public class per file
* Keep main method clean
* Organize code logically
* Use meaningful class and method names

---

## 🔟 Tricky Questions (With Answers)

Q1: Can Java program run without main method?
Yes, but not a normal standalone application. JVM requires main() to start execution.

Q2: Is main() mandatory?
Yes, for standalone applications.

Q3: Why is main() static?
Because JVM calls it without creating an object.

Q4: Can we overload main() method?
Yes, but JVM calls only the standard signature.

Q5: Can we change String[] args to something else?
You can change variable name, but type must be `String[]`.

Q6: Can we make main() private?
No. It must be public so JVM can access it.

---

## 🧾 Quick Recap / Cheat Sheet

```
Java Program Structure:

1. Package (optional)
2. Import (optional)
3. Class (mandatory)
4. Variables
5. Constructor
6. Methods
7. main() → Entry point

Rules:
- File name = Public class name
- main() must be:
  public static void main(String[] args)
```

---
