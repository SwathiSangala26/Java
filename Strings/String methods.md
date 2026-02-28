## 1️⃣ Definition

String methods are **built-in functions** of the `java.lang.String` class used to:

* Manipulate text
* Compare strings
* Extract substrings
* Convert case
* Perform searching and replacement

Since String is **immutable**, every method that modifies content returns a **new String object**.

---

## 2️⃣ Visual Representation (Immutability Effect)

Example:

```java
String s = "Java";
s.toUpperCase();
```

Memory:

```
Before:

SCP
 ┌───────────────┐
 │   "Java"      │ ← s
 └───────────────┘

After toUpperCase():

SCP
 ┌───────────────┐
 │   "Java"      │
 └───────────────┘

 ┌───────────────┐
 │   "JAVA"      │  (new object created)
 └───────────────┘
```

If not reassigned → original remains unchanged.

---

# 3️⃣ Key Categories of String Methods

---

## 🔹 A) Length & Character Access

### 1. `length()`

```java
String s = "Java";
s.length();   // 4
```

Returns number of characters.

---

### 2. `charAt(int index)`

```java
s.charAt(1);  // 'a'
```

Returns character at given index.

⚠ Index starts from 0
⚠ Throws `StringIndexOutOfBoundsException`

---

## 🔹 B) Comparison Methods

### 3. `equals()`

Content comparison.

---

### 4. `equalsIgnoreCase()`

Ignores case while comparing.

---

### 5. `compareTo()`

Lexicographical comparison.

```java
"abc".compareTo("abd");  // negative value
```

Returns:

* 0 → equal
* negative → smaller
* positive → greater

---

## 🔹 C) Searching Methods

### 6. `contains()`

```java
"Java Programming".contains("Java"); // true
```

---

### 7. `indexOf()`

```java
"Java".indexOf("a");  // 1
```

Returns first occurrence index.

---

### 8. `lastIndexOf()`

Returns last occurrence index.

---

## 🔹 D) Substring Methods

### 9. `substring(int beginIndex)`

```java
"Java".substring(2);  // "va"
```

---

### 10. `substring(int begin, int end)`

```java
"Java".substring(1,3); // "av"
```

End index excluded.

---

## 🔹 E) Modification Methods (Return New Object)

### 11. `concat()`

```java
"Java".concat(" 8"); // "Java 8"
```

---

### 12. `replace()`

```java
"Java".replace('a','o'); // "Jovo"
```

---

### 13. `toUpperCase()`

---

### 14. `toLowerCase()`

---

### 15. `trim()`

Removes leading and trailing spaces.

---

## 🔹 F) Splitting & Conversion

### 16. `split()`

```java
String s = "a,b,c";
String[] arr = s.split(",");
```

Returns array.

---

### 17. `valueOf()`

Converts primitive to String.

```java
String.valueOf(10); // "10"
```

---

### 18. `isEmpty()`

```java
"".isEmpty(); // true
```

---

### 19. `startsWith()`

---

### 20. `endsWith()`

---

# 4️⃣ Code Example

```java
public class Test {
    public static void main(String[] args) {

        String s = "  Java Programming  ";

        System.out.println(s.length());
        System.out.println(s.trim());
        System.out.println(s.toUpperCase());
        System.out.println(s.substring(2,6));
        System.out.println(s.contains("Java"));
    }
}
```

---

# 5️⃣ Use Cases

* Input validation
* Parsing data
* Splitting CSV values
* Checking prefixes (URL, file type)
* Data formatting
* Searching text
* Case-insensitive comparison

---

# 6️⃣ Pitfalls / Notes

⚠ String is immutable → always reassign
⚠ substring end index excluded
⚠ charAt() may throw exception
⚠ equals() vs == confusion
⚠ split() uses regex
⚠ compareTo() returns int, not boolean

---

# 7️⃣ Real-World Analogy

Think of String like:

📜 A printed document.

Methods like:

* replace()
* trim()
* toUpperCase()

are like making **a photocopy with changes** —
Original document remains untouched.

---

# 8️⃣ Best Practices

✔ Use equals() for comparison
✔ Use StringBuilder for heavy concatenation
✔ Validate null before calling methods
✔ Use trim() before validation
✔ Use contains() for substring check
✔ Use startsWith() for prefix checking

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What will be output?

```java
String s = "Java";
s.toUpperCase();
System.out.println(s);
```

Answer: Java
(Immutable — no reassignment)

---

### 2️⃣ What happens here?

```java
String s = "";
System.out.println(s.isEmpty());
```

Answer: true

---

### 3️⃣ Difference between isEmpty() and length()?

* isEmpty() → checks length == 0
* length() → returns actual size

---

### 4️⃣ What does compareTo() return?

An integer based on lexicographical difference.

---

### 5️⃣ What is returned by split()?

String array.

---

### 6️⃣ Why does replace() not modify original?

Because String is immutable.

---

### 7️⃣ What exception can charAt() throw?

`StringIndexOutOfBoundsException`

---

# 🧾 Quick Recap / Cheat Sheet

* String methods return new object
* length() → size
* charAt() → character access
* equals() → content compare
* compareTo() → lexicographic compare
* substring() → extract part
* contains(), indexOf() → search
* replace(), trim(), concat() → modify
* split() → returns array
* String is immutable → reassign result

---
