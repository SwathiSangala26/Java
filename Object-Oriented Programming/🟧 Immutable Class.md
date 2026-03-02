## 1️⃣ Definition

An **Immutable Class** is a class whose objects **cannot be modified after creation**.

Once an object is created:

* Its state cannot change
* No setter methods
* All fields remain constant

Example: `String` class in Java.

---

## 2️⃣ Visual Representation

### Object Creation

```id="im_v1"
Create Object
     |
     |-- state initialized
     |
No modification allowed after creation
```

---

### Immutability Rule

```id="im_v2"
final class Person
     |
     |-- private final fields
     |-- no setters
```

---

### Memory Concept

```id="im_v3"
Old Object (unchanged)
        |
Modification attempt
        |
New Object created (if needed)
```

---

## 3️⃣ Key Features / Properties

* Class declared as `final`
* All fields are `private`
* All fields are `final`
* No setter methods
* Provide getters only
* Defensive copy for mutable objects
* Thread-safe by default

---

## 4️⃣ Syntax

```java id="im_s1"
final class Person {

    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

---

## 5️⃣ Code Example

```java id="im_ex1"
final class Student {

    private final int roll;
    private final String name;

    public Student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        Student s = new Student(101, "Swathi");

        System.out.println(s.getRoll());
        System.out.println(s.getName());
    }
}
```

No method exists to modify `roll` or `name`.

---

## 6️⃣ Use Cases

* Security-sensitive data
* Thread-safe applications
* Cache keys
* Map keys
* Banking systems
* Configuration objects
* DTOs in multi-threaded systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Forgetting to make class final
* ❌ Forgetting to make fields final
* ❌ Returning mutable object reference directly
* ❌ Not using defensive copy
* ❌ Confusing final reference with immutability

---

## 8️⃣ Real-World Analogy

🔐 Sealed Document

* Once sealed and signed
* Cannot be altered
* Any change requires new document

---

## 9️⃣ Best Practices

* Declare class as final
* Make all fields private and final
* Do not provide setters
* Use constructor for initialization
* Return defensive copies for mutable objects
* Ensure immutability deeply (not shallow)
* Override equals() and hashCode() if needed

---

## 🔟 Tricky Questions

1. What is immutable class?
   ➜ A class whose objects cannot be modified after creation.

2. Is String immutable?
   ➜ Yes.

3. Why make class final?
   ➜ To prevent subclass from modifying behavior.

4. Why make fields final?
   ➜ To prevent reassignment.

5. Why make fields private?
   ➜ To restrict direct access.

6. Why no setters in immutable class?
   ➜ To prevent modification.

7. What is defensive copy?
   ➜ Returning copy of mutable object instead of original reference.

8. Is immutable class thread-safe?
   ➜ Yes.

9. Can immutable class contain mutable object?
   ➜ Yes, but must use defensive copy.

10. Does final reference make object immutable?
    ➜ No.

11. Why is immutability important?
    ➜ Security and thread safety.

12. Can constructor modify final field?
    ➜ Yes (only during initialization).

13. Can immutable object be changed via reflection?
    ➜ Technically yes (but unsafe).

14. Why are immutable objects good as Map keys?
    ➜ Because hashCode won’t change.

15. Is immutability compile-time or runtime property?
    ➜ Design-time concept enforced at compile time.

---

## 🧾 Quick Recap / Cheat Sheet

* Immutable = Cannot change after creation
* Class should be final
* Fields private & final
* No setters
* Initialize via constructor
* Use defensive copy
* Thread-safe by default
* String is immutable
* Good for Map keys
* Improves security
* Prevents accidental modification
* Avoid exposing mutable objects
* Important interview topic
* Common in concurrent programming
* Core design principle

---
