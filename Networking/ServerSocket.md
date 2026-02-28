## 1️⃣ Definition

`ServerSocket` is a Java class used to **listen for incoming client connections** over TCP.

It waits on a specific **port**, accepts connection requests, and creates a `Socket` object for communication with each client.

It is used only for **server-side TCP communication**.

---

## 2️⃣ Visual Representation

### Basic Flow

```id="ss1"
Server:
  ServerSocket (Port 8080)
        |
        |--- listen() ---
        |
Client ---- connect() ---->
        |
Server ---- accept() ---->
        |
New Socket Created (for that client)
```

---

### Multiple Clients

```id="ss2"
Client A ----\
              \
Client B ------> ServerSocket (8080)
              /
Client C ----/

Each accept() → new Socket instance
```

---

### Lifecycle

```id="ss3"
1. Create ServerSocket
2. Bind to Port
3. Listen
4. accept()
5. Communicate via Socket
6. Close Socket
7. Close ServerSocket
```

---

## 3️⃣ Key Features / Properties

* Works only with TCP
* Binds to a specific port
* Blocks on `accept()` call
* Creates new `Socket` per client
* Supports backlog queue
* Can configure timeout
* Can handle multiple clients via threads

---

## 4️⃣ Syntax

### Create ServerSocket

```java id="sscode1"
ServerSocket server = new ServerSocket(8080);
```

---

### Accept Client

```java id="sscode2"
Socket clientSocket = server.accept();
```

`accept()` is blocking — waits until client connects.

---

## 5️⃣ Complete Example

### Simple Server

```java id="sscode3"
import java.net.*;
import java.io.*;

public class MyServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");
            socket.close();
        }
    }
}
```

---

## 6️⃣ Important Methods

* `accept()` → waits for connection
* `close()` → closes server socket
* `setSoTimeout()` → sets timeout
* `getInetAddress()` → gets IP
* `getLocalPort()` → gets bound port

---

## 7️⃣ Backlog Queue Concept

```id="ss4"
Client Requests --> [Queue] --> accept()
```

If too many clients connect at once:

* They wait in queue
* If queue full → connection refused

---

## 8️⃣ Use Cases

* Web servers
* Chat servers
* File servers
* Payment gateways
* Microservices backend
* Real-time systems
* Enterprise applications

---

## 9️⃣ Pitfalls / Notes

* ❌ Not closing server properly
* ❌ Single-threaded server blocking all clients
* ❌ Ignoring exceptions
* ❌ Hardcoding ports
* ❌ No timeout configuration
* ❌ Not handling backlog properly
* ❌ Resource leaks
* ❌ Not securing with TLS

---

## 🔟 Real-World Analogy

🏢 Reception Desk

* ServerSocket → Reception desk
* Port → Office entry number
* Client → Visitor
* accept() → Receptionist allowing entry
* Socket → Private meeting room

Each visitor gets a separate room.

---

# 🔟 Tricky Questions (Interview Level)

1. What is ServerSocket?
   ➜ A TCP server-side socket that listens for client connections.

2. What does `accept()` return?
   ➜ A new `Socket` object.

3. Is `accept()` blocking?
   ➜ Yes.

4. Can ServerSocket handle multiple clients?
   ➜ Yes, via multiple accept() calls and threads.

5. What happens if port is already in use?
   ➜ BindException.

6. What protocol does ServerSocket use?
   ➜ TCP only.

7. What is backlog in ServerSocket?
   ➜ Queue size for incoming connections.

8. What happens if backlog queue is full?
   ➜ New connections may be rejected.

9. Can ServerSocket be reused after close()?
   ➜ No.

10. What is difference between ServerSocket and Socket?
    ➜ ServerSocket listens; Socket communicates.

11. How do you stop blocking accept()?
    ➜ Close ServerSocket or set timeout.

12. What is setSoTimeout()?
    ➜ Sets maximum wait time for accept().

13. Can ServerSocket work with UDP?
    ➜ No.

14. What happens if client disconnects suddenly?
    ➜ IOException on server side.

15. Why should server handle clients in separate threads?
    ➜ Prevent blocking other clients.

---

# 🧾 Quick Recap / Cheat Sheet

* ServerSocket listens for TCP connections
* Binds to port
* accept() creates new Socket
* Blocking by default
* One socket per client
* Supports backlog queue
* Needs threading for multiple clients
* Close resources properly
* Only TCP supported
* Port conflicts cause BindException
* Use setSoTimeout for timeout
* Secure with TLS
* Used in web/chat servers
* Core of server-side networking
* Part of java.net package

---
