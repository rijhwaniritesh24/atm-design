# ATM Monitoring API

This project provides an API that securely monitors the status and behavior of ATMs within a bank’s network in real-time. The API handles customer transactions, failure monitoring, and camera footage retrieval. It is built using **Java Spring Boot** and follows the **OpenAPI Specification 3.1**.

## Table of Contents
- [System Overview](#system-overview)
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Activity Flow Diagrams](#activity-flow-diagrams)
- [Data Model](#data-model)
- [Development Setup](#development-setup)
- [Task Breakdown](#task-breakdown)

## System Overview

This ATM Monitoring API runs on ATM devices and is accessible by other applications within the bank’s network. It integrates with:
- **Bank Authentication System**: Verifies tokens for secure access.
- **Transaction Service**: Handles and logs all ATM transactions.
- **Failure Monitoring Service**: Captures and logs system/device failures.
- **Camera Service**: Enables downloading of ATM camera footage within a specific time range.
- **Database**: Stores transaction logs, failure logs, and camera footage metadata.

## Features
- **Authorization**: Secure access to all endpoints using JWT tokens.
- **Transaction Breakdown**: Retrieve the breakdown of deposit, withdrawal, and balance inquiry transactions.
- **Failure Monitoring**: List system/device failures with timestamps and descriptions.
- **Camera Footage Retrieval**: Download ATM camera footage for specific time ranges.
- **Additional Endpoints**: ATM status and transaction details.

## API Endpoints

### 1. **Authorization**
- **POST /auth/token**  
  Validate authentication tokens using the bank's external system.

### 2. **Total Customers in Last 24 Hours**
- **GET /customers/total**  
  Returns the total number of unique customers in the past 24 hours.

### 3. **Transaction Breakdown**
- **GET /transactions/breakdown**  
  Returns the breakdown of ATM transactions by type (Deposit, Withdrawal, Balance Inquiry).

### 4. **List of Failures**
- **GET /failures**  
  Returns a list of all system/device failures with timestamps and descriptions.

### 5. **Download Camera Footage**
- **GET /camera/download**  
  Downloads ATM camera footage within a specific time range.

## Activity Flow Diagrams

### 1. **Transaction Logging Flow**
```mermaid

    A[Customer] -->|Uses ATM| B[ATM Device]
    B --> C[Transaction]
    C --> D[Database]
    D --> E[Transaction Log]
    F[Bank App] -->|Request Transaction Breakdown| G[API Gateway]
    G --> C
    C --> E
    E --> G
    G --> F
    
 ```
 
### 2. **Failure Monitoring Flow**
   ```mermaid
    A[ATM Device] -->|Failure Detected| B[Failure Service]
    B --> C[Database]
    C --> D[Failure Log]
    E[Bank App] -->|Request Failure List| F[API Gateway]
    F --> B
    B --> C
    C --> F
    F --> E
```
### 3. **Camera Footage Retrieval**

      A[ATM Camera] -->|Footage Captured| B[Camera Service]
      B --> C[Video Storage]
      D[Bank App] -->|Request Footage| E[API Gateway]
      E --> B
      B --> C
      C --> E
      E --> D
