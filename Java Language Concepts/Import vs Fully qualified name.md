## What is an Import?

An **import** tells the **compiler** where a class is located so you can use the class **by its simple name**.

### Example

```java
import java.util.ArrayList;

public class Test {
    ArrayList list = new ArrayList();
}
```

Here:

* `ArrayList` is used without package name
* Compiler knows it belongs to `java.util`

📌 Import is a **compile-time feature**

---

## What is a Fully Qualified Name (FQN)?

A **fully qualified name** includes the **complete package path + class name**.

### Example

```java
public class Test {
    java.util.ArrayList list = new java.util.ArrayList();
}
```

Here:

* No `import` statement is used
* Class is referenced with its full name

---

## Key Difference (Side-by-Side)

| Import                        | Fully Qualified Name               |
| ----------------------------- | ---------------------------------- |
| Allows using short class name | Requires full package + class name |
| Improves readability          | Reduces readability                |
| Used at top of file           | Used at point of usage             |
| Compile-time only             | Compile-time only                  |
| Common in real projects       | Rare, used selectively             |

---

## When Import is Preferred

Use **import** when:

* Class is used multiple times
* Code readability matters
* There is no name conflict

### Example

```java
import java.util.List;

List list = new ArrayList();
```

---

## When Fully Qualified Name is Preferred

Use **fully qualified name** when:

* Two classes have the same name
* You want to avoid ambiguity
* You want to avoid imports

### Example (Name conflict)

```java
java.util.Date utilDate;
java.sql.Date sqlDate;
```

Here:

* Importing both would cause ambiguity
* FQN clearly specifies which class is used

---

## Can Import and Fully Qualified Name Be Used Together?

Yes, but **not for the same class**.

❌ Invalid:

```java
import java.util.ArrayList;

java.util.ArrayList list = new java.util.ArrayList(); // unnecessary
```

✔ Valid but redundant.

---

## Does Import Load the Class?

❌ No
✔ Import only helps the **compiler resolve names**

Class loading happens at **runtime**, handled by the JVM.

---

## Does Fully Qualified Name Affect Performance?

❌ No
✔ Both result in the **same bytecode**

The compiler resolves everything before runtime.

---

## Special Case: `java.lang`

Classes in `java.lang` can be used:

* Without import
* Without fully qualified name

Example:

```java
String s = "Hello";
```

---

## One-Line Interview Summary

* **Import** lets you use a class by its short name.
* **Fully qualified name** uses the complete package path.
* Both are resolved at compile time and have no runtime impact.
