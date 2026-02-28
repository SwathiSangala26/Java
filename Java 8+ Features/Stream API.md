## 1️⃣ Definition

The **Stream API** (introduced in Java 8) is used to process collections of data in a **functional, declarative style**.

It allows performing operations like filtering, mapping, sorting, reducing, etc., without modifying the original data source.

A Stream is:

* Not a data structure
* A pipeline of operations
* Lazily evaluated
* Single-use

---

## 2️⃣ Visual Representation

### Stream Pipeline

```text
Collection
    ↓
Source
    ↓
Intermediate Operations
    ↓
Terminal Operation
    ↓
Result
```

---

### Example Flow

```java
list.stream()
    .filter(x -> x > 10)
    .map(x -> x * 2)
    .collect(Collectors.toList());
```

Flow:

```text
List
  ↓
Stream
  ↓
filter()
  ↓
map()
  ↓
collect()
  ↓
New List
```

---

## 3️⃣ Key Features / Properties

1. Declarative style (what, not how)
2. Supports functional programming
3. Lazy evaluation
4. Internal iteration
5. Supports parallel processing
6. Does not modify original collection
7. Can be consumed only once
8. Supports method references
9. Improves readability
10. Uses functional interfaces

---

## 4️⃣ Syntax

### Basic Structure

```java
collection.stream()
          .intermediateOperation()
          .terminalOperation();
```

---

### General Pattern

```text
source → intermediate → intermediate → terminal
```

---

## 5️⃣ Code Example

### Filtering Example

```java
List<Integer> list = Arrays.asList(5, 12, 7, 20);

List<Integer> result = list.stream()
                            .filter(x -> x > 10)
                            .collect(Collectors.toList());
```

---

### Mapping Example

```java
List<String> names = Arrays.asList("a", "b", "c");

List<String> upper = names.stream()
                           .map(String::toUpperCase)
                           .collect(Collectors.toList());
```

---

### Reduce Example

```java
int sum = list.stream()
              .reduce(0, (a, b) -> a + b);
```

---

## 6️⃣ Types of Stream Operations

---

### 🔹 1️⃣ Intermediate Operations (Lazy)

* filter()
* map()
* flatMap()
* sorted()
* distinct()
* limit()
* skip()
* peek()

They return a Stream.

---

### 🔹 2️⃣ Terminal Operations

* collect()
* forEach()
* reduce()
* count()
* anyMatch()
* allMatch()
* noneMatch()
* findFirst()
* findAny()

They produce result or side-effect.

---

## 7️⃣ Use Cases

1. Filtering collections
2. Data transformation
3. Aggregation (sum, average)
4. Sorting data
5. Removing duplicates
6. Parallel processing
7. Complex query-like operations
8. Mapping objects
9. Grouping data

---

## 8️⃣ Pitfalls / Notes

1. Streams cannot be reused
2. Terminal operation is mandatory
3. Intermediate operations are lazy
4. Avoid modifying shared state in parallel streams
5. Not suitable for small trivial loops
6. `forEach()` is not guaranteed order in parallel
7. Be careful with infinite streams
8. Prefer `collect()` over `forEach()` for mutation
9. Parallel stream may reduce performance in small datasets

---

## 9️⃣ Real-World Analogy

Think of Stream like a **water pipeline**.

```text
Water Source
   ↓
Filter
   ↓
Heater
   ↓
Output Tap
```

Until you open the tap (terminal operation),
water doesn't flow (lazy execution).

---

## 🔟 Best Practices

1. Keep pipeline readable
2. Avoid side effects
3. Use method references
4. Prefer primitive streams (`IntStream`, etc.)
5. Use parallel only when needed
6. Use `Collectors` effectively
7. Avoid complex nested streams
8. Use `Optional` safely
9. Close streams if created from I/O
10. Do not modify source inside stream

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ What is Stream?

A sequence of elements supporting functional operations.

---

### 2️⃣ Is Stream a data structure?

No.

---

### 3️⃣ What happens if no terminal operation is used?

Nothing executes (lazy).

---

### 4️⃣ Can a Stream be reused?

No. It throws `IllegalStateException`.

---

### 5️⃣ Difference between map() and flatMap()?

* map → one-to-one transformation
* flatMap → one-to-many flattening

---

### 6️⃣ What is lazy evaluation?

Intermediate operations execute only when terminal operation is invoked.

---

### 7️⃣ Difference between forEach() and collect()?

* forEach → side effects
* collect → accumulates result

---

### 8️⃣ What is parallelStream()?

Stream that runs operations concurrently using ForkJoinPool.

---

### 9️⃣ Is Stream thread-safe?

Sequential stream → yes
Parallel → depends on operations

---

### 🔟 What happens if we modify collection during streaming?

May throw `ConcurrentModificationException`.

---

### 1️⃣1️⃣ Difference between findFirst() and findAny()?

* findFirst → ordered
* findAny → may return any element (optimized for parallel)

---

### 1️⃣2️⃣ What is short-circuiting operation?

Stops processing early.
Example: `anyMatch()`, `findFirst()`.

---

### 1️⃣3️⃣ What is reduce()?

Combines elements into single result.

---

### 1️⃣4️⃣ What is peek() used for?

Debugging (intermediate side-effect).

---

### 1️⃣5️⃣ What is infinite stream?

Stream without finite size.

Example:

```java
Stream.generate(Math::random);
```

---

### 1️⃣6️⃣ Can streams handle checked exceptions?

Must handle inside lambda.

---

### 1️⃣7️⃣ What is Collector?

Utility to transform stream result (e.g., list, set, map).

---

### 1️⃣8️⃣ Is Stream faster than loop?

Not always. Depends on use case.

---

### 1️⃣9️⃣ What is internal iteration?

Stream controls iteration.

---

### 2️⃣0️⃣ Can we break from stream?

No direct break. Use short-circuiting operations.

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8
* Declarative processing
* Lazy evaluation
* Single-use
* Pipeline model
* Intermediate → Terminal
* Does not modify source
* Supports parallel processing
* Uses functional interfaces
* Avoid side effects
* Prefer collect over forEach
* Primitive streams improve performance

---
