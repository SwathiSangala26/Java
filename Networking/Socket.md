## 1️⃣ Definition

A **Socket** is an endpoint for two-way communication between two machines over a network.

It enables data exchange using protocols like:

* TCP
* UDP

A socket is defined by:

```
IP Address + Port Number + Protocol
```

---

## 2️⃣ Visual Representation

### Basic Client–Server Communication

```id="sock1"
Client Machine
   |
   |  (Request)
   v
[IP: 192.168.1.10 | Port: 8080]
   ^
   |  (Response)
   |
Server Machine
```

---

### TCP Connection Flow

```id="sock2"
Client                 Server
   | --- SYN --------> |
   | <--- SYN-ACK ---- |
   | --- ACK --------> |
Connection Established
```

(Three-way handshake)

---

### Server Socket Model

```id="sock3"
Server:
  |
  |-- Create Socket
  |-- Bind to Port
  |-- Listen
  |-- Accept Connection
  |
Client:
  |
  |-- Connect
  |-- Send / Receive Data
```

---

## 3️⃣ Key Features / Properties

* Full-duplex communication
* Uses ports for identification
* Can be connection-oriented (TCP)
* Can be connectionless (UDP)
* Supports streaming or datagram mode
* Blocking or non-blocking
* Supports multiplexing (selectors)

---

## 4️⃣ Types of Sockets

### 1️⃣ TCP Socket (Stream Socket)

* Reliable
* Ordered
* Connection-oriented
* Error checking

Used for:

* Web (HTTP)
* Email
* File transfer

---

### 2️⃣ UDP Socket (Datagram Socket)

* Faster
* No guarantee of delivery
* No ordering
* No connection setup

Used for:

* Live streaming
* Gaming
* DNS queries

---

## 5️⃣ Java Example (TCP)

### Server

```java id="sockjava1"
ServerSocket server = new ServerSocket(8080);
Socket socket = server.accept();
```

---

### Client

```java id="sockjava2"
Socket socket = new Socket("localhost", 8080);
```

---

## 6️⃣ Socket Lifecycle

```id="sock4"
1. Create
2. Bind (Server)
3. Listen (Server)
4. Connect (Client)
5. Accept (Server)
6. Send / Receive
7. Close
```

---

## 7️⃣ Use Cases

* Web servers
* Chat applications
* Online gaming
* Payment gateways
* Microservices communication
* IoT devices
* Real-time systems

---

## 8️⃣ Pitfalls / Notes

* ❌ Not closing sockets (resource leak)
* ❌ Blocking calls causing deadlocks
* ❌ Not handling timeouts
* ❌ Hardcoding ports
* ❌ Ignoring exception handling
* ❌ Not securing communication (no TLS)
* ❌ Port conflicts
* ❌ Not validating incoming data

---

## 9️⃣ Real-World Analogy

📞 Telephone Call

* IP address → Phone number
* Port → Extension number
* TCP → Confirmed conversation
* UDP → Walkie-talkie (no guarantee)
* Close connection → Hang up call

---

# 🔟 Tricky Questions (Interview Level)

1. What is a socket?
   ➜ Endpoint for network communication.

2. What identifies a socket uniquely?
   ➜ IP + Port + Protocol.

3. Difference between TCP and UDP socket?
   ➜ TCP reliable; UDP faster but unreliable.

4. What is three-way handshake?
   ➜ SYN, SYN-ACK, ACK.

5. What happens if server does not call `accept()`?
   ➜ Client connection will not be processed.

6. Is TCP connection stateful?
   ➜ Yes.

7. What is blocking socket?
   ➜ Waits until operation completes.

8. What is non-blocking socket?
   ➜ Returns immediately.

9. What happens if port already in use?
   ➜ Bind exception.

10. Why must sockets be closed?
    ➜ Release system resources.

11. What is half-open connection?
    ➜ One side closed, other unaware.

12. Can multiple clients connect to same server port?
    ➜ Yes, server handles multiple sockets.

13. What is socket timeout?
    ➜ Time limit for blocking operations.

14. What ensures data integrity in TCP?
    ➜ Checksum and retransmission.

15. Why is TLS used over sockets?
    ➜ Encrypt communication.

---

# 🧾 Quick Recap / Cheat Sheet

* Socket = Communication endpoint
* Defined by IP + Port + Protocol
* TCP = Reliable, ordered
* UDP = Fast, no guarantee
* TCP uses 3-way handshake
* Server lifecycle: Bind → Listen → Accept
* Supports full-duplex
* Close sockets properly
* Handle exceptions
* Avoid blocking issues
* Use TLS for security
* Used in web servers
* Supports multiple clients
* Timeout handling important
* Core of network programming

---
