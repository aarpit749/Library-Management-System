# Library-Management-System
Designing and implementing a Library Management System in Java

## Overview
This project is a **Library Management System** implemented in Java.  
It demonstrates **Object-Oriented Programming (OOP)** concepts, adherence to **SOLID principles**, and the use of **design patterns**.  
The system allows librarians to manage books, patrons, and lending processes efficiently.

---

## ✨ Features

### Core
- **Book Management**
  - Add, remove, update books
  - Search by title, author, or ISBN
- **Patron Management**
  - Add and update patrons
  - Track borrowing history
- **Lending Process**
  - Checkout and return books
- **Inventory Management**
  - Track available and borrowed books

### Optional Extensions
- **Multi-branch Support**
  - Manage multiple library branches
  - Transfer books between branches
- **Reservation System**
  - Patrons can reserve books
  - Notification when reserved books become available (**Observer Pattern**)
- **Recommendation System**
  - Suggest books based on borrowing history (**Strategy Pattern**)

---

## 🛠 Technical Highlights
- **OOP Concepts:** Encapsulation, Inheritance, Polymorphism, Abstraction
- **SOLID Principles:** Each service has a single responsibility, open/closed design for extensibility
- **Design Patterns:**
  - **Observer** → Reservation notifications
  - **Strategy** → Recommendation algorithms
- **Java Collections:** `List`, `Set`, `Map` used for inventory, patrons, and reservations
- **Logging:** Utility class with `java.util.logging`

---

## 📂 Project Structure
LibraryManagementSystem/
├── README.md
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── library/
│                   ├── Entity/              # Core entities
│                   ├── Service/            # Business logic
│                   ├── Strategy/           # Recommendation strategies
│                   ├── Observer/           # Reservation notifications
│                   ├── Util/               # Logging utilities
│                   └── Main.java           # Interactive console app
└── pom.xml


