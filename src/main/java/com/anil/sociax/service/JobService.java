package com.anil.sociax.service;

import com.anil.sociax.model.Job;
import com.anil.sociax.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // CREATE job
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // GET all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // DELETE job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}