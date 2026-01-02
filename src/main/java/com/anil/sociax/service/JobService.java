package com.anil.sociax.service;

import com.anil.sociax.model.JobApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    private final List<JobApplication> jobs = new ArrayList<>();
    private int counter = 1;

    public JobApplication addJob(JobApplication job) {
        job.setId(counter++);

        if (job.getStatus() == null || job.getStatus().isBlank()) {
            job.setStatus("APPLIED");
        }

        jobs.add(job);
        return job;
    }

    public List<JobApplication> getAllJobs() {
        return jobs;
    }

    public JobApplication getById(int id) {
        for (JobApplication job : jobs) {
            if (job.getId() != null && job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    public JobApplication updateStatus(int id, String status) {
        JobApplication job = getById(id);
        if (job == null) return null;

        job.setStatus(status);
        return job;
    }
}
