package com.anil.sociax.service;

import com.anil.sociax.model.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    private final List<Job> jobs = new ArrayList<>();
    private int nextId = 1;

    public JobService() {
        // sample data
        jobs.add(new Job(nextId++, "Amazon", "Backend Engineer", "NYC", "APPLIED"));
        jobs.add(new Job(nextId++, "Wells Fargo", "Software Developer", "NJ", "INTERVIEW"));
    }

    public Job create(Job job) {
        job.setId(nextId++);
        if (job.getStatus() == null || job.getStatus().isBlank()) {
            job.setStatus("APPLIED");
        }
        jobs.add(job);
        return job;
    }

    public List<Job> getAll() {
        return jobs;
    }

    public Job getById(int id) {
        for (Job j : jobs) {
            if (j.getId() != null && j.getId() == id) return j;
        }
        return null;
    }

    public Job updateStatus(int id, String status) {
        Job existing = getById(id);
        if (existing == null) return null;

        existing.setStatus(status);
        return existing;
    }

    public boolean deleteById(int id) {
        Job existing = getById(id);
        if (existing == null) return false;

        jobs.remove(existing);
        return true;
    }
}
