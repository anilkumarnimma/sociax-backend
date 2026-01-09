package com.anil.sociax.service;

import com.anil.sociax.model.Job;
import com.anil.sociax.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Create job
    public Job createJob(Job job) {
        if (job.getStatus() == null || job.getStatus().isBlank()) {
            job.setStatus("APPLIED");
        }
        return jobRepository.save(job);
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Update job status
    public Job updateJobStatus(Long id, String status) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isEmpty()) {
            return null;
        }
        Job job = optionalJob.get();
        job.setStatus(status);
        return jobRepository.save(job);
    }

    // Delete job
    public boolean deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            return false;
        }
        jobRepository.deleteById(id);
        return true;
    }
}