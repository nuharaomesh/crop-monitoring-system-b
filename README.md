# **Crop Management System API**

## **Overview**
The Crop Management System API is designed to manage and monitor various entities involved in agriculture, including crops, staff, logs, equipment, fields, vehicles, and cultivation processes. This RESTful API provides CRUD operations for all entities and is built using modern development practices.

---

## **Features**
- Manage entities: **Crops**, **Cultivates**, **Equipments**, **Fields**, **Logs**, **Staffs**, **Vehicles**.
- CRUD operations for all entities.
- Centralized logging with **Log4j**.
- Built using **Spring Boot** with Gradle-based architecture.
- MySQL database for reliable data storage.

---

## **Tech Stack**

### **Back-End**
- **Language:** Java
- **Framework:** Spring Boot
- **Build Tool:** Gradle

### **Database**
- **Database Engine:** MySQL
- **ORM:** Hibernate (via Spring Data JPA)

### **Logging**
- **Logging Framework:** Log4j

### **Others**
- REST API principles for efficient communication.
- Dependency Injection for modular and testable code.

---

## **API Endpoints**

### **Crops**
- **GET** `/api/v1/crops` - Retrieve all crops.
- **GET** `/api/v1/crops/{id}` - Retrieve crop details by ID.
- **POST** `/api/v1/crops` - Add a new crop.
- **PUT** `/api/v1/crops/{id}` - Update crop details.
- **DELETE** `/api/v1/crops/{id}` - Delete a crop.

### **Cultivates**
- **GET** `/api/v1/cultivates` - Retrieve all cultivation processes.
- **POST** `/api/v1/cultivates` - Add a new cultivation process.
- **PUT** `/api/v1/cultivates/{id}` - Update a cultivation process.
- **DELETE** `/api/v1/cultivates/{id}` - Delete a cultivation process.

### **Staffs**
- **GET** `/api/v1/staffs` - Retrieve all staff members.
- **POST** `/api/v1/staffs` - Add a new staff member.
- **PUT** `/api/v1/staffs/{id}` - Update a staff member's details.
- **DELETE** `/api/v1/staffs/{id}` - Remove a staff member.

### Other Entities
Endpoints follow the same CRUD structure for **Equipments**, **Fields**, **Logs**, and **Vehicles**.

---

## **Installation and Setup**

### **1. Prerequisites**
- **Java 17** or later.
- **MySQL** installed and running.
- **Gradle** installed on your machine.

### **2. Clone the Repository**
```bash
git clone https://github.com/nuharaomesh/crop-monitoring-system-back-end.git
