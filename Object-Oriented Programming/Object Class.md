## 1️⃣ Definition

`Object` class is the **root class of the Java class hierarchy**.

Every class in Java:

* Directly or indirectly extends `Object`
* Inherits its methods

It is present in the `java.lang` package.

---

## 2️⃣ Visual Representation

### Class Hierarchy

```id="obj_v1"
        Object
           |
   -----------------
   |       |       |
  String  Integer  CustomClass
```

All classes derive from `Object`.

---

### Inheritance Flow

```id="obj_v2"
class A { }  ---> implicitly extends Object
```

Equivalent to:

```id="obj_v3"
class A extends Object { }
```

---

## 3️⃣ Key Features / Properties

* Root of all classes
* Located in `java.lang`
* Automatically inherited
* Provides common methods
* Enables polymorphism
* Used for generic references

---

## 4️⃣ Syntax

```java id="obj_s1"
class Demo {
}
```

Implicitly:

```java id="obj_s2"
class Demo extends Object {
}
```

---

## 5️⃣ Code Example

```java id="obj_ex1"
class Student {

    int roll;

    Student(int roll) {
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Roll: " + roll;
    }

    public static void main(String[] args) {

        Student s = new Student(101);
        System.out.println(s.toString());  // Calls Object method overridden
    }
}
```

---

## 6️⃣ Important Methods of Object Class

* `toString()`
* `equals(Object obj)`
* `hashCode()`
* `getClass()`
* `clone()`
* `finalize()` (deprecated)
* `wait()`
* `notify()`
* `notifyAll()`

---

## 7️⃣ Use Cases

* Common base type
* Overriding `toString()` for readable output
* Overriding `equals()` for object comparison
* Hash-based collections (`hashCode()`)
* Thread synchronization (`wait()`, `notify()`)
* Reflection (`getClass()`)

---

## 8️⃣ Pitfalls / Notes

* ❌ Not overriding `equals()` properly
* ❌ Overriding `equals()` but not `hashCode()`
* ❌ Misusing `clone()`
* ❌ Depending on `finalize()`
* ❌ Using `==` instead of `equals()`
* ❌ Ignoring contract between equals and hashCode

---

## 9️⃣ Real-World Analogy

🌳 Family Tree Root

* Object → Root ancestor
* All classes → Descendants
* Common behavior inherited by everyone

---

## 🔟 Tricky Questions

1. What is Object class?
   ➜ Root class of all Java classes.

2. Which package contains Object class?
   ➜ `java.lang`.

3. Does every class extend Object?
   ➜ Yes.

4. What is default parent class if none specified?
   ➜ Object.

5. What does `toString()` return by default?
   ➜ Class name + hash code.

6. What is difference between `==` and `equals()`?
   ➜ `==` compares references; `equals()` compares content (if overridden).

7. Why override `hashCode()` when overriding `equals()`?
   ➜ To maintain contract for collections.

8. What does `getClass()` return?
   ➜ Runtime class of object.

9. Is `clone()` mandatory to override?
   ➜ No.

10. What is finalize() used for?
    ➜ Cleanup before garbage collection (deprecated).

11. Can Object class be extended?
    ➜ Yes, every class extends it.

12. Are Object methods inherited?
    ➜ Yes.

13. Is Object class abstract?
    ➜ No.

14. What is role of wait() and notify()?
    ➜ Thread communication.

15. Why is Object class important?
    ➜ Provides common behavior for all objects.

---

## 🧾 Quick Recap / Cheat Sheet

* Root class of Java
* Located in java.lang
* All classes extend Object
* Default parent if none specified
* Important methods: toString(), equals(), hashCode()
* Override equals & hashCode together
* getClass() for runtime type
* wait/notify for threading
* finalize deprecated
* Enables polymorphism
* Used in collections
* Base of entire hierarchy
* Common interview topic
* Foundation of Java
* Essential core concept

---
