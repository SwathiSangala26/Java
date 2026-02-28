## 1️⃣ Definition

### 🔹 `==` Operator

* Compares **references (memory address)**
* Checks if two variables point to the **same object**

### 🔹 `equals()` Method

* Compares **content (values inside object)**
* Defined inside `Object` class
* Overridden in `String` class

---

## 2️⃣ Visual Representation

---

### Case 1: String Literals

```java
String s1 = "Java";
String s2 = "Java";
```

Memory:

```
String Constant Pool

 ┌───────────────┐
 │    "Java"     │
 └───────────────┘
     ↑        ↑
    s1       s2
```

Now:

```
s1 == s2      → true
s1.equals(s2) → true
```

Because both refer to same object.

---

### Case 2: Using new Keyword

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Memory:

```
Heap

 ┌───────────────┐   ┌───────────────┐
 │    "Java"     │   │    "Java"     │
 └───────────────┘   └───────────────┘
      ↑                   ↑
     s1                  s2
```

Now:

```
s1 == s2      → false   (different references)
s1.equals(s2) → true    (same content)
```

---

## 3️⃣ Key Features / Properties

### `==`

* Operator
* Works for primitives & objects
* For objects → compares reference
* Faster (simple reference compare)

### `equals()`

* Method
* Meant for content comparison
* Can be overridden
* String overrides equals()

---

## 4️⃣ Syntax

```java
s1 == s2
s1.equals(s2)
```

---

## 5️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1 == s2);        // false
        System.out.println(s1.equals(s2));   // true
    }
}
```

---

## 6️⃣ Use Cases

| Situation                               | Use                 |
| --------------------------------------- | ------------------- |
| Compare primitive values                | `==`                |
| Compare String content                  | `equals()`          |
| Check if two references are same object | `==`                |
| Compare custom object values            | Override `equals()` |

---

## 7️⃣ Pitfalls / Notes

⚠ Most common mistake in interviews:

```java
if(s1 == s2)
```

When comparing strings → WRONG.

✔ Always use:

```java
if(s1.equals(s2))
```

---

⚠ NullPointerException Risk:

```java
String s = null;
s.equals("Java"); // NullPointerException
```

Safer way:

```java
"Java".equals(s);  // safe
```

---

## 8️⃣ Real-World Analogy

Think of:

Two houses:

* Same design
* Same color
* Same structure

But different locations.

`==` → checks if both people live in **same house**
`equals()` → checks if houses are **identical in design**

---

## 9️⃣ Best Practices

✔ Use `equals()` for String comparison
✔ Use `==` for primitives
✔ Avoid `==` for object content comparison
✔ Use `"constant".equals(variable)` to avoid NPE
✔ Override equals() properly in custom classes

---

## 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What will be output?

```java
String s1 = "Java";
String s2 = "Ja" + "va";

System.out.println(s1 == s2);
```

Answer: true
(Compile-time optimization → same pool object)

---

### 2️⃣ What about this?

```java
String s1 = "Java";
String s2 = "Ja";
String s3 = s2 + "va";

System.out.println(s1 == s3);
```

Answer: false
(Runtime concatenation → new object in heap)

---

### 3️⃣ What happens here?

```java
String s1 = null;
System.out.println("Java".equals(s1));
```

Answer: false (No exception)

---

### 4️⃣ Why does equals() work for String?

Because String overrides `equals()` to compare character values.

---

### 5️⃣ What does Object class equals() do by default?

Default equals() behaves like `==`
(Reference comparison)

---

### 6️⃣ Difference between equals() and equalsIgnoreCase()?

* `equals()` → case-sensitive
* `equalsIgnoreCase()` → ignores case

---

## 🧾 Quick Recap / Cheat Sheet

* `==` → reference comparison
* `equals()` → content comparison
* String overrides equals()
* Use equals() for String comparison
* `==` works for primitives
* `"constant".equals(variable)` avoids NPE
* Compile-time concatenation → same pool object
* Runtime concatenation → new heap object

---
