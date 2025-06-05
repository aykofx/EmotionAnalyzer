# Emotion Analyzer

A lightweight Java Swing application that estimates the user's emotional state based on their typing behavior.

## 💡 Overview

This tool provides real-time feedback by analyzing:

- **Typing speed** — measured by pauses between keystrokes  
- **Backspace usage** — used as an indicator of errors or frustration  

The app outputs mood estimations like **Calm**, **Normal**, or **Stressed** to the console based on typing rhythm.

## 🧠 Mood Estimation Logic

- Typing pause < 300ms → `Calm`  
- Typing pause < 1000ms → `Normal`  
- Typing pause ≥ 1000ms → `Stressed`  
- Every backspace press is tracked as a potential error  

## 🖥️ Example Output

Pause: 145ms | Mood: Calm | Errors: 1

Pause: 820ms | Mood: Normal | Errors: 1

Pause: 1250ms | Mood: Stressed | Errors: 2


## 📦 Requirements

- Java 8 or higher  
- No external libraries (uses `javax.swing` and `java.awt.event`)  

## 🚀 How to Run

1. Save the source code as `Main.java`  
2. Open a terminal and compile it:  
   `javac Main.java`  
3. Run the program:  
   `java Main`  
4. Start typing in the window and observe mood output in the terminal  
