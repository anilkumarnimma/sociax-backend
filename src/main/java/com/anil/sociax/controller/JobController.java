package com.anil.sociax.controller;

import com.anil.sociax.model.JobApplication;
import com.anil.sociax.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Sociax backend is running";
    }

    // Create job
    @PostMapping
    public JobApplication createJob(@RequestBody JobApplication job) {
        return service.addJob(job);
    }

    // Get all jobs
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return service.getAllJobs();
    }

    // Get one job by id
    @GetMapping("/{id}")
    public Object getJobById(@PathVariable int id) {
        JobApplication job = service.getById(id);
        if (job == null) return Map.of("error", "Job not found");
        return job;
    }

    // Update status
    @PatchMapping("/{id}/status")
    public Object updateStatus(@PathVariable int id, @RequestBody Map<String, String> body) {
        String status = body.get("status");
        JobApplication updated = service.updateStatus(id, status);

        if (updated == null) {
            return Map.of("error", "Job not found");
        }
        return updated;
    }
}
