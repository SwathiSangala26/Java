## 1️⃣ Definition

**Method Overriding** happens when a subclass provides its own implementation of a method that is already defined in its parent class.

It supports **Runtime Polymorphism** (Dynamic Method Dispatch).

Conditions:

* Same method name
* Same parameter list
* Same or covariant return type
* Requires inheritance

---

## 2️⃣ Visual Representation

### Parent → Child

```
Parent
   |
   |-- display()
   |
Child
   |
   |-- display()   (Overridden)
```

---

### Runtime Binding

```
Parent ref = new Child();
ref.display();   ---> Child version executes
```

Decision happens at runtime based on object, not reference.

---

## 3️⃣ Key Features / Properties

* Requires inheritance
* Same method signature
* Same or covariant return type
* Access modifier cannot be more restrictive
* Cannot override static methods (they are hidden)
* Cannot override final methods
* Private methods are not overridden
* Runtime binding

---

## 4️⃣ Syntax

```java
class Parent {
    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    @Override
    void display() {
        System.out.println("Child display");
    }
}
```

---

## 5️⃣ Code Example (Simple & Clear)

```java
class Employee {

    void getRole() {
        System.out.println("Employee Role");
    }
}

class Manager extends Employee {

    @Override
    void getRole() {
        System.out.println("Manager Role");
    }

    public static void main(String[] args) {

        Employee emp = new Manager();
        emp.getRole();   // Output: Manager Role
    }
}
```

Explanation:

* Reference type → Employee
* Object type → Manager
* Executed method → Manager version (runtime decision)

---

## 6️⃣ Use Cases

* Customizing behavior in subclasses
* Extending functionality
* Framework method customization
* Runtime polymorphism
* Implementing business-specific logic

---

## 7️⃣ Pitfalls / Notes

* ❌ Changing parameter list → becomes overloading
* ❌ Reducing access modifier
* ❌ Trying to override static method
* ❌ Overriding final method
* ❌ Forgetting @Override
* ❌ Not understanding runtime binding

---

## 8️⃣ Real-World Analogy

🧑‍💼 Role-Based Behavior

* Parent class defines general behavior
* Child class customizes that behavior
* At runtime, system executes based on actual object

---

## 9️⃣ Best Practices

* Always use `@Override`
* Maintain same method contract
* Follow Liskov Substitution Principle
* Avoid breaking parent logic
* Use `super.method()` when needed

---

## 🔟 Tricky Questions

1. What is method overriding?
   ➜ Subclass redefining parent class method.

2. Is overriding compile-time or runtime?
   ➜ Runtime.

3. What must match for overriding?
   ➜ Method name and parameters.

4. Can return type change?
   ➜ Yes, if covariant.

5. Can static methods be overridden?
   ➜ No (method hiding).

6. Can final methods be overridden?
   ➜ No.

7. Can private methods be overridden?
   ➜ No.

8. Can access modifier be reduced?
   ➜ No.

🟧 9. What is dynamic method dispatch?
   ➜ Runtime selection of overridden method.

10. Can constructors be overridden?
    ➜ No.

11. What if parameter list changes?
    ➜ It becomes overloading.

12. Why use @Override?
    ➜ Compile-time safety.

13. Can overridden method throw broader checked exception?
    ➜ No.

14. Does overriding support polymorphism?
    ➜ Yes.

15. Which version executes: reference type or object type?
    ➜ Object type.

---

## 🧾 Quick Recap / Cheat Sheet

* Requires inheritance
* Same method signature
* Runtime polymorphism
* Cannot override static, final, private
* Cannot reduce access level
* Parent reference → Child object allowed
* Runtime binding
* Use @Override
* Covariant return allowed
* Constructors cannot be overridden
* Overriding ≠ Overloading
* Dynamic method dispatch
* Important OOP concept
* Frequently asked interview topic
* Runtime decision

---
