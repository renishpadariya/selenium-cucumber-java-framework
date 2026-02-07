# Selenium Cucumber Java Automation Framework

![CI](https://github.com/renishpadariya/selenium-cucumber-java-framework/actions/workflows/selenium-ci.yml/badge.svg)
[![Test Report](https://img.shields.io/badge/Test_Report-Live-green)](https://renishpadariya.github.io/selenium-cucumber-java-framework/)

A Selenium WebDriver automation framework built using **Java, Maven, and Cucumber (BDD)** to implement automated UI tests for the **SauceDemo** web application.

This project demonstrates **real-world automation framework design**, **BDD implementation**, and **CI/CD integration using GitHub Actions**, along with **live HTML test reporting** via GitHub Pages.

---

## 🔗 Application Under Test

**SauceDemo**  
👉 https://www.saucedemo.com  

A public demo application used to showcase automation framework capabilities and best practices.

---

## 🚀 Key Features

- Behaviour Driven Development (BDD) using **Cucumber & Gherkin**
- **Page Object Model (POM)** for maintainable and scalable automation
- Thread-safe WebDriver management using 'ThreadLocal'
- Centralised configuration using 'config.properties'
- Automated execution via **GitHub Actions (CI)**
- **Live Cucumber HTML test reports** published using **GitHub Pages**

---

## 🧰 Technologies Used

- **Java 17**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit**
- **Maven**
- **WebDriverManager**
- **Git & GitHub**
- **GitHub Actions (CI/CD)**

---
## 📁 Project Structure

![SauceDemo Project Structure](saucedemo/images/project-structure.png)

---
## ⚙️ Configuration

Test configuration is managed via:

src/test/resources/config/config.properties

Example:
'properties'
browser=chrome
url=https://www.saucedemo.com/
username=standard_user
password=secret_sauce

---
## How to Run

1. **Clone the repository**  

   git clone https://github.com/renishpadariya/selenium-cucumber-java-framework.git
   cd selenium-cucumber-java-framework

3. **Import the project into Eclipse**
   - Go to File → Import → Maven → Existing Maven Project
   - Select the project root folder
    
4. **Install dependencies**
   - Maven will automatically download required dependencies from pom.xml

5. **Run tests**
From Eclipse:
Right-click on your test runner classes → Run As → JUnit Test

---
## Test Reports

# **Local HTML Report**

After local execution:
target/index.html

# **Live HTML Report (CI)**

Cucumber HTML reports are automatically published via GitHub Pages on every successful CI run:

https://renishpadariya.github.io/selenium-cucumber-java-framework/

---
## **CI/CD with GitHub Actions**

CI pipeline triggers on push and pull requests to master

Executes Selenium tests in headless Chrome on Ubuntu runners

Uploads test results as build artifacts

Publishes live HTML reports to GitHub Pages
    

