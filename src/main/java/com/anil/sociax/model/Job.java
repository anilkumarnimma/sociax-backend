package com.anil.sociax.model;

public class Job {

    private Integer id;
    private String company;
    private String role;
    private String location;
    private String status;   // APPLIED / INTERVIEW / OFFER / REJECTED

    public Job() {
    }

    public Job(Integer id, String company, String role, String location, String status) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.location = location;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
