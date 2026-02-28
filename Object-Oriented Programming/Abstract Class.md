## 1️⃣ Definition

An **Abstract Class** is a class declared using the `abstract` keyword that cannot be instantiated.

It is used to:

* Provide partial abstraction
* Define common behavior
* Force subclasses to implement specific methods

It can contain:

* Abstract methods (without body)
* Concrete methods (with body)
* Constructors
* Variables

---

## 2️⃣ Visual Representation

### Structure

```id="ac_v1"
abstract class Base
      |
      |-- abstract method()
      |-- concrete method()
      |
Concrete Class
      |
      |-- implements abstract method()
```

---

### Instantiation Rule

```id="ac_v2"
abstract class Base  --> Cannot create object

Base b = new Base();  ❌ Not allowed
```

---

### Runtime Behavior

```id="ac_v3"
Base ref = new Child();
ref.method();   --> Child implementation executes
```

---

## 3️⃣ Key Features / Properties

* Declared using `abstract` keyword
* Cannot be instantiated
* May contain abstract and concrete methods
* Can have constructors
* Can have instance variables
* Supports inheritance
* Enables runtime polymorphism
* Can contain static methods
* Can contain final methods

---

## 4️⃣ Syntax

```java id="abscls_s1"
abstract class Vehicle {

    abstract void start();

    void fuelType() {
        System.out.println("Petrol/Diesel");
    }
}
```

---

## 5️⃣ Code Example

```java id="abscls_ex1"
abstract class Employee {

    abstract void calculateSalary();

    void companyName() {
        System.out.println("ABC Pvt Ltd");
    }
}

class Developer extends Employee {

    @Override
    void calculateSalary() {
        System.out.println("Developer Salary Calculated");
    }

    public static void main(String[] args) {

        Employee emp = new Developer();
        emp.calculateSalary();
        emp.companyName();
    }
}
```

Explanation:

* Abstract method declared in parent
* Implemented in child
* Parent reference holds child object
* Runtime polymorphism achieved

---

## 6️⃣ Use Cases

* Creating common base classes
* Framework design
* Template method pattern
* Standardizing behavior
* Enforcing method implementation
* Shared logic among subclasses

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot instantiate abstract class
* ❌ Child must implement all abstract methods
* ❌ Abstract method cannot be private
* ❌ Abstract method cannot be static or final
* ❌ Overusing abstract classes
* ❌ Confusing with interface

---

## 8️⃣ Real-World Analogy

🏢 Company Policy Document

* Defines rules (abstract methods)
* Provides common guidelines (concrete methods)
* Departments implement specific rules

---

## 9️⃣ Best Practices

* Use abstract class when common code needs to be shared
* Keep abstraction meaningful
* Avoid too many abstract methods
* Use constructor for shared initialization
* Follow Liskov Substitution Principle
* Prefer interface when full abstraction required

---

## 🔟 Tricky Questions

1. What is an abstract class?
   ➜ A class that cannot be instantiated and may contain abstract methods.

2. Can abstract class have constructor?
   ➜ Yes.

3. Can abstract class have concrete methods?
   ➜ Yes.

4. Can abstract class be instantiated?
   ➜ No.

5. Must subclass implement all abstract methods?
   ➜ Yes, unless subclass is also abstract.

6. Can abstract method be private?
   ➜ No.

7. Can abstract method be static?
   ➜ No.

8. Can abstract class have static methods?
   ➜ Yes.

9. Can abstract class have final methods?
   ➜ Yes.

10. Does abstract class support multiple inheritance?
    ➜ No.

11. Can abstract class extend another class?
    ➜ Yes.

12. Can abstract class implement interface?
    ➜ Yes.

13. Can abstract class have variables?
    ➜ Yes.

14. What happens if abstract keyword removed from class but abstract method exists?
    ➜ Compilation error.

15. When should you use abstract class over interface?
    ➜ When shared implementation is required.

---

## 🧾 Quick Recap / Cheat Sheet

* Declared using `abstract`
* Cannot instantiate
* Can contain abstract + concrete methods
* Can have constructors
* Supports runtime polymorphism
* Child must implement abstract methods
* Abstract method cannot be private/static/final
* Used for partial abstraction
* Good for shared logic
* Supports inheritance
* Important OOP concept
* Frequently asked interview topic
* Used in frameworks
* Enables standardization
* Choose when shared code is needed

---
