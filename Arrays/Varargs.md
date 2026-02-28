## 1️⃣ Definition

**Varargs (Variable Arguments)** allow a method to accept **zero or more arguments** of the same type.

Instead of passing an array manually, Java automatically converts multiple arguments into an array.

Syntax uses:

```java
...
```

So internally:

> Varargs = Array

---

## 2️⃣ Visual Representation

### Without Varargs

```java
sum(new int[]{10, 20, 30});
```

---

### With Varargs

```java
sum(10, 20, 30);
```

Internally Java converts this to:

```text
sum(int... nums)

Call → sum(10,20,30)
            |
            v
nums → [10, 20, 30]
```

So `nums` behaves like an array.

---

## 3️⃣ Key Features / Properties

✔ Allows multiple arguments
✔ Treated as an array inside method
✔ Can accept 0 arguments
✔ Must be last parameter in method
✔ Only one varargs parameter allowed
✔ Improves readability

---

## 4️⃣ Syntax

```java
returnType methodName(dataType... variableName)
```

Example:

```java
void display(int... numbers)
```

Important rule:

✔ Varargs must be last parameter

Correct:

```java
void test(String name, int... marks)
```

Wrong:

```java
void test(int... marks, String name)  // Compilation Error
```

---

## 5️⃣ Code Example

```java
public class Main {

    public static int sum(int... numbers) {
        int total = 0;
        for(int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {

        System.out.println(sum(10, 20));
        System.out.println(sum(1,2,3,4));
        System.out.println(sum());   // zero arguments
    }
}
```

Output:

```
30
10
0
```

---

## 6️⃣ Use Cases

✔ Utility methods (sum, max, min)
✔ Logging methods
✔ Print methods
✔ Framework APIs
✔ Reducing method overloading

Example without varargs:

```java
sum(int a, int b)
sum(int a, int b, int c)
sum(int a, int b, int c, int d)
```

Varargs removes this repetition.

---

## 7️⃣ Pitfalls / Notes

⚠ Internally treated as array

So this works:

```java
numbers.length
numbers[0]
```

---

⚠ Only one varargs allowed

❌ Wrong:

```java
void test(int... a, int... b) // Error
```

---

⚠ Ambiguity with overloading

Example:

```java
void test(int a)
void test(int... a)
```

Call:

```java
test(5);
```

✔ Calls `test(int a)`
Because exact match has higher priority.

---

⚠ Null handling

```java
sum(null);
```

This can cause ambiguity or NullPointerException depending on context.

---

## 8️⃣ Real-World Analogy

Think of it like:

🛍 A shopping bag

Instead of specifying how many items you bring,
you just put however many you want into one bag.

That bag = varargs array.

---

## 9️⃣ Best Practices

✔ Use varargs when number of inputs unknown
✔ Keep varargs as last parameter
✔ Avoid overloading that causes ambiguity
✔ Use enhanced for-loop for traversal
✔ Don’t overuse for performance-critical code

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ Is varargs stored as array?

✔ Yes
Internally converted to array.

---

### 2️⃣ Can we pass array directly?

✔ Yes

```java
int[] arr = {1,2,3};
sum(arr);
```

---

### 3️⃣ Can we have two varargs in one method?

❌ No

---

### 4️⃣ What is output?

```java
static void test(int... a) {
    System.out.println(a.length);
}

test();
```

✔ Output: 0

---

### 5️⃣ What happens here?

```java
static void test(int a, int... b) {
    System.out.println(b.length);
}

test(5);
```

✔ Output: 0
(b receives empty array)

---

### 6️⃣ Which method is called?

```java
void test(int a)
void test(int... a)

test(10);
```

✔ `test(int a)`
Exact match preferred.

---

### 7️⃣ Can varargs be used with other parameters?

✔ Yes, but must be last.

---

### 8️⃣ What is time complexity?

✔ Depends on logic inside method
Varargs itself adds small overhead for array creation.

---

# 🧾 Quick Recap / Cheat Sheet

✔ Varargs = variable arguments
✔ Syntax → type... name
✔ Internally treated as array
✔ Can accept 0 or more arguments
✔ Must be last parameter
✔ Only one varargs allowed
✔ Exact method match preferred over varargs
✔ Improves readability

---
