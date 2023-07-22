package com.geekster.JobSearchApp.controller;

import com.geekster.JobSearchApp.model.JobModel;
import com.geekster.JobSearchApp.model.Type;
import com.geekster.JobSearchApp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JobController {
    @Autowired
    JobService jobService;


    //read
    @GetMapping("/jobs")
    public Iterable<JobModel> getAllJobs(){
        return jobService.getAllJobs();
    }

    @PostMapping("/jobs")
    public String addJob(@RequestBody JobModel job){
        return jobService.addJob(job);
    }

    @GetMapping("/jobs/{jobId}")
    public Optional<JobModel> getJobById(@PathVariable Long jobId){
        return jobService.getJobById(jobId);
    }

    @DeleteMapping("/jobs/{jobId}")
    public String deleteJobById(@PathVariable Long jobId){
        return jobService.deleteJobById(jobId);
    }

    @GetMapping("/jobs/jobType/{type}")
    public List<JobModel> getJobsByJobType(@PathVariable Type jobType){
        return jobService.getJobsByJobType(jobType);
    }
}
