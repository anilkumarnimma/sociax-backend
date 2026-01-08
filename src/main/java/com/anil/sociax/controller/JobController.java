package com.anil.sociax.controller;

import com.anil.sociax.model.Job;
import com.anil.sociax.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    // Create job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return service.create(job);
    }

    // Get all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return service.getAll();
    }

    // Get job by id
    @GetMapping("/{id}")
    public Object getJobById(@PathVariable int id) {
        Job job = service.getById(id);
        if (job == null) return Map.of("error", "Job not found");
        return job;
    }

    // Update job status
    @PatchMapping("/{id}/status")
    public Object updateStatus(@PathVariable int id, @RequestBody Map<String, String> body) {
        String status = body.get("status");
        Job updated = service.updateStatus(id, status);

        if (updated == null) return Map.of("error", "Job not found");
        return updated;
    }

    // Delete job
    @DeleteMapping("/{id}")
    public Map<String, String> deleteJob(@PathVariable int id) {
        boolean removed = service.deleteById(id);
        if (!removed) return Map.of("error", "Job not found");
        return Map.of("message", "Job deleted");
    }
}
