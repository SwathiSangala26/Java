## 1️⃣ Definition

`main` is the **entry point** of a Java application.

When JVM starts execution:

* It looks for the `main` method
* Execution begins from this method

Standard signature:

```java
public static void main(String[] args)
```

---

## 2️⃣ Visual Representation

### JVM Execution Flow

```id="main_v1"
JVM Starts
     |
     |-- Loads Class
     |
     |-- Finds main()
     |
     |-- Executes Program
```

---

### Method Structure

```id="main_v2"
public     → Access modifier
static     → No object required
void       → No return value
main       → Method name
String[]   → Command-line arguments
```

---

## 3️⃣ Key Features / Properties

* Must be public
* Must be static
* Must return void
* Must accept String array
* JVM calls it automatically
* Can be overloaded (but only one valid signature used)
* Can throw exceptions

---

## 4️⃣ Syntax

Standard form:

```java
public static void main(String[] args)
```

Valid alternatives:

```java
public static void main(String args[])

public static void main(String... args)
```

---

## 5️⃣ Code Example

```java
public class Main {

    public static void main(String[] args) {

        System.out.println("Program Started");

        if (args.length > 0) {
            System.out.println("First Argument: " + args[0]);
        }
    }
}
```

---

## 6️⃣ Use Cases

* Program execution start point
* Command-line argument handling
* Application bootstrapping
* Testing code
* Running standalone applications

---

## 7️⃣ Pitfalls / Notes

* 🟧 ❌ Missing static keyword → JVM cannot call
* ❌ Wrong signature → Runtime error
* ❌ Private main → Not accessible
* ❌ Returning non-void → Invalid
* ❌ Confusing compile-time and runtime errors
* ❌ Overloaded main doesn’t replace standard main
* 🟧 ❌ cannot override the main method because:
    main is static
    Static methods belong to the class, not the object
    Method overriding requires instance methods
    Static methods can only be hidden, not overridden**

---

## 8️⃣ Real-World Analogy

🎬 Movie Start Button

* Press play
* Movie begins from starting frame
* main() is that starting frame

---

## 9️⃣ Best Practices

* Keep main method clean
* Delegate logic to other methods
* Avoid writing full business logic inside main
* Use proper exception handling
* Use command-line args carefully

---

## 🔟 Tricky Questions

1. What is main method in Java?
   ➜ Entry point of Java program.

2. Why is main method static?
   ➜ So JVM can call it without creating object.

3. Why is main method public?
   ➜ So JVM can access it from outside class.

4. Why does main return void?
   ➜ JVM does not expect return value.

5. Can main be overloaded?
   ➜ Yes.

6. Which main method is executed by JVM?
   ➜ Standard signature only.

7. Can we make main private?
   ➜ No.

8. Can main throw exception?
   ➜ Yes.

9. Can we change parameter type?
   ➜ No.

10. What is String[] args?
    ➜ Command-line arguments.

11. Can we write main as final?
    ➜ Yes, but not required.

12. Can a class have multiple main methods?
    ➜ Yes (overloaded).

13. What happens if main not present?
    ➜ Runtime error.

14. Can interface have main method?
    ➜ Yes (Java 8+).

15. Is main mandatory in every Java class?
    ➜ No, only for standalone execution.

---

## 🧾 Quick Recap / Cheat Sheet

* main = Entry point
* JVM starts from main
* Must be public static void
* Accepts String[] args
* Can be overloaded
* Static → No object required
* Public → Accessible to JVM
* Void → No return
* Handles command-line args
* Can throw exceptions
* Wrong signature → Runtime error
* Keep logic minimal in main
* Delegate tasks to methods
* Essential for standalone apps
* Core interview concept

---
