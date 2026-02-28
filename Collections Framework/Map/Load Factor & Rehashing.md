## 1️⃣ Definition

### Load Factor

**Load Factor** defines how full a HashMap is allowed to get before resizing.

Formula:

```
Threshold = Capacity × Load Factor
```

Default values:

* Initial Capacity = 16
* Load Factor = 0.75

---

### Rehashing

**Rehashing** is the process of:

* Increasing capacity
* Recalculating bucket positions
* Redistributing existing entries

It happens when:

```
Size > Threshold
```

---

## 2️⃣ Visual Representation

### Load Factor Calculation

```id="lf_v1"
Capacity = 16
Load Factor = 0.75

Threshold = 16 × 0.75 = 12

When size becomes 13 → Resize
```

---

### Rehashing Process

```id="lf_v2"
Old Table (16)
   |
   |-- Resize
   |
New Table (32)
   |
Recalculate index for all elements
```

---

### Index Recalculation

```id="lf_v3"
Old Index = hash & (16 - 1)
New Index = hash & (32 - 1)
```

Capacity always doubles.

---

## 3️⃣ Key Features / Properties

* Default load factor = 0.75
* Resize occurs when size exceeds threshold
* New capacity = old capacity × 2
* All elements rehashed
* Capacity always power of 2
* Rehashing is expensive operation
* Affects performance
* Helps reduce collisions

---

## 4️⃣ Syntax

Default:

```java id="lf_s1"
Map<String, Integer> map = new HashMap<>();
```

Custom capacity & load factor:

```java id="lf_s2"
Map<String, Integer> map =
    new HashMap<>(32, 0.75f);
```

---

## 5️⃣ Code Example

```java id="lf_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>(4, 0.75f);

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D"); // Resize triggered here

        System.out.println(map);
    }
}
```

Explanation:

* Capacity = 4
* Threshold = 4 × 0.75 = 3
* Adding 4th element triggers rehash

---

## 6️⃣ Use Cases

* Performance tuning
* Large-scale data storage
* Memory optimization
* Reducing collision probability
* High-performance applications
* Cache design

---

## 7️⃣ Pitfalls / Notes

* ❌ Frequent resizing reduces performance
* ❌ Low load factor wastes memory
* ❌ High load factor increases collisions
* ❌ Rehashing is costly
* ❌ Not understanding threshold logic
* ❌ Ignoring initial capacity when size known

---

## 8️⃣ Real-World Analogy

🏢 Parking Lot

* Capacity = 100 slots
* Load Factor = 75%
* When 76 cars arrive → Expand parking lot
* All cars repositioned (rehashing)

---

## 9️⃣ Best Practices

* Set initial capacity if size known
* Use default load factor (0.75) generally
* Avoid too small capacity
* Avoid too high load factor
* Optimize for performance-critical apps
* Understand memory vs speed tradeoff

---

## 🔟 Tricky Questions

1. What is load factor?
   ➜ Measure of how full HashMap can get before resizing.

2. What is default load factor?
   ➜ 0.75.

3. What is default capacity?
   ➜ 16.

4. When does resizing occur?
   ➜ When size > capacity × load factor.

5. What happens during rehashing?
   ➜ Capacity doubles and elements redistributed.

6. Why capacity is power of 2?
   ➜ Efficient index calculation using bitwise AND.

7. What is threshold formula?
   ➜ Capacity × Load Factor.

8. What is new capacity after resize?
   ➜ Double the old capacity.

9. Is rehashing expensive?
   ➜ Yes.

10. What happens if load factor is too high?
    ➜ More collisions.

11. What happens if load factor is too low?
    ➜ Wastes memory.

12. Does rehashing change hashCode?
    ➜ No, only bucket index recalculated.

13. Can we change load factor?
    ➜ Yes, in constructor.

14. Why is 0.75 default?
    ➜ Balance between performance and memory.

15. Does resizing happen automatically?
    ➜ Yes.

---

## 🧾 Quick Recap / Cheat Sheet

* Load Factor = Fill threshold
* Default = 0.75
* Default capacity = 16
* Threshold = capacity × load factor
* Resize when size exceeds threshold
* Capacity doubles
* Rehashing redistributes entries
* Expensive operation
* Capacity always power of 2
* High load factor → More collisions
* Low load factor → More memory use
* Important for performance tuning
* Common interview question
* Impacts HashMap efficiency
* Understand threshold logic clearly

---
