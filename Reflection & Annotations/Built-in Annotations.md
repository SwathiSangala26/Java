## 1️⃣ Definition

Built-in annotations are predefined annotations provided by Java to supply metadata to the compiler, JVM, or tools.

They help in:

* Compile-time validation
* Code clarity
* Error prevention

Common built-in annotations:

* `@Override`
* `@Deprecated`
* `@SuppressWarnings`
* `@FunctionalInterface`

---

## 2️⃣ Visual Representation

### @Override Validation

```
Parent
   |
   |  void show()
   |
Child
   |
   |  @Override
   |  void show()
   |
Compiler verifies correct overriding
```

---

### @Deprecated Warning

```
@Deprecated
oldMethod()

↓
Compiler Warning: Method is deprecated
```

---

## 3️⃣ Key Features / Properties

* Provide metadata (not logic)
* Mostly checked at compile time
* Improve code safety
* Prevent accidental mistakes
* Part of `java.lang`
* Some can affect runtime tools

---

## 4️⃣ Syntax

```java
@Override
public void display() { }
```

```java
@Deprecated
void oldMethod() { }
```

---

## 5️⃣ Code Example

```java
class Demo {

    @Deprecated
    void oldMethod() {
        System.out.println("Old method");
    }

    @Override
    public String toString() {
        return "Demo";
    }

    @SuppressWarnings("unchecked")
    void test() {
        java.util.List list = new java.util.ArrayList();
    }
}
```

---

## 6️⃣ Use Cases

* Ensuring correct method overriding
* Marking outdated APIs
* Suppressing unavoidable warnings
* Validating functional interfaces
* Improving compile-time safety

---

## 7️⃣ Pitfalls / Notes

* ❌ Overusing `@SuppressWarnings`
* ❌ Ignoring `@Deprecated` warnings
* ❌ Forgetting `@Override`
* ❌ Assuming annotations change logic
* ❌ Suppressing important compiler errors

---

## 8️⃣ Real-World Analogy

* `@Override` → Verified replacement label
* `@Deprecated` → “Do Not Use” sticker
* `@SuppressWarnings` → Ignore minor alert
* `@FunctionalInterface` → Single-purpose tool tag

Annotations act like labels for the compiler.

---

## 9️⃣ Best Practices

* Always use `@Override` when overriding
* Avoid unnecessary `@SuppressWarnings`
* Replace deprecated APIs gradually
* Use `@FunctionalInterface` for lambda interfaces
* Treat compiler warnings seriously

---

## 🔟 Tricky Questions

11. What are built-in annotations?
    ➜ Predefined annotations provided by Java for metadata.

12. Which package contains them?
    ➜ `java.lang`.

13. What does `@Override` ensure?
    ➜ That a method correctly overrides a parent method.

14. What happens if `@Override` is incorrect?
    ➜ Compilation error.

15. Does `@Deprecated` stop method usage?
    ➜ No, it gives a warning.

16. What is `@SuppressWarnings` used for?
    ➜ To suppress specific compiler warnings.

17. What is `@FunctionalInterface` used for?
    ➜ Ensures only one abstract method exists.

18. Are annotations part of program logic?
    ➜ No, they provide metadata.

19. Is `@FunctionalInterface` mandatory?
    ➜ No, but recommended.

20. When are built-in annotations checked?
    ➜ Mostly at compile time.

21. Can multiple annotations be applied to a method?
    ➜ Yes.

22. What happens if a functional interface has two abstract methods?
    ➜ Compilation error.

23. Can `@SuppressWarnings` hide serious issues?
    ➜ Yes, if misused.

24. Do annotations require semicolons?
    ➜ No.

25. Why is `@Override` considered best practice?
    ➜ Prevents accidental method mismatch.

---

## 🧾 Quick Recap / Cheat Sheet

* Built-in annotations = Java predefined metadata
* `@Override` → override validation
* `@Deprecated` → mark outdated
* `@SuppressWarnings` → hide warnings
* `@FunctionalInterface` → single abstract method
* Checked mostly at compile time
* Improve safety
* Do not change program logic
* Prevent errors
* Encourage clean code
* Avoid overusing suppression
* Use `@Override` always
* Heavily asked in interviews

---
