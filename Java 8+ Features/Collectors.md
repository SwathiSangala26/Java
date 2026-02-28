## 1️⃣ Definition

**Collectors** is a utility class (`java.util.stream.Collectors`) that provides implementations of the `Collector` interface.

It is mainly used as a **terminal operation** in Stream API to transform stream elements into a final result such as:

* List
* Set
* Map
* Grouped data
* Joined string
* Statistical summary

---

## 2️⃣ Visual Representation

### Stream + Collector Flow

```text
Stream
   ↓
collect()
   ↓
Collector Logic
   ↓
Final Result (List / Map / String / etc.)
```

---

### Collector Internal Mechanism

```text
Supplier → Accumulator → Combiner → Finisher
```

Explanation:

```text
Supplier     → creates container
Accumulator  → adds element
Combiner     → merges containers (parallel)
Finisher     → transforms result
```

---

## 3️⃣ Key Features / Properties

1. Used with `collect()` terminal operation
2. Transforms stream into mutable result container
3. Supports parallel streams
4. Provides built-in implementations
5. Can create custom collectors
6. Handles grouping and partitioning
7. Supports downstream collectors
8. Efficient for large datasets
9. Uses reduction internally
10. Not lazy (terminal operation)

---

## 4️⃣ Syntax

### Basic Usage

```java
stream.collect(Collectors.method());
```

---

### General Pattern

```text
Stream → collect(Collector)
```

---

## 5️⃣ Code Examples

---

### 🔹 Collect to List

```java
List<String> list = names.stream()
                          .collect(Collectors.toList());
```

---

### 🔹 Collect to Set

```java
Set<String> set = names.stream()
                        .collect(Collectors.toSet());
```

---

### 🔹 Collect to Map

```java
Map<Integer, String> map = names.stream()
    .collect(Collectors.toMap(
        String::length,
        name -> name
    ));
```

---

### 🔹 Joining

```java
String result = names.stream()
                     .collect(Collectors.joining(", "));
```

---

### 🔹 Grouping By

```java
Map<Integer, List<String>> grouped =
    names.stream()
         .collect(Collectors.groupingBy(String::length));
```

---

### 🔹 Partitioning

```java
Map<Boolean, List<Integer>> partition =
    numbers.stream()
           .collect(Collectors.partitioningBy(n -> n > 10));
```

---

### 🔹 Counting

```java
long count = names.stream()
                  .collect(Collectors.counting());
```

---

### 🔹 Summarizing

```java
IntSummaryStatistics stats =
    numbers.stream()
           .collect(Collectors.summarizingInt(Integer::intValue));
```

---

## 6️⃣ Important Collector Methods

* toList()
* toSet()
* toMap()
* groupingBy()
* partitioningBy()
* joining()
* counting()
* mapping()
* collectingAndThen()
* summarizingInt()
* averagingInt()
* reducing()

---

## 7️⃣ Use Cases

1. Convert stream to collection
2. Create Map from objects
3. Group objects
4. Partition data
5. Aggregate results
6. Perform statistical calculations
7. Transform results after collection
8. Nested grouping
9. Complex data transformations

---

## 8️⃣ Pitfalls / Notes

1. `toMap()` throws exception on duplicate keys
2. Must provide merge function if duplicates possible
3. `toList()` does not guarantee specific list type
4. Parallel streams use combiner
5. groupingBy() returns HashMap by default
6. Use groupingByConcurrent() for parallel
7. Avoid mutable shared state
8. Finisher may convert result
9. collectingAndThen() makes result immutable

---

### Duplicate Key Problem Example

```java
Collectors.toMap(
    String::length,
    name -> name
);
```

If two strings have same length →
`IllegalStateException`

Correct way:

```java
Collectors.toMap(
    String::length,
    name -> name,
    (existing, replacement) -> existing
);
```

---

## 9️⃣ Real-World Analogy

Think of Collectors like a **packing system**.

```text
Items (Stream)
   ↓
Packing Strategy (Collector)
   ↓
Packed Boxes (Final Result)
```

Different strategies:

* Box into list
* Sort into groups
* Separate into two sections
* Merge into single string

---

## 🔟 Best Practices

1. Handle duplicate keys in toMap()
2. Use method references for readability
3. Prefer groupingBy over manual loops
4. Use summarizing methods for statistics
5. Avoid unnecessary collect()
6. Use downstream collectors
7. Use collectingAndThen() for immutability
8. Keep collector readable
9. Prefer built-in collectors
10. Avoid complex nested collectors

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ What is Collectors class?

Utility class providing common Collector implementations.

---

### 2️⃣ What does collect() do?

Performs mutable reduction operation.

---

### 3️⃣ Difference between reduce() and collect()?

* reduce() → immutable reduction
* collect() → mutable container reduction

---

### 4️⃣ Why does toMap() throw exception?

Duplicate keys without merge function.

---

### 5️⃣ What is downstream collector?

Collector used inside groupingBy.

Example:

```java
Collectors.groupingBy(
    String::length,
    Collectors.counting()
);
```

---

### 6️⃣ What is collectingAndThen()?

Applies finishing transformation.

---

### 7️⃣ What happens in parallel stream during collect()?

Combiner merges partial results.

---

### 8️⃣ Difference between groupingBy() and partitioningBy()?

* groupingBy → multiple groups
* partitioningBy → only 2 groups (true/false)

---

### 9️⃣ Does toList() return ArrayList?

Not guaranteed.

---

### 🔟 What is summarizingInt()?

Returns statistical summary (count, sum, min, max, average).

---

### 1️⃣1️⃣ Is Collector thread-safe?

Depends on implementation.

---

### 1️⃣2️⃣ Can we create custom Collector?

Yes, by implementing Collector interface.

---

### 1️⃣3️⃣ What is merge function in toMap()?

Handles duplicate keys.

---

### 1️⃣4️⃣ What is identity in reducing()?

Initial value for accumulation.

---

### 1️⃣5️⃣ Can collect() work without terminal operation?

No. collect() itself is terminal.

---

### 1️⃣6️⃣ What is difference between mapping() and map()?

* map() → intermediate
* mapping() → downstream collector

---

### 1️⃣7️⃣ What is groupingByConcurrent()?

Concurrent version for parallel streams.

---

### 1️⃣8️⃣ When should we avoid Collectors?

When simple loop is clearer or more efficient.

---

### 1️⃣9️⃣ What is combiner used for?

Merging partial results in parallel streams.

---

### 2️⃣0️⃣ What is finisher function?

Transforms accumulated result into final form.

---

# 🧾 Quick Recap / Cheat Sheet

* Used with collect()
* Performs mutable reduction
* Converts stream into List, Set, Map, etc.
* Handles grouping & partitioning
* toMap() needs merge function for duplicates
* Supports downstream collectors
* Works with parallel streams
* groupingBy → multi groups
* partitioningBy → 2 groups
* summarizing methods provide statistics
* collectingAndThen() transforms result
* Combiner used in parallel

---
