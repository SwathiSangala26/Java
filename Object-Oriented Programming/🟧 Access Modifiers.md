## 1️⃣ Definition

**Access Modifiers** in Java define the visibility and accessibility of classes, variables, methods, and constructors.

They control:

* Who can access
* From where it can be accessed

Four types:

* `private`
* Default (no modifier)
* `protected`
* `public`

---

## 2️⃣ Visual Representation

### Access Levels (From Most Restrictive → Least Restrictive)

```id="am_v1"
private  --> Only within same class
default  --> Same package
protected --> Same package + subclass
public   --> Everywhere
```

---

### Package vs Subclass Access

```id="am_v2"
                Same Class | Same Package | Subclass (diff pkg) | Other Package
--------------------------------------------------------------------------------
private             ✔            ❌              ❌                  ❌
default             ✔            ✔              ❌                  ❌
protected           ✔            ✔              ✔                  ❌
public              ✔            ✔              ✔                  ✔
```

---

## 3️⃣ Key Features / Properties

* Controls visibility
* Applies to class members
* Top-level class can only be public or default
* Improves security
* Supports encapsulation
* Restricts unauthorized access

---

## 4️⃣ Syntax

### Private

```java id="am_s1"
private int data;
```

---

### Default

```java id="am_s2"
int value;   // no modifier
```

---

### Protected

```java id="am_s3"
protected void display() { }
```

---

### Public

```java id="am_s4"
public class Demo { }
```

---

## 5️⃣ Code Example

```java id="am_ex1"
class Parent {

    private int a = 10;
    int b = 20;            // default
    protected int c = 30;
    public int d = 40;

    void show() {
        System.out.println(a + " " + b + " " + c + " " + d);
    }
}
```

Access depends on location (same class, package, subclass, etc.).

---

## 6️⃣ Use Cases

* Implementing encapsulation
* Securing sensitive data
* Controlling API exposure
* Designing libraries
* Restricting internal logic
* Framework development

---

## 7️⃣ Pitfalls / Notes

* ❌ Making everything public
* ❌ Using default unintentionally
* ❌ Misunderstanding protected behavior
* ❌ Exposing internal implementation
* ❌ Confusing private with default
* ❌ Not following least privilege principle

---

## 8️⃣ Real-World Analogy

🏢 Office Building Access

* `private` → Personal locker
* `default` → Department access
* `protected` → Department + Branch managers
* `public` → Open to everyone

---

## 9️⃣ Best Practices

* Make variables private
* Use public only when necessary
* Prefer protected for inheritance
* Follow principle of least privilege
* Avoid default in large projects
* Expose minimal API surface

---

## 🔟 Tricky Questions

1. What are access modifiers in Java?
   ➜ Keywords that control visibility.

2. How many access modifiers exist?
   ➜ Four.

3. What are they?
   ➜ private, default, protected, public.

4. Which is most restrictive?
   ➜ private.

5. Which is least restrictive?
   ➜ public.

6. Can top-level class be private?
   ➜ No.

7. Can top-level class be protected?
   ➜ No.

8. What is default access?
   ➜ Accessible within same package.

9. Does protected allow access in different package?
   ➜ Yes, through inheritance.

10. Can private members be inherited?
    ➜ They are inherited but not accessible directly.

11. Which modifier supports encapsulation best?
    ➜ private.

12. Can interface methods be private?
    ➜ Yes (Java 9+).

13. Is default same as protected?
    ➜ No.

14. Can constructor have access modifier?
    ➜ Yes.

15. Why avoid making variables public?
    ➜ Breaks encapsulation.

---

## 🧾 Quick Recap / Cheat Sheet

* 4 Access Modifiers
* private → same class only
* default → same package
* protected → package + subclass
* public → everywhere
* Top-level class → public or default only
* Follow least privilege
* Use private for fields
* Important for encapsulation
* Controls API exposure
* Common interview topic
* Protect internal logic
* Avoid unnecessary public access
* Key OOP principle
* Essential for secure design

---
