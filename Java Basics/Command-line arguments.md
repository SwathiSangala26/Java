# 1️⃣ Definition

**Command-line arguments** are values passed to a Java program at the time of execution through the command prompt.

They are received in the `main` method as:

```java
public static void main(String[] args)
```

Here:

* `args` is an array of `String`
* It stores all inputs given from command line
* Each value is separated by space

---

# 2️⃣ Visual Representation

---

### 🔹 Program Execution

```text
Command Prompt
--------------
java Test 10 Swathi true
```

---

### 🔹 How It Enters main()

```text
main(String[] args)

args[0] → "10"
args[1] → "Swathi"
args[2] → "true"
```

Memory View:

```text
Stack
-----------------
args ─────► [ "10", "Swathi", "true" ]
```

✔ Stored as String array
✔ Always String type

---

# 3️⃣ Key Features / Properties

* Passed at runtime
* Stored in `String[] args`
* Space-separated inputs
* Index starts from 0
* Length determined by number of inputs
* Must convert manually for numeric use

---

# 4️⃣ Syntax

### Basic Structure

```java
public class Test {
    public static void main(String[] args) {
        // logic here
    }
}
```

---

# 5️⃣ Code Example

---

## 🔹 Printing Arguments

```java
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
```

Run:

```text
javac Test.java
java Test 10 Swathi true
```

Output:

```text
10
Swathi
true
```

---

## 🔹 Converting to int

```java
public class Test {
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        System.out.println(num + 10);
    }
}
```

Run:

```text
java Test 20
```

Output:

```text
30
```

✔ Because args are String → must parse

---

# 6️⃣ Use Cases

* Passing configuration values
* Running programs with dynamic input
* Batch processing
* Testing programs with different inputs

---

# 7️⃣ Pitfalls / Notes (Very Important)

---

### ⚠ 1. Always String Type

Even numbers are stored as String.

```java
int x = args[0];  // Compile error
```

✔ Must convert using parseInt()

---

### ⚠ 2. ArrayIndexOutOfBoundsException

```java
System.out.println(args[0]);
```

If no arguments passed → Runtime error.

---

### ⚠ 3. NumberFormatException

```java
int x = Integer.parseInt("abc");
```

Invalid numeric conversion → Runtime error.

---

### ⚠ 4. args Can Be Renamed

```java
public static void main(String[] swathi)
```

✔ Name doesn’t matter
✔ Signature must match type

---

### ⚠ 5. Multiple Inputs

```text
java Test 10 20 30
```

Length:

```java
args.length == 3
```

---

# 8️⃣ Real-World Analogy

Think of command-line arguments like giving instructions to a delivery person:

"Deliver package to House 12 at 5PM"

The delivery person (program) receives those details at runtime.

---

# 9️⃣ Best Practices

✔ Always check args.length before accessing
✔ Handle NumberFormatException
✔ Validate input properly
✔ Use meaningful parsing

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. What is type of args in main method?

String array (String[]).

---

### ❓ 2. Can we change args name?

Yes.

---

### ❓ 3. Can main method run without command-line arguments?

Yes. args.length will be 0.

---

### ❓ 4. What happens if no arguments passed and we access args[0]?

ArrayIndexOutOfBoundsException.

---

### ❓ 5. Can we pass space inside argument?

Yes, but must use quotes.

Example:

```text
java Test "Hello World"
```

---

### ❓ 6. Why is args String[] and not int[]?

Because command-line input is received as text.

---

### ❓ 7. Is args stored in heap or stack?

Array object in heap, reference in stack (like other reference types).

---

# 🧾 Quick Recap / Cheat Sheet

```text
Command-Line Arguments
----------------------

• Passed at runtime
• Stored in String[] args
• Space-separated values
• Index starts from 0
• Always String
• Convert using parseInt()

Common Errors:
• ArrayIndexOutOfBoundsException
• NumberFormatException
```

---
