# BStackDemo Automation

## Project Overview

This project automates the BStackDemo e-commerce application using Selenium WebDriver, Java, TestNG, and Maven.

The automation covers the main user flow from login to adding a product to the cart and completing the checkout process.

## Application

BStackDemo

## Technology Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Eclipse IDE
- Git & GitHub

## Test Scenarios

The project includes the following automated test classes:

1. Login Test
2. Add To Cart Test
3. Checkout Test

## TestNG Suite

The project uses `testng.xml` to execute the automation test suite.

The suite contains:

- `tests.LoginTest`
- `tests.AddToCartTest`
- `tests.CheckoutTest`

## Project Structure

```text
BStackDemoAutomation
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   └── ProductPage.java
│   │   │   └── utils
│   │   │       ├── ConfigReader.java
│   │   │       ├── ExtentReportManager.java
│   │   │       ├── ScreenshotUtils.java
│   │   │       ├── WaitUtils.java
│   │   │       └── WebDriverFactory.java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── tests
│       │       ├── AddToCartTest.java
│       │       ├── BaseTest.java
│       │       ├── CheckoutTest.java
│       │       └── LoginTest.java
│       └── resources
├── test-output
│   ├── ExtentReport.html
│   └── emailable-report.html
├── testng.xml
├── pom.xml
└── README.md



 	## Test Execution Result


The BStackDemo Automation Suite was executed successfully using TestNG.

- Total Tests Run: 9
- Passed: 9
- Failed: 0
- Skipped: 0

Execution Status: PASS