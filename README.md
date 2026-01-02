# Sociax Backend

Sociax is a backend REST API built using **Java and Spring Boot**.  
This project is part of a larger idea focused on building useful tools and community features for international students in the United States.

The backend currently supports:
- Job application tracking
- Community posts (housing, jobs, general posts)

This project demonstrates clean backend design, REST API development, and proper separation of controller and service layers.

---

## Technologies Used

- Java
- Spring Boot
- Maven
- REST APIs
- In-memory storage (no database yet)
- Postman (for API testing)

---

## How to Run the Project

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Run the main class: `SociaxApplication.java`
4. Server starts at:  
http://localhost:8080

yaml
Copy code

---

## Job Application APIs

### Create Job Application

**POST**
http://localhost:8080/api/jobs

cpp
Copy code

**Request Body (JSON):**
```json
{
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}

 Response:

json
Copy code
{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}
Update Job Status
PATCH

bash
Copy code
http://localhost:8080/api/jobs/1/status
Request Body (JSON):

json
Copy code
{
  "status": "INTERVIEW"
}
Response:

json
Copy code
{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "INTERVIEW"
}
Job Not Found Response
json
Copy code
{
  "error": "Job not found"
}
Community Posts APIs
Create a Post
POST

bash
Copy code
http://localhost:8080/api/posts
Request Body (JSON):

json
Copy code
{
  "title": "Roommate needed near Journal Square",
  "content": "Budget $600–1100. Move-in Feb.",
  "category": "HOUSING",
  "city": "Jersey City"
}
