## 1️⃣ What is StringTokenizer?

* `StringTokenizer` is a **legacy Java utility class**
* Used to **break a string into tokens**
* Tokens are separated using **delimiters**

📌 Package:

```java
java.util.StringTokenizer
```

---

## 2️⃣ Why is it called a *legacy* class?

* Introduced in **Java 1.0**
* Designed before **regex** and modern APIs
* Still supported, but **not recommended** for new code

👉 Modern alternatives:

* `String.split()`
* `Scanner`

---

## 3️⃣ Basic Syntax

```java
StringTokenizer st = new StringTokenizer(String str);
```

or

```java
StringTokenizer st = new StringTokenizer(String str, String delimiters);
```

---

## 4️⃣ Default Delimiters

If you don’t specify delimiters, it uses:

```
Whitespace characters:
space, tab, newline, carriage return
```

Example:

```java
new StringTokenizer("Java is easy");
```

Tokens:

```
Java, is, easy
```

---

## 5️⃣ Important Methods (VERY IMPORTANT)

| Method                    | Description                |
| ------------------------- | -------------------------- |
| `hasMoreTokens()`         | Checks if tokens remain    |
| `nextToken()`             | Returns next token         |
| `countTokens()`           | Number of remaining tokens |
| `nextToken(String delim)` | Changes delimiter          |
| `hasMoreElements()`       | Same as hasMoreTokens()    |
| `nextElement()`           | Same as nextToken()        |

---

## 6️⃣ Example Code

```java
StringTokenizer st = new StringTokenizer("a,b,c", ",");

while (st.hasMoreTokens()) {
    System.out.println(st.nextToken());
}
```

Output:

```
a
b
c
```

---

## 7️⃣ Multiple Delimiters

```java
StringTokenizer st =
    new StringTokenizer("a,b;c d", ",; ");
```

Tokens:

```
a
b
c
d
```

---

## 8️⃣ Does StringTokenizer use Regex?

❌ **NO**

* It treats delimiters as **simple characters**
* No pattern matching
* No complex rules

---

## 9️⃣ Does it modify the original string?

❌ No

* Strings are immutable
* StringTokenizer only **reads** the string

---

## 🔟 Is StringTokenizer thread-safe?

❌ No

* It is **not synchronized**
* Not safe for concurrent use

---

## 1️⃣1️⃣ What happens if delimiter is not found?

Example:

```java
StringTokenizer st = new StringTokenizer("java", ",");
```

Result:

```
java   (entire string is one token)
```

---

## 1️⃣2️⃣ What if `nextToken()` is called when no tokens exist?

👉 Throws:

```
NoSuchElementException
```

So always use:

```java
hasMoreTokens()
```

---

## 1️⃣3️⃣ StringTokenizer vs String.split() (VERY COMMON)

| Feature        | StringTokenizer | String.split()  |
| -------------- | --------------- | --------------- |
| Status         | Legacy          | Modern          |
| Regex support  | ❌ No            | ✅ Yes           |
| Flexibility    | Low             | High            |
| Performance    | Slightly faster | Slightly slower |
| Recommendation | ❌ Avoid         | ✅ Prefer        |

---

## 1️⃣4️⃣ StringTokenizer vs Scanner

| Feature      | StringTokenizer     | Scanner              |
| ------------ | ------------------- | -------------------- |
| Regex        | ❌ No                | ✅ Yes                |
| Input source | String only         | String, file, stream |
| Speed        | Faster              | Slower               |
| Use case     | Simple tokenization | Parsing input        |

---

## 1️⃣5️⃣ Why StringTokenizer is discouraged?

* Limited functionality
* No regex support
* Hard to maintain
* Modern APIs are clearer and safer

---

## 1️⃣6️⃣ When can it still be used?

* Legacy Java codebases
* Simple delimiter-based parsing
* Interview / exam questions

---

## 🎯 Interview One-Line Summary (MEMORIZE)

> **“StringTokenizer is a legacy Java class used to split strings using delimiters, but modern Java prefers String.split() or Scanner.”**
