## 1️⃣ What does `==` do?

* `==` compares **references (memory address)**
* It checks:

  > “Do both variables point to the **same object**?”

### Example

```java
String a = "java";
String b = "java";

System.out.println(a == b);   // true
```

### Why?

* Both literals are stored in **String Constant Pool (SCP)**
* `a` and `b` point to the **same object**

---

## 2️⃣ What does `.equals()` do?

* `.equals()` compares **content (characters)**
* It checks:

  > “Do both objects contain the same sequence of characters?”

### Example

```java
String a = "java";
String b = "java";

System.out.println(a.equals(b));  // true
```

---

## 3️⃣ `new String()` case (VERY COMMON INTERVIEW TRAP)

```java
String a = new String("java");
String b = new String("java");

System.out.println(a == b);        // false
System.out.println(a.equals(b));   // true
```

### Explanation

* `new String()` **always creates a new object in heap**
* References are different → `== false`
* Content is same → `.equals() true`

---

## 4️⃣ Mixed Case (Literal + new String)

```java
String a = "java";
String b = new String("java");

System.out.println(a == b);        // false
System.out.println(a.equals(b));   // true
```

### Why?

* `a` → SCP
* `b` → heap
* Different memory locations

---

## 5️⃣ How `.equals()` works internally (IMPORTANT)

In java.lang.Object

* `.equals()` is **overridden**
* It compares:

  1. Length
  2. Each character in order

That’s why content comparison works.

---

## 6️⃣ Why `==` sometimes returns true for Strings?

Because of **String Pooling**.

```java
String a = "hello";
String b = "hello";

a == b   // true (same pooled object)
```

⚠️ This does **NOT** mean `==` compares content
It just happens to point to the same object.

---

## 7️⃣ Interview Rule (MEMORIZE THIS)

> **Always use `.equals()` to compare Strings**

Never rely on `==` unless you are **intentionally checking references**.

---

## 8️⃣ Real Interview Question

### ❓ Which one should we use for string comparison?

### ✅ Answer:

> Use `.equals()` because it compares content, while `==` compares references.

---

## 9️⃣ Common Bug Example (They LOVE this)

```java
if (userInput == "admin") {
    // bug!
}
```

### Correct code:

```java
if ("admin".equals(userInput)) {
    // safe
}
```

Why?

* Avoids `NullPointerException`
* Compares content correctly

---

## 10️⃣ One-Line Interview Summary (VERY IMPORTANT)

> “`==` compares references, `.equals()` compares content. For Strings, always use `.equals()`.”
