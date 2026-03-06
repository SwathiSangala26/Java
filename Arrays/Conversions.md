# 1️⃣ Array → String

### Using `Arrays.toString()`

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        String result = Arrays.toString(arr);

        System.out.println(result);
    }
}
```

Output

```
[1, 2, 3, 4]
```

Explanation

```
Array
[1,2,3,4]

↓ Arrays.toString()

"[1, 2, 3, 4]"
```

---

# 2️⃣ Array → List

Using **`Arrays.asList()`**

```java
import java.util.*;

class Main {
    public static void main(String[] args) {

        String[] arr = {"A","B","C"};

        List<String> list = Arrays.asList(arr);

        System.out.println(list);
    }
}
```

Output

```
[A, B, C]
```

Important Interview Point ⚠️

```
Arrays.asList() returns fixed-size list
```

So this will fail:

```java
list.add("D");   // UnsupportedOperationException
```

---

# 3️⃣ Array → Stream

Java 8 introduced **Streams**.

```java
import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        IntStream stream = Arrays.stream(arr);

        stream.forEach(System.out::println);
    }
}
```

Output

```
1
2
3
4
```

---

# 4️⃣ Array → Set

```java
import java.util.*;

class Main {
    public static void main(String[] args) {

        Integer[] arr = {1,2,3,2,1};

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));

        System.out.println(set);
    }
}
```

Output

```
[1,2,3]
```

Duplicates removed automatically.

---

# 5️⃣ Array → Single Value (Sum)

```java
class Main {

    public static void main(String[] args) {

        int[] arr = {10,20,30};

        int sum = 0;

        for(int num : arr)
            sum += num;

        System.out.println(sum);
    }
}
```

Output

```
60
```

---

# 6️⃣ Array → Another Array Type

Example **int → double**

```java
class Main {
    public static void main(String[] args) {

        int[] arr = {1,2,3};

        double[] d = new double[arr.length];

        for(int i=0;i<arr.length;i++)
            d[i] = arr[i];

        for(double x : d)
            System.out.println(x);
    }
}
```

Output

```
1.0
2.0
3.0
```

---

# 7️⃣ Array → String (Join Method)

```java
String[] arr = {"Java","Python","C#"};

String result = String.join("-", arr);

System.out.println(result);
```

Output

```
Java-Python-C#
```

---

# 🔑 Important Interview Questions

### 1️⃣ Can primitive array be converted to List directly?

❌ No

```
int[] arr = {1,2,3};

Arrays.asList(arr)
```

Output

```
[[I@15db9742]
```

Because it treats **entire array as one element**.

Correct way:

```
Integer[] arr = {1,2,3};
```

---

### 2️⃣ What does this print?

```java
int[] arr = {1,2,3};

System.out.println(arr);
```

Output

```
[I@15db9742
```

Because **array inherits Object's toString()**.

---

### 3️⃣ Best way to print array?

```
Arrays.toString(arr)
```

---

If you want, I can also show you **10 tricky array conversion interview questions (very common in Java interviews)**.
