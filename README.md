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


## Job Application APIs

### Create Job Application

**POST**
http://localhost:8080/api/jobs

**Request Body (JSON):**
```json
{
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}

 Response:

{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "APPLIED"
}
Update Job Status

**PATCH**

http://localhost:8080/api/jobs/1/status
Request Body (JSON):

json
{
  "status": "INTERVIEW"
}
Response:

json

{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "INTERVIEW"
}
Job Not Found Response
json
{
  "error": "Job not found"
}
Community Posts APIs
Create a Post
POST

http://localhost:8080/api/posts
Request Body (JSON):

json
{
  "title": "Roommate needed near Journal Square",
  "content": "Budget $600–1100. Move-in Feb.",
  "category": "HOUSING",
  "city": "Jersey City"
}
<img width="1920" height="1080" alt="{6FAC4F41-BA55-4DB9-B93E-D4D7EE9D3EBD}" src="https://github.com/user-attachments/assets/ff08c858-6684-42bd-9a76-01f96392a433" />
<img width="1920" height="1080" alt="{8302DD09-F7FC-4DAE-8D85-42CBC1C52DEE}" src="https://github.com/user-attachments/assets/5d5b06eb-6f72-4533-b49e-7bf9bf8c319e" />

