## 1️⃣ Definition

**Late Binding** (also called **Runtime Binding** or **Dynamic Binding**) is the process where the **method call is resolved at runtime instead of compile time**.

It occurs when:

* **Method overriding is used**
* Method call depends on **actual object type**

The JVM decides **which method to execute during runtime**.

---

## 2️⃣ Visual Representation

### Compile Time vs Runtime Decision

```
Reference Type → Parent
Object Type    → Child
        |
        | Method call
        v
Runtime decides method execution
```

---

### Dynamic Dispatch

```
Parent p = new Child();
p.show();
     |
     v
Child.show() executed
```

Because runtime object = Child.

---

### Runtime Binding Flow

```
Method Call
     |
Check actual object type
     |
Select overridden method
     |
Execute method
```

---

## 3️⃣ Key Features / Properties

* Happens at **runtime**
* Used in **method overriding**
* Supports **runtime polymorphism**
* Depends on **object type**
* Requires **inheritance**
* Achieved through **dynamic method dispatch**
* Cannot occur with **static methods**

---

## 4️⃣ Syntax

Example structure:

```java
Parent ref = new Child();
ref.method();
```

Runtime decides which method runs.

---

## 5️⃣ Code Example

```java
class Parent {

    void show() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    void show() {
        System.out.println("Child method");
    }
}

public class Main {

    public static void main(String[] args) {

        Parent obj = new Child();

        obj.show();
    }
}
```

Output:

```
Child method
```

Because runtime object = `Child`.

---

## 6️⃣ Use Cases

* Runtime polymorphism
* Dynamic method selection
* Framework implementations
* Plugin systems
* Strategy design pattern
* API extensibility

---

## 7️⃣ Pitfalls / Notes

* ❌ Static methods do NOT support late binding
* ❌ Private methods cannot be overridden
* ❌ Final methods cannot be overridden
* ❌ Constructors cannot use late binding
* ❌ Confusing compile-time and runtime polymorphism

---

## 8️⃣ Real-World Analogy

📞 Customer Support Call

* Call goes to **support system**
* System checks **available agent type**
* Correct agent handles request

Decision happens **at runtime**, not before.

---

## 9️⃣ Best Practices

* Use proper inheritance design
* Override methods carefully
* Avoid excessive deep hierarchies
* Ensure method signatures match
* Use `@Override` annotation

---

## 🔟 Tricky Questions

1. What is late binding?
   ➜ Method call resolved at runtime.

2. What is another name for late binding?
   ➜ Runtime binding.

3. Which concept uses late binding?
   ➜ Method overriding.

4. Does late binding occur at compile time?
   ➜ No.

5. Which polymorphism uses late binding?
   ➜ Runtime polymorphism.

6. Does static method support late binding?
   ➜ No.

7. Does final method support late binding?
   ➜ No.

8. Does private method support late binding?
   ➜ No.

9. Which mechanism enables late binding?
   ➜ Dynamic method dispatch.

10. Which determines method execution?
    ➜ Actual object type.

11. Does late binding require inheritance?
    ➜ Yes.

12. Is method overloading late binding?
    ➜ No (compile-time binding).

13. Can constructors use late binding?
    ➜ No.

14. What is dynamic dispatch?
    ➜ JVM selecting method at runtime.

15. Which reference determines runtime method?
    ➜ Object type.

---

## 🧾 Quick Recap / Cheat Sheet

* Late binding = runtime binding
* Method resolved at runtime
* Used in method overriding
* Supports runtime polymorphism
* Depends on object type
* Requires inheritance
* Achieved via dynamic dispatch
* Static methods → no late binding
* Private methods → no overriding
* Final methods → no overriding
* Constructors excluded
* JVM decides method at runtime
* Improves flexibility
* Important OOP concept
* Common interview question
