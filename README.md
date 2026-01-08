# Sociax Backend

This is the backend for **Sociax**, a REST API built using Java and Spring Boot.

Sociax is a platform for international students in the US, providing:
- Job application tracking
- Community posts (housing, jobs, help, etc.)

# The backend currently supports:

Job application tracking

Community posts (housing, jobs, help, etc.)

This project focuses on clean REST API design, proper separation of concerns, and real-world backend practices.

# What This Backend Does
1. Job Application Tracker

Create job applications

View all job applications

Update job status (Applied → Interview → Offer, etc.)

Handles basic error cases (job not found)

2. Community Posts API

Create posts (housing, jobs, general help)

View all posts

Filter posts by category

Designed for student community use cases

# Technologies Used

Java

Spring Boot

Maven

REST APIs

In-memory storage (no database yet)

# How to Run the Project

Clone the repository

Open the project in IntelliJ IDEA

Run the main class:
SociaxApplication.java

Server starts at:
http://localhost:8080

# Job Application APIs
Create Job Application

**POST**
http://localhost:8080/api/jobs

Request Body (JSON):

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

# Update Job Status

**PATCH**
http://localhost:8080/api/jobs/1/status

Request Body (JSON):

{
  "status": "INTERVIEW"
}


Response:

{
  "id": 1,
  "company": "Amazon",
  "role": "Backend Engineer",
  "status": "INTERVIEW"
}

If Job ID Is Not Found
{
  "error": "Job not found"
}

Community Posts APIs
Create a Post

**POST**
http://localhost:8080/api/posts

Request Body (JSON):

{
  "title": "Roommate needed near Journal Square",
  "content": "Budget $600–1100. Move-in Feb.",
  "category": "HOUSING",
  "city": "Jersey City"
}
<img width="1920" height="1080" alt="{6FAC4F41-BA55-4DB9-B93E-D4D7EE9D3EBD}" src="https://github.com/user-attachments/assets/4742b9a4-fa51-4fcf-bb62-092f14c3668b" />

