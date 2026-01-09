package com.anil.sociax.repository;

import com.anil.sociax.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> { }