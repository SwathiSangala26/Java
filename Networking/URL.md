## 1️⃣ Definition

A **URL (Uniform Resource Locator)** is the address used to locate and access a resource on the internet.

It specifies:

* Protocol
* Host (Domain/IP)
* Port (optional)
* Path
* Query parameters
* Fragment (optional)

It answers:

> “Where is the resource located and how to access it?”

---

## 2️⃣ Visual Representation

### URL Structure

```id="url1"
https://www.example.com:8080/products/list?id=10#top
|----| |---------------| |----| |--------| |----|
Protocol   Host           Port    Path     Query  Fragment
```

---

### Simplified Breakdown

```id="url2"
Protocol://Host:Port/Path?Query#Fragment
```

---

### Example Flow

```id="url3"
Client Browser
     |
     |  Request using URL
     v
https://api.myapp.com/users?id=5
     |
     v
Server responds with resource
```

---

## 3️⃣ Key Features / Properties

* Identifies resource location
* Uses protocols like:

  * HTTP
  * HTTPS
  * FTP
* Case-sensitive in path (server dependent)
* Can contain query parameters
* Encoded format (special characters must be encoded)
* Used for both web & API communication

---

## 4️⃣ URL Components Explained

### 1️⃣ Protocol

Defines communication method.

Example:

```id="url4"
http
https
ftp
```

---

### 2️⃣ Host

Domain name or IP address.

```id="url5"
www.google.com
192.168.1.10
```

---

### 3️⃣ Port

Optional. Default:

* HTTP → 80
* HTTPS → 443

Example:

```id="url6"
https://example.com:8080
```

---

### 4️⃣ Path

Location of resource.

```id="url7"
/users/profile
```

---

### 5️⃣ Query Parameters

Data sent to server.

```id="url8"
?id=10&name=swathi
```

---

### 6️⃣ Fragment

Client-side reference.

```id="url9"
#section1
```

---

## 5️⃣ Java URL Class Example

### Create URL

```java id="urlcode1"
import java.net.URL;

URL url = new URL("https://example.com:8080/products?id=10");
```

---

### Access URL Components

```java id="urlcode2"
System.out.println(url.getProtocol());
System.out.println(url.getHost());
System.out.println(url.getPort());
System.out.println(url.getPath());
System.out.println(url.getQuery());
```

---

### Open Connection

```java id="urlcode3"
URL url = new URL("https://example.com");
URLConnection connection = url.openConnection();
```

---

## 6️⃣ URL vs URI

```id="url10"
URI = Identifier
URL = Locator (subset of URI)
```

All URLs are URIs, but not all URIs are URLs.

---

## 7️⃣ Use Cases

* Access web pages
* REST API calls
* File downloads
* Microservices communication
* OAuth redirection
* Payment gateway callbacks
* CDN resource loading

---

## 8️⃣ Pitfalls / Notes

* ❌ Not encoding special characters
* ❌ Hardcoding URLs
* ❌ Not validating user-supplied URLs
* ❌ Ignoring HTTPS
* ❌ Misunderstanding default ports
* ❌ Exposing sensitive data in query parameters
* ❌ URL injection vulnerabilities
* ❌ Confusing URL with endpoint

---

## 9️⃣ Real-World Analogy

📬 Postal Address

* Protocol → Delivery method (Air/Surface)
* Host → City
* Port → Building number
* Path → Apartment number
* Query → Extra instructions
* Fragment → Room inside apartment

Complete address ensures delivery to correct destination.

---

# 🔟 Tricky Questions (Interview Level)

1. What is URL?
   ➜ Address used to locate a resource on network.

2. What is difference between URL and URI?
   ➜ URL is subset of URI; URI identifies resource, URL locates it.

3. Is port mandatory in URL?
   ➜ No, defaults are used.

4. What is default port for HTTPS?
   ➜ 443.

5. What happens if protocol is missing?
   ➜ URL may be invalid or assumed by browser.

6. Are query parameters sent to server?
   ➜ Yes.

7. Is fragment sent to server?
   ➜ No, handled client-side.

8. Why should query parameters not contain sensitive data?
   ➜ Visible in logs and browser history.

9. What is URL encoding?
   ➜ Encoding special characters using % format.

10. What happens if special characters not encoded?
    ➜ Invalid URL or request failure.

11. Is URL case-sensitive?
    ➜ Host is not; path may be.

12. What class is used in Java for URL handling?
    ➜ `java.net.URL`.

13. What is openConnection()?
    ➜ Opens communication to resource.

14. What protocol ensures encrypted communication?
    ➜ HTTPS.

15. Can IP address be used instead of domain?
    ➜ Yes.

---

# 🧾 Quick Recap / Cheat Sheet

* URL = Uniform Resource Locator
* Format: Protocol://Host:Port/Path?Query#Fragment
* Default ports: 80 (HTTP), 443 (HTTPS)
* Query parameters sent to server
* Fragment not sent to server
* URL is subset of URI
* Encode special characters
* Avoid sensitive data in query
* Use HTTPS for security
* Used in APIs and web
* Java class: `java.net.URL`
* openConnection() establishes communication
* Host not case-sensitive
* Path may be case-sensitive
* Essential in networking

---
