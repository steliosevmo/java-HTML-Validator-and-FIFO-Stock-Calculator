# HTML Validator & FIFO Stock Profit Calculator

A Java-based application demonstrating the practical utility of core data structures (**Stacks** and **Queues**) through two real-world scenarios: HTML syntax validation and financial profit calculation.

## 🚀 Overview

This repository contains custom, generic implementations of a **Stack** and a **Queue**, along with สอง logic-heavy applications that utilize them:

1.  **HTML Tag Validator:** Uses a stack-based algorithm to ensure HTML tags are properly opened, closed, and nested.
2.  **Stock Profit Calculator:** Implements the **FIFO (First-In-First-Out)** accounting method to calculate net profit from stock market trades.

---

## 🛠️ Data Structures Implemented

To demonstrate a deep understanding of memory management and pointers, all structures are built from scratch using custom nodes without relying on `java.util` collections.

### Generic Stack (LIFO)
* **Interface:** `StringStack<T>` - Defines methods for a Stack handling items.
* **Implementation:** `StringStackImpl<T>` - A link-based LIFO implementation.
* **Primary Operations:** Supports `push`, `pop`, `peek`, `isEmpty`, and `size`.

### Generic Queue (FIFO)
* **Interface:** `DoubleQueue<T>` - Defines methods for a FIFO queue.
* **Implementation:** `DoubleQueueImpl<T>` - A link-based FIFO implementation.
* **Primary Operations:** Supports `put`, `get`, `peek`, `isEmpty`, and `size`.

---

## 📂 Featured Applications

### 1. HTML Tag Checking (`TagChecking.java`)
The validator processes a text file and isolates HTML tags using regular expressions.
* **Logic:** Opening tags are pushed onto the stack. 
* **Validation:** When a closing tag is encountered, the program pops the top element from the stack and checks for a match.
* **Special Cases:** It is designed to ignore self-closing tags like `<br>` and `<img>`.

### 2. Net Profit Calculation (`NetProfit.java`)
This application simulates a stock ledger, processing "buy" and "sell" transactions.
* **Logic:** When buying shares, the quantity and price are stored in the queue.
* **FIFO Method:** During a sale, shares are "unloaded" from the oldest purchase in the queue. 
* **Profit:** The net profit is calculated based on the difference between the purchase price and the current selling price.

---

## 💻 How to Use

### Prerequisites
* Java Development Kit (JDK) 8 or higher.

### Compilation
Compile all source files from the root directory:
```bash
javac *.java
