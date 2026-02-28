## 1️⃣ Definition

`URLConnection` is an abstract class in `java.net` used to establish communication between a Java application and a resource specified by a URL.

It enables:

* Sending requests
* Receiving responses
* Accessing headers
* Configuring connection settings

---

## 2️⃣ Visual Representation

```
Java Application
      |
      | openConnection()
      v
URLConnection
      |
      | connect()
      v
Remote Server
      |
      | Response
      v
InputStream
```

---

## 3️⃣ Key Features / Properties

* Abstract class
* Protocol independent
* Supports input/output streams
* Supports request headers
* Supports connection & read timeout
* Blocking by default
* Returns protocol-specific subclass
* Not thread-safe

---

## 4️⃣ Syntax

```java
URL url = new URL("https://example.com");
URLConnection connection = url.openConnection();
```

Set timeout:

```java
connection.setConnectTimeout(5000);
connection.setReadTimeout(5000);
```

---

## 5️⃣ Code Example

```java
import java.net.*;
import java.io.*;

public class Example {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        URLConnection connection = url.openConnection();

        BufferedReader reader =
            new BufferedReader(
                new InputStreamReader(
                    connection.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
    }
}
```

---

## 6️⃣ Use Cases

* REST API calls
* File downloads
* Microservice communication
* Payment integration
* OAuth token exchange

---

## 7️⃣ Pitfalls / Notes

* ❌ Not closing streams
* ❌ Ignoring timeouts
* ❌ Not checking HTTP response codes
* ❌ Blocking behavior misunderstood
* ❌ Hardcoding URLs
* ❌ Not using HTTPS

---

## 8️⃣ Real-World Analogy

* URL → Address
* URLConnection → Delivery request
* Headers → Instructions
* Response → Delivered package

---

## 9️⃣ Best Practices

* Set connection & read timeout
* Close streams properly
* Handle exceptions
* Use HTTPS
* Validate URLs
* Avoid using in main/UI thread

---

## 🔟 Tricky Questions

11. What is URLConnection?
    ➜ Abstract class for communication with a URL resource.

12. Is URLConnection protocol specific?
    ➜ No.

13. What does openConnection() return?
    ➜ URLConnection or its subclass.

14. Is connect() mandatory?
    ➜ No, implicitly called when needed.

15. What is difference between URL and URLConnection?
    ➜ URL identifies resource; URLConnection communicates.

16. How to set headers?
    ➜ setRequestProperty().

17. Is URLConnection blocking?
    ➜ Yes.

18. What is difference between URLConnection and HttpURLConnection?
    ➜ HttpURLConnection supports HTTP-specific features.

19. Why set timeout?
    ➜ Prevent indefinite blocking.

20. Is URLConnection thread-safe?
    ➜ No.

21. What method reads data?
    ➜ getInputStream().

22. What ensures secure communication?
    ➜ HTTPS.

23. What happens if streams not closed?
    ➜ Resource leak.

24. Can URLConnection send data?
    ➜ Yes, using getOutputStream().

25. Why check response code in HTTP?
    ➜ To verify request success.

---

## 🧾 Quick Recap / Cheat Sheet

* Abstract communication class
* Created using URL.openConnection()
* Supports input & output
* Blocking by default
* Supports timeouts
* Cast to HttpURLConnection for HTTP
* Close streams
* Use HTTPS
* Not thread-safe
* Used for REST/API calls

---
