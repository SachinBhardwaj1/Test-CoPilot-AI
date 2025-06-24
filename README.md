# 🧪 Test CoPilot AI (Currently - In Progress)

**JUnit Test Pilot AI** is a developer tool that integrates Google Vertex AI (PaLM/Gemini) to automatically generate JUnit 5 test cases for Java methods. It parses Java source files, constructs structured prompts, communicates with Google’s generative APIs, and writes fully-formed unit tests to match your method logic and signature.

---

## 🎯 Objective

Reduce time spent on writing boilerplate unit tests by programmatically generating JUnit 5 test classes using large language models (LLMs). This project is optimized for developers working in Java-based backend systems who want to offload repetitive test creation to an intelligent system with minimal setup.

---

## ⚙️ Features

- 🔍 Extracts methods from `.java` source files  
- 🧠 Constructs precise test generation prompts  
- ☁️ Integrates with Google Vertex AI (PaLM/Gemini)  
- 📝 Generates JUnit 5-compliant test classes  
- 📂 Outputs directly into your test directory 

---

## 🛠️ Tech Stack

- **Language**: Java 8+  
- **Test Framework**: JUnit 5  
- **Build Tool**: Apache Maven  
- **AI Platform**: Google Vertex AI (PaLM/Gemini)  
- **API Communication**: Google Cloud AI SDK, OkHttp  
- **File Processing**: Java File I/O, custom method extractor

---

## 📐 Architecture Overview

```text
Java Method (.java file)
        |
[ Method Extractor ]
        ↓
[ Prompt Builder ]
        ↓
[ Vertex AI API Call (PaLM / Gemini) ]
        ↓
[ Response Parser ]
        ↓
[ JUnit 5 Test Class Output (.java) ]
```

# 🧠 Why This Project?

Traditional test development often involves repetitive patterns that can be modeled effectively using LLMs. This tool automates test creation by parsing Java logic and converting it into structured JUnit 5 code using generative AI. This project takes a similar approach: encode inputs → generate AI-structured output → write deterministic code.
