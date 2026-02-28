## 1️⃣ Definition

**HTTP (HyperText Transfer Protocol)** is an application-layer protocol used for communication between a client and a server over the web.

It follows a **request–response model**.

It is:

* Stateless
* Text-based
* Client-server based

---

## 2️⃣ Visual Representation

### Request–Response Model

```
Client  ---- HTTP Request ---->
Server
Client  <--- HTTP Response ----
```

---

### HTTP Message Structure

```
Request:
---------------------------------
GET /users HTTP/1.1
Host: example.com
Header: value

Body (optional)
---------------------------------

Response:
---------------------------------
HTTP/1.1 200 OK
Content-Type: application/json

Response Body
---------------------------------
```

---

### Stateless Nature

```
Request 1 --> Server
(Server forgets client)

Request 2 --> Server
(Server does not remember Request 1 unless session/token used)
```

---

## 3️⃣ Key Features / Properties

* Stateless protocol
* Runs over TCP
* Uses request–response model
* Supports different methods (GET, POST, etc.)
* Supports headers and body
* Default ports:

  * HTTP → 80
  * HTTPS → 443
* Human-readable

---

## 4️⃣ Syntax

### Basic HTTP Request

```
GET /products HTTP/1.1
Host: example.com
```

### HTTP Response

```
HTTP/1.1 200 OK
Content-Type: text/html
```

---

## 5️⃣ Code Example (Java)

```java
import java.net.*;
import java.io.*;

public class HttpExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        HttpURLConnection conn =
            (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader reader =
            new BufferedReader(
                new InputStreamReader(conn.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        reader.close();
        conn.disconnect();
    }
}
```

---

## 6️⃣ Use Cases

* Web browsing
* REST APIs
* Microservice communication
* Payment processing
* OAuth authentication
* File downloads
* Cloud services

---

## 7️⃣ Pitfalls / Notes

* ❌ Sending sensitive data over HTTP (use HTTPS)
* ❌ Ignoring status codes
* ❌ Not handling timeouts
* ❌ Exposing data in query parameters
* ❌ Assuming HTTP maintains session
* ❌ Not validating input
* ❌ Large payload without compression

---

## 8️⃣ Real-World Analogy

📬 Postal System

* Client → Sender
* Server → Receiver
* Request → Letter
* Response → Reply letter
* Headers → Address & instructions
* Body → Actual message

Each request is independent unless tracking ID (cookie/session) is used.

---

## 9️⃣ Best Practices

* Always use HTTPS
* Validate status codes
* Set timeouts
* Use proper HTTP methods
* Avoid sensitive data in URL
* Implement authentication
* Handle errors properly
* Use compression for large responses

---

## 🔟 Tricky Questions

11. What is HTTP?
    ➜ Application-layer protocol for client-server communication.

12. Is HTTP stateful?
    ➜ No, it is stateless.

13. What protocol does HTTP run on?
    ➜ TCP.

14. What is default port for HTTP?
    ➜ 80.

15. What is default port for HTTPS?
    ➜ 443.

16. What is difference between HTTP and HTTPS?
    ➜ HTTPS is encrypted using TLS.

17. What is HTTP status code 200?
    ➜ OK (success).

18. What is 404?
    ➜ Not Found.

19. What is 500?
    ➜ Internal Server Error.

20. What is difference between GET and POST?
    ➜ GET retrieves data; POST sends data.

21. Are headers mandatory in HTTP?
    ➜ Some headers are required (e.g., Host in HTTP/1.1).

22. Can HTTP send binary data?
    ➜ Yes.

23. What ensures secure HTTP communication?
    ➜ TLS (HTTPS).

24. What is idempotent method?
    ➜ Method that produces same result if repeated (e.g., GET).

25. Why is HTTP called stateless?
    ➜ Server does not retain client context between requests.

---

## 🧾 Quick Recap / Cheat Sheet

* HTTP = Client-server protocol
* Stateless
* Runs over TCP
* Default ports: 80, 443
* Request → Response model
* Methods: GET, POST, PUT, DELETE
* Status codes indicate result
* HTTPS = HTTP + TLS
* Headers + Body structure
* No session unless cookies/tokens used
* Validate status codes
* Use HTTPS
* Avoid sensitive data in URL
* Used in APIs & web
* Core of web communication

---
