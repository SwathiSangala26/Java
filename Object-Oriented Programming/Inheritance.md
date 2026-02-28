## 1️⃣ Definition

**Inheritance** is an OOP concept where one class (child/subclass) acquires the properties and behavior of another class (parent/superclass).

It promotes:

* Code reuse
* Hierarchical classification
* Runtime polymorphism

It is implemented using the `extends` keyword.

---

## 2️⃣ Visual Representation

### Basic Structure

```id="inh1"
Parent Class
    |
    |  (extends)
    v
Child Class
```

---

### Example Hierarchy

```id="inh2"
Person
   |
   |-- Employee
         |
         |-- Manager
```

---

### Method Access Flow

```id="inh3"
Child Object
     |
     |-- Can access parent public & protected members
     |-- Cannot access private members directly
```

---

## 3️⃣ Key Features / Properties

* Achieved using `extends`
* Supports single inheritance (class to class)
* Promotes code reuse
* Enables method overriding
* Creates "is-a" relationship
* Constructors are not inherited
* Private members are not directly accessible

---

## 4️⃣ Syntax

```java
class Parent {
    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child method");
    }
}
```

---

## 5️⃣ Code Example

```java
class Employee {

    String company = "ABC Corp";

    void work() {
        System.out.println("Employee working");
    }
}

class Developer extends Employee {

    void code() {
        System.out.println("Developer coding");
    }

    public static void main(String[] args) {

        Developer dev = new Developer();

        System.out.println(dev.company); // inherited variable
        dev.work();                     // inherited method
        dev.code();                     // own method
    }
}
```

---

## 6️⃣ Use Cases

* Code reuse
* Creating hierarchical structures
* Extending functionality
* Framework design
* Polymorphism
* Template method pattern

---

## 7️⃣ Pitfalls / Notes

* ❌ Overusing inheritance (tight coupling)
* ❌ Breaking parent class behavior
* ❌ Forgetting to call `super()`
* ❌ Deep inheritance chains
* ❌ Misusing inheritance instead of composition
* ❌ Private members not accessible

---

## 8️⃣ Real-World Analogy

🏢 Organizational Structure

* Parent class → Base role
* Child class → Specialized role
* Child inherits common features and adds new behavior

---

## 9️⃣ Best Practices

* Use inheritance for "is-a" relationship
* Avoid deep inheritance hierarchy
* Prefer composition when appropriate
* Use `super` carefully
* Maintain Liskov Substitution Principle
* Keep parent class generic

---

## 🔟 Tricky Questions

1. What is inheritance?
   ➜ Mechanism where one class acquires properties of another class.

2. Which keyword is used for inheritance?
   ➜ `extends`.

3. Does Java support multiple inheritance of classes?
   ➜ No.

4. Why doesn’t Java support multiple inheritance of classes?
   ➜ To avoid diamond problem.

5. Are constructors inherited?
   ➜ No.

6. Can private members be inherited?
   ➜ They are inherited but not directly accessible.

7. What is "is-a" relationship?
   ➜ Child is a type of parent.

8. What is `super` keyword used for?
   ➜ To access parent class members.

9. Can a final class be inherited?
   ➜ No.

10. Can a method be overridden in inheritance?
    ➜ Yes.

11. What is multilevel inheritance?
    ➜ Class inherits from a class that inherits another class.

12. What is hierarchical inheritance?
    ➜ Multiple classes inherit from one parent.

13. What is hybrid inheritance?
    ➜ Combination of different types (not fully supported with classes).

14. Is inheritance compile-time or runtime feature?
    ➜ It enables runtime polymorphism.

15. When should inheritance be avoided?
    ➜ When relationship is not truly "is-a".

---

## 🧾 Quick Recap / Cheat Sheet

* Inheritance = Code reuse mechanism
* Keyword: `extends`
* Creates "is-a" relationship
* Supports single inheritance
* Enables overriding
* Constructors not inherited
* Private members not directly accessible
* Use `super` for parent access
* Avoid deep hierarchies
* Prefer composition when needed
* Supports runtime polymorphism
* Important OOP pillar
* Frequently asked interview topic
* Helps reduce redundancy
* Use carefully to avoid tight coupling

---
