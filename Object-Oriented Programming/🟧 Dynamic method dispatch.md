## 1️⃣ Definition

**Dynamic Method Dispatch** is the mechanism by which a **call to an overridden method is resolved at runtime instead of compile time**.

It happens when:

* A **parent class reference** refers to a **child class object**
* The method being called is **overridden**

The JVM decides **which method to execute based on the actual object type**.

Dynamic method dispatch is the **implementation mechanism of runtime polymorphism**.

---

## 2️⃣ Visual Representation

### Reference vs Object

```
Parent ref = new Child();
ref.show();
```

```
Reference Type → Parent
Object Type    → Child
        |
        v
Child.show() executed
```

---

### Dispatch Flow

```
Method Call
     |
Check actual object type
     |
Locate overridden method
     |
Execute method
```

---

### Runtime Decision

```
Parent p = new Child();

Compile time → checks Parent methods
Runtime      → executes Child method
```

---

## 3️⃣ Key Features / Properties

* Happens at **runtime**
* Works only with **method overriding**
* Requires **inheritance**
* Uses **parent reference + child object**
* Implements **runtime polymorphism**
* JVM decides method execution
* Only applies to **instance methods**

---

## 4️⃣ Syntax

```
Parent reference = new Child();
reference.method();
```

---

## 5️⃣ Code Example

```java
class Parent {

    void display() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    void display() {
        System.out.println("Child method");
    }
}

public class Main {

    public static void main(String[] args) {

        Parent obj = new Child();

        obj.display();
    }
}
```

Output:

```
Child method
```

Because runtime object = Child.

---

## 6️⃣ Use Cases

* Runtime polymorphism
* Framework implementations
* Plugin architectures
* API extensibility
* Strategy design pattern
* Dynamic behavior selection

---

## 7️⃣ Pitfalls / Notes

* ❌ Static methods do NOT use dynamic dispatch
* ❌ Private methods cannot be overridden
* ❌ Final methods cannot be overridden
* ❌ Constructors do not participate
* ❌ Only overridden instance methods apply

---

## 8️⃣ Real-World Analogy

🚗 Driver Using Different Vehicles

* Driver = reference
* Vehicle = actual object

Driver may drive:

```
Car
Bike
Truck
```

Actual vehicle decides behavior at runtime.

---

## 9️⃣ Best Practices

* Use proper inheritance hierarchy
* Override methods correctly
* Use `@Override` annotation
* Avoid deep inheritance chains
* Design for extensibility

---

## 🔟 Tricky Questions

1. What is dynamic method dispatch?
   ➜ Runtime method selection mechanism.

2. When does dynamic method dispatch occur?
   ➜ When overridden method is called through parent reference.

3. Which polymorphism uses dynamic method dispatch?
   ➜ Runtime polymorphism.

4. Does dynamic dispatch happen at compile time?
   ➜ No.

5. What determines method execution?
   ➜ Actual object type.

6. Does static method use dynamic dispatch?
   ➜ No.

7. Does final method support dynamic dispatch?
   ➜ No.

8. Does private method support dynamic dispatch?
   ➜ No.

9. Does dynamic dispatch require inheritance?
   ➜ Yes.

10. What is required for dynamic dispatch?
    ➜ Method overriding.

11. Can constructors use dynamic dispatch?
    ➜ No.

12. Which methods participate in dynamic dispatch?
    ➜ Instance methods.

13. What role does reference type play?
    ➜ Determines accessible methods.

14. What role does object type play?
    ➜ Determines executed method.

15. Why is dynamic dispatch important?
    ➜ Enables runtime polymorphism.

---

## 🧾 Quick Recap / Cheat Sheet

* Dynamic dispatch = runtime method selection
* Works with method overriding
* Requires inheritance
* Parent reference + child object
* Runtime polymorphism mechanism
* JVM decides method execution
* Depends on object type
* Compile time checks reference methods
* Runtime executes object method
* Static methods excluded
* Private methods excluded
* Final methods excluded
* Only instance methods apply
* Core OOP concept
* Very common interview topic
