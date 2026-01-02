# Sociax Backend

This is the backend for **Sociax**, a simple REST API built using Java and Spring Boot.  
Sociax is intended to be part of a larger platform for international students in the US, starting with a job application tracker.

This backend project demonstrates how to design and implement REST APIs, properly separate controller and service logic, and handle basic operations like create, read, and update.

---

## Technologies Used

- Java
- Spring Boot
- Maven
- REST APIs
- In-memory storage (no database yet)

---

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run the main class: `SociaxApplication.java`
4. The server will start on: `http://localhost:8080`

---
# create job application 
POST
http://localhost:8080/api/jobs

Body (JSON):

{
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}


Expected output:

{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}
**Update Job Status**

PATCH
http://localhost:8080/api/jobs/1/status

Body (JSON):

{
  "status": "INTERVIEW"
}


Expected output:

{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "INTERVIEW"
}


If ID not found:

{
  "error": "Job not found"
}
