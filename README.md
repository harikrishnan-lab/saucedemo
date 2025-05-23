# saucedemo
# Selenium Test Automation Framework (SauceDemo)

This is a real-time automation framework developed using **Selenium WebDriver**, **Java**, **TestNG**, **Extent Reports**, **Log4j**, and the **Page Object Model (POM)** design pattern. It is designed to simulate how modern Testers build scalable UI test automation for web applications.

> ✅ Tested on: https://www.saucedemo.com/

---

## 🔧 Tech Stack

- **Language**: Java
- **Automation Tool**: Selenium WebDriver
- **Test Framework**: TestNG
- **Build Tool**: Maven
- **Design Pattern**: Page Object Model (POM)
- **Reporting**: ExtentReports
- **Logging**: Log4j
- **Code Quality**: SonarQube
- **Retry Mechanism**: TestNG RetryAnalyzer
- **Screenshot on Failure**: Enabled
- **Version Control**: Git

---

## 📁 Project Structure

## src
├── main

│   ├── java

│   │   ├── base           # WebDriver & config setup

│   │   ├── pages          # Page classes (POM)

│   │   ├── utils          # Log, Wait, Screenshot utilities

│   │   └── config         # ConfigReader, constants

├── test

│   ├── java

│   │   ├── tests          # TestNG test cases

│   │   └── listeners      # Retry, Listener classes

resources

├── config.properties      # Environment config

├── log4j2.xml             # Logging configuration

testng.xml                 # TestNG suite file

pom.xml                    # Maven dependencies


## 🚀 Features

- ✅ Modular Page Object Model for maintainability
- ✅ Cross-browser support via config
- ✅ Centralized configuration management
- ✅ Auto-generated ExtentReports with screenshots on failure
- ✅ Retry logic for flaky tests
- ✅ Test tagging using TestNG groups (e.g., Smoke, Regression)
- ✅ Parallel test execution support
- ✅ Log4j logging for traceability
- ✅ SonarQube integrated for code quality analysis

---

## 🔧 How to Run the Tests

### 1. Clone the repository
```bash
git clone https://github.com/your-username/selenium-saucedemo-framework.git
cd selenium-saucedemo-framework
2. Set configurations
Edit the config.properties file with:

browser = chrome

baseURL = https://www.saucedemo.com/

Add other properties as required

3. Run tests via Maven

mvn clean test
📊 Reports & Logs
ExtentReports: test-output/ExtentReport.html

Logs: logs/ folder (generated per run)

🙋‍♂️ Author
Hari krishnan
SDET
---





