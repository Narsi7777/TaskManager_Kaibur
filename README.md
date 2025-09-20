# Task 1 - Java Backend and REST API

## Project Description
This project implements a Spring Boot application providing REST APIs to manage "Task" objects.
Each Task represents a shell command that can be executed.

---

## Technologies Used
- Java 21
- Spring Boot 3
- Maven
- MongoDB
- Postman

---

## Running the Application

1. Make sure MongoDB is running on your system.
2. Build the project:

```bash
cd taskmanager
mvn clean install
```
---

# API TESTING 

## Creating Task
- Method: PUT
- URL: /tasks

<img width="959" height="599" alt="Put _task_1" src="https://github.com/user-attachments/assets/4be4bfc3-62cb-4d26-b1d9-a58fe0ee01d0" />

## Get All Taska
- Method: GET
- URL: /tasks
<img width="959" height="599" alt="get_1" src="https://github.com/user-attachments/assets/eb2e6c1d-3a67-455c-a022-076376a2e5f2" />

## Search Task by Name
- Method: GET
- URL: /tasks/search?name=Hello
  
  <img width="959" height="599" alt="get_by_name" src="https://github.com/user-attachments/assets/f7660510-34ac-461a-ae7e-a9bc1a75ffe4" />

## Run a Task Command
- Method: PUT
- URL: /tasks/1/run
<img width="959" height="599" alt="put 3" src="https://github.com/user-attachments/assets/6eeae5f5-8a77-4f6d-89ba-4942a9d446df" />


## Delete a Task
- Method: DELETE
- URL: /tasks/1

  <img width="954" height="599" alt="delete_by_id" src="https://github.com/user-attachments/assets/4fed92f2-2bf7-4881-b6f6-dfcb5cf38593" />

