## 1️⃣ Definition

An **Anonymous Class** is a class without a name that is declared and instantiated at the same time.

It is used to:

* Extend a class
* Implement an interface

It is typically used for short, one-time use implementations.

---

## 2️⃣ Visual Representation

### Structure

```id="ac1"
new InterfaceOrClass() {
    // override methods
};
```

---

### Creation Flow

```id="ac2"
Interface reference
       |
       v
new Interface() {
    implementation
}
```

---

### No Class Name

```id="ac3"
Normal:
class MyClass { }

Anonymous:
new MyClass() { }
```

---

## 3️⃣ Key Features / Properties

* No class name
* Declared and instantiated together
* Used for one-time implementation
* Can extend one class or implement one interface
* Cannot have explicit constructors
* Can access effectively final local variables
* Compiled as separate synthetic `.class` file

---

## 4️⃣ Syntax

### Implementing Interface

```java id="acode1"
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running...");
    }
};
```

---

### Extending Class

```java id="acode2"
Thread t = new Thread() {
    public void run() {
        System.out.println("Thread started");
    }
};
```

---

## 5️⃣ Code Example

```java id="acode3"
interface Greeting {
    void sayHello();
}

public class Example {

    public static void main(String[] args) {

        Greeting g = new Greeting() {
            public void sayHello() {
                System.out.println("Hello from Anonymous Class");
            }
        };

        g.sayHello();
    }
}
```

---

## 6️⃣ Use Cases

* Event handling
* GUI programming
* Thread creation
* Callback implementations
* Comparator implementations
* Quick interface implementation
* Before Java 8 (now often replaced by lambdas)

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot define constructors
* ❌ Harder to read if large
* ❌ Only one class/interface can be extended/implemented
* ❌ Cannot be reused
* ❌ Not suitable for complex logic
* ❌ Creates additional class file

---

## 8️⃣ Real-World Analogy

🎭 Temporary Actor

* Interface → Script
* Anonymous class → Actor performing one scene
* No name needed
* After scene ends → Not reused

---

## 9️⃣ Best Practices

* Keep anonymous classes short
* Use lambdas when possible (Java 8+)
* Avoid complex logic inside
* Use for single-method implementations
* Improve readability

---

## 🔟 Tricky Questions

1. What is an anonymous class?
   ➜ A class without a name created and instantiated at the same time.

2. Can anonymous class have a constructor?
   ➜ No.

3. Can it extend a class?
   ➜ Yes, only one.

4. Can it implement multiple interfaces?
   ➜ No.

5. When is it commonly used?
   ➜ For one-time implementations.

6. Can it access local variables?
   ➜ Yes, if effectively final.

7. Is it compiled into a separate class file?
   ➜ Yes.

8. What is difference between anonymous class and lambda?
   ➜ Lambda is shorter and used for functional interfaces.

9. Can anonymous class have static members?
   ➜ No (except static final constants).

10. Can it be reused?
    ➜ No.

11. Why is it less used after Java 8?
    ➜ Lambdas replaced many use cases.

12. Can you override methods inside it?
    ➜ Yes.

13. Does it have a class name internally?
    ➜ Yes, compiler generates synthetic name.

14. Can it extend abstract class?
    ➜ Yes.

15. When should you avoid anonymous class?
    ➜ When logic becomes complex.

---

## 🧾 Quick Recap / Cheat Sheet

* No class name
* Created & instantiated together
* One-time use
* Extends one class OR implements one interface
* No constructor
* Access effectively final variables
* Separate `.class` file generated
* Common in event handling
* Replaced by lambdas often
* Keep it short
* Not reusable
* Good for quick implementations
* Used before Java 8 extensively
* Important nested class type
* Frequently asked interview topic

---
