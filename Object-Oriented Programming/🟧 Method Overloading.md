## 1️⃣ Definition

**Method Overloading** is a feature in Java where multiple methods in the same class have the **same name** but **different parameter lists**.

It is resolved at **compile time**.

Also called **Compile-Time Polymorphism** or **Static Polymorphism**.

---

## 2️⃣ Visual Representation

### Same Method Name, Different Parameters

```id="mo1"
class Calculator
   |
   |-- add(int a, int b)
   |-- add(double a, double b)
   |-- add(int a, int b, int c)
```

---

### Compile-Time Decision

```id="mo2"
add(5, 10)       --> calls int version
add(5.5, 10.2)   --> calls double version
```

Compiler decides based on arguments.

---

## 3️⃣ Key Features / Properties

* Same method name
* Different parameter list
* Return type alone cannot differentiate methods
* Occurs in same class
* Resolved at compile time
* Improves readability
* Increases flexibility

---

## 4️⃣ Syntax

```java
class Demo {

    void show(int a) {
        System.out.println("Integer: " + a);
    }

    void show(String s) {
        System.out.println("String: " + s);
    }
}
```

---

## 5️⃣ Code Example

```java
class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();

        System.out.println(c.add(5, 10));
        System.out.println(c.add(5.5, 2.5));
        System.out.println(c.add(1, 2, 3));
    }
}
```

---

## 6️⃣ Use Cases

* Mathematical operations
* Flexible method calls
* API design
* Constructor overloading
* Utility classes
* Improved readability

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot overload by return type only
* ❌ Too many overloads reduce readability
* ❌ Confusing method resolution with type conversion
* ❌ Autoboxing may cause ambiguity
* ❌ Varargs can create confusion

---

## 8️⃣ Real-World Analogy

📱 Phone Contact

* Same contact name “John”
* Different phone numbers
* System decides based on number dialed

Same method name, different parameters.

---

## 9️⃣ Best Practices

* Keep overloads logically related
* Avoid excessive overloads
* Ensure parameter difference is clear
* Avoid ambiguous method signatures
* Document overload behavior clearly

---

## 🔟 Tricky Questions

1. What is method overloading?
   ➜ Same method name with different parameter list.

2. Is overloading resolved at compile time or runtime?
   ➜ Compile time.

3. Can methods be overloaded by changing return type only?
   ➜ No.

4. Can static methods be overloaded?
   ➜ Yes.

5. Can constructors be overloaded?
   ➜ Yes.

6. What is required for overloading?
   ➜ Different parameter list.

7. Can we overload main method?
   ➜ Yes.

8. Is method name mandatory to be same?
   ➜ Yes.

9. Can access modifier differ in overloaded methods?
   ➜ Yes.

10. Can overloading happen in different classes?
    ➜ No, must be in same class.

11. What role does type promotion play?
    ➜ Compiler may promote smaller types to match method.

12. What is ambiguity in overloading?
    ➜ When compiler cannot decide which method to call.

13. Does overloading support polymorphism?
    ➜ Yes, compile-time polymorphism.

14. Can final methods be overloaded?
    ➜ Yes.

15. Can private methods be overloaded?
    ➜ Yes.

---

## 🧾 Quick Recap / Cheat Sheet

* Same method name
* Different parameter list
* Compile-time polymorphism
* Return type alone not sufficient
* Occurs in same class
* Constructors can be overloaded
* Static methods can be overloaded
* Avoid ambiguity
* Be careful with autoboxing & varargs
* Improves flexibility
* Common interview question
* Important OOP concept
* Frequently confused with overriding
* Compile-time binding
* Enhances API usability

---
