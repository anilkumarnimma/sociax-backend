package com.anil.sociax.model;

import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private String role;
    private String status; // APPLIED / INTERVIEW / OFFER / REJECTED

    public Job() {
    }

    public Job(String company, String role, String status) {
        this.company = company;
        this.role = role;
        this.status = status;
    }

    public Long getId() { return id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}