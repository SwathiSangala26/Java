## 1️⃣ Definition

`Optional` is a container object introduced in **Java 8** to represent a value that **may or may not be present**.

It helps avoid **NullPointerException (NPE)** by forcing explicit handling of missing values.

Package:

```java
java.util.Optional
```

---

## 2️⃣ Visual Representation

### Without Optional (Traditional Null)

```text
Value
  ↓
null
  ↓
NPE risk
```

---

### With Optional

```text
Optional
   ↓
  ┌─────────────┐
  │  Value      │  → Present
  │  OR         │
  │  Empty      │  → Absent
  └─────────────┘
```

---

### Internal Concept

```text
Optional
   ↓
value != null  → Present
value == null  → Empty
```

---

## 3️⃣ Key Features / Properties

1. Avoids null checks
2. Encourages functional style
3. Immutable
4. Final class
5. Not serializable (avoid in entity fields)
6. Provides safe value retrieval
7. Supports chaining
8. Designed mainly for return types
9. Works well with Stream API
10. Throws exception if misused (`get()` on empty)

---

## 4️⃣ Syntax

### Creating Optional

```java
Optional.of(value);         // value must NOT be null
Optional.ofNullable(value); // value may be null
Optional.empty();           // empty Optional
```

---

### Checking Value

```java
optional.isPresent();
optional.isEmpty(); // Java 11+
```

---

### Getting Value

```java
optional.get();  // risky
optional.orElse(defaultValue);
optional.orElseGet(() -> value);
optional.orElseThrow();
```

---

## 5️⃣ Code Examples

---

### 🔹 Creating Optional

```java
Optional<String> name = Optional.of("Swathi");
```

---

### 🔹 Nullable Value

```java
Optional<String> name = Optional.ofNullable(null);
```

---

### 🔹 Safe Retrieval

```java
String result = name.orElse("Default");
```

---

### 🔹 Using ifPresent

```java
name.ifPresent(n -> System.out.println(n));
```

---

### 🔹 Using map()

```java
Optional<String> upper = name.map(String::toUpperCase);
```

---

### 🔹 Using flatMap()

```java
Optional<String> result =
    name.flatMap(n -> Optional.of(n.toUpperCase()));
```

---

### 🔹 Throwing Exception

```java
String value = name.orElseThrow(
    () -> new RuntimeException("Value missing")
);
```

---

## 6️⃣ Important Methods

* of()
* ofNullable()
* empty()
* isPresent()
* isEmpty()
* get()
* orElse()
* orElseGet()
* orElseThrow()
* ifPresent()
* map()
* flatMap()
* filter()
* stream() (Java 9+)

---

## 7️⃣ Use Cases

1. Method return types
2. Avoiding NPE
3. Functional chaining
4. Stream integration
5. Repository lookups
6. Optional configuration values
7. Nested object access
8. API design clarity

---

## 8️⃣ Pitfalls / Notes

1. Do NOT use Optional as:

   * Field in entity
   * Method parameter
2. Avoid calling `get()` directly
3. `orElse()` always evaluates argument
4. `orElseGet()` is lazy
5. Optional is not a replacement for all nulls
6. Avoid nested Optional<Optional<T>>
7. Optional should not be used for serialization
8. Avoid storing Optional in collections
9. Prefer functional methods over isPresent()+get()
10. Optional is not meant for performance-critical code

---

### ⚠️ Important Difference

```java
optional.orElse(expensiveMethod());
```

`expensiveMethod()` ALWAYS executes.

---

```java
optional.orElseGet(() -> expensiveMethod());
```

Executes ONLY if empty.

---

## 9️⃣ Real-World Analogy

Think of Optional like a **sealed box**.

```text
Box
  ↓
May contain item
OR
May be empty
```

Instead of blindly assuming something is inside and getting hurt (NPE),
you check properly before using it.

---

## 🔟 Best Practices

1. Use Optional only as return type
2. Prefer orElseGet() over orElse()
3. Avoid get()
4. Use map/flatMap chaining
5. Avoid null inside Optional
6. Don’t use in DTOs/entities
7. Use filter() for validation
8. Use ifPresentOrElse() (Java 9+)
9. Keep logic readable
10. Avoid overusing Optional

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ What is Optional?

A container that may or may not contain a value.

---

### 2️⃣ Why was Optional introduced?

To reduce NullPointerException.

---

### 3️⃣ Difference between of() and ofNullable()?

* of() → throws NPE if null
* ofNullable() → returns empty Optional

---

### 4️⃣ What happens if we call get() on empty Optional?

Throws `NoSuchElementException`.

---

### 5️⃣ Difference between orElse() and orElseGet()?

* orElse → eager
* orElseGet → lazy

---

### 6️⃣ Can Optional hold null?

No. If null passed via ofNullable → becomes empty.

---

### 7️⃣ Is Optional serializable?

No.

---

### 8️⃣ Should Optional be used as field?

No. Designed mainly for return types.

---

### 9️⃣ What does map() do in Optional?

Transforms value if present.

---

### 🔟 What does flatMap() do?

Avoids nested Optional.

---

### 1️⃣1️⃣ What is filter() in Optional?

Keeps value only if condition true.

---

### 1️⃣2️⃣ What is ifPresent()?

Executes lambda if value present.

---

### 1️⃣3️⃣ What is ifPresentOrElse()?

Executes one action if present, another if empty.

---

### 1️⃣4️⃣ What is Optional.stream()?

Converts Optional to Stream (Java 9+).

---

### 1️⃣5️⃣ What happens internally in Optional?

Wraps value in final object; no special magic.

---

### 1️⃣6️⃣ Is Optional thread-safe?

Yes (immutable).

---

### 1️⃣7️⃣ Can Optional prevent all NPE?

No. Only helps in API design.

---

### 1️⃣8️⃣ What is wrong with:

```java
if(optional.isPresent()){
    optional.get();
}
```

Defeats functional style; prefer map/orElse.

---

### 1️⃣9️⃣ Can we compare Optional with null?

Should not. Use isPresent()/isEmpty().

---

### 2️⃣0️⃣ Is Optional better than null in performance?

No. Slight overhead due to object wrapper.

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8
* Avoids NullPointerException
* Use as return type
* of() → non-null only
* ofNullable() → null allowed
* empty() → no value
* get() risky
* orElse() eager
* orElseGet() lazy
* map() transforms
* flatMap() avoids nested Optional
* filter() conditional keep
* Immutable & final
* Not serializable
* Do not use as field or parameter

---
