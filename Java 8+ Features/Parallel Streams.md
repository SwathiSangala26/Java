# 1️⃣ Definition

A **Parallel Stream** is a type of stream that allows processing elements **concurrently** using multiple threads.

It internally uses the **ForkJoinPool (common pool)** to split data into multiple chunks and process them in parallel.

Introduced in Java 8 as part of Stream API.

---

# 2️⃣ Visual Representation

---

### Sequential Stream

```text
Data → [T1] → Result
```

Single thread processes entire data.

---

### Parallel Stream

```text
Data
  ↓
Split into chunks
  ↓
[T1]  [T2]  [T3]  [T4]
  ↓     ↓     ↓     ↓
Partial Results
  ↓
Combine
  ↓
Final Result
```

---

### Internal Flow (ForkJoin Model)

```text
Data
  ↓
Fork (split tasks)
  ↓
Process in parallel
  ↓
Join (merge results)
```

---

# 3️⃣ Key Features / Properties

1. Uses multiple CPU cores
2. Uses ForkJoinPool.commonPool()
3. Automatic data splitting
4. Supports parallel reduction
5. Non-deterministic order (unless ordered)
6. Not always faster
7. Requires stateless operations
8. Works best with large datasets
9. Combiner used in reduction
10. Supports concurrent collectors

---

# 4️⃣ Syntax

---

### Creating Parallel Stream

```java
collection.parallelStream();
```

OR

```java
collection.stream().parallel();
```

---

### Converting Back to Sequential

```java
stream.sequential();
```

---

# 5️⃣ Code Examples

---

### 🔹 Basic Example

```java
List<Integer> list = Arrays.asList(1,2,3,4,5);

list.parallelStream()
    .forEach(System.out::println);
```

---

### 🔹 Parallel Sum

```java
int sum = list.parallelStream()
              .reduce(0, Integer::sum);
```

---

### 🔹 Ordered Output

```java
list.parallelStream()
    .forEachOrdered(System.out::println);
```

---

### 🔹 Parallel with Collect

```java
List<Integer> result =
    list.parallelStream()
        .filter(x -> x > 2)
        .collect(Collectors.toList());
```

---

# 6️⃣ When to Use Parallel Streams

1. Large datasets
2. CPU-intensive operations
3. Stateless operations
4. Independent tasks
5. Multi-core systems
6. Complex reductions
7. Data processing pipelines
8. Performance optimization scenarios

---

# 7️⃣ When NOT to Use

1. Small collections
2. I/O operations
3. Shared mutable state
4. Order-dependent logic
5. Database operations
6. High synchronization cost
7. Lightweight operations
8. Performance-critical microservices

---

# 8️⃣ Important Concepts

---

### 🔹 Stateless vs Stateful

Parallel operations must be **stateless**.

Bad:

```java
List<Integer> result = new ArrayList<>();

list.parallelStream()
    .forEach(result::add);   // Unsafe
```

Why?

```text
Multiple threads modifying same object
→ Race Condition
```

---

### 🔹 Associativity Requirement

For parallel reduce:

Operation must be:

```text
Associative
```

Example:

```java
(a + b) + c == a + (b + c)
```

If not associative → incorrect result.

---

### 🔹 Ordering

Parallel stream may not preserve order unless:

```java
forEachOrdered()
```

---

# 9️⃣ Real-World Analogy

Sequential:

```text
1 worker builds entire house.
```

Parallel:

```text
Team of workers build different parts simultaneously,
then combine results.
```

But if workers interfere → chaos.

---

# 🔟 Best Practices

1. Measure performance before using
2. Avoid shared mutable state
3. Prefer reduce()/collect()
4. Use concurrent collectors if needed
5. Ensure operations are stateless
6. Ensure reduction is associative
7. Avoid blocking calls
8. Avoid nested parallel streams
9. Use primitive streams (IntStream, etc.)
10. Keep pipeline simple

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ What is parallelStream()?

A stream that processes elements concurrently.

---

### 2️⃣ Which pool is used internally?

ForkJoinPool.commonPool()

---

### 3️⃣ Is parallel stream always faster?

No.

---

### 4️⃣ What happens if we use shared mutable object?

Race condition.

---

### 5️⃣ What is associative operation?

Operation where grouping doesn't change result.

---

### 6️⃣ Difference between forEach() and forEachOrdered()?

* forEach → no order guarantee
* forEachOrdered → maintains order

---

### 7️⃣ What is combiner in parallel stream?

Merges partial results.

---

### 8️⃣ Can we control number of threads?

Not directly (uses common pool). Can override using custom ForkJoinPool.

---

### 9️⃣ What happens if reduce operation is not associative?

Incorrect results.

---

### 🔟 Does parallel stream maintain encounter order?

Only if ordered terminal operation used.

---

### 1️⃣1️⃣ Is parallel stream thread-safe?

Only if operations are stateless and safe.

---

### 1️⃣2️⃣ Can we use parallel stream inside web applications?

Yes, but careful with thread pool usage.

---

### 1️⃣3️⃣ Why nested parallel streams are bad?

Thread starvation and performance degradation.

---

### 1️⃣4️⃣ What is splitting mechanism?

Spliterator divides data into chunks.

---

### 1️⃣5️⃣ Is collect() safe in parallel?

Yes, if collector supports parallel combination.

---

### 1️⃣6️⃣ Why reduce(identity, accumulator) needs identity?

To start partial reductions correctly.

---

### 1️⃣7️⃣ What happens in parallel filter?

Each chunk filters independently.

---

### 1️⃣8️⃣ Does parallel stream help in I/O tasks?

No. It is CPU-optimized.

---

### 1️⃣9️⃣ What is side-effect in stream?

Modifying external state inside lambda.

---

### 2️⃣0️⃣ How to force sequential execution?

Use `.sequential()`.

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8
* Uses ForkJoinPool
* Splits data automatically
* Best for CPU-heavy large data
* Avoid shared mutable state
* Use associative operations
* Not always faster
* Order not guaranteed
* forEachOrdered() preserves order
* Avoid nested parallel streams
* Measure performance first
* Combiner merges results

---
