package com.geekster.JobSearchApp.service;

import com.geekster.JobSearchApp.model.JobModel;
import com.geekster.JobSearchApp.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;

    public Iterable<JobModel> getAllJobs() {
        return jobRepo.findAll();
    }


    public String addJob(JobModel job) {
        jobRepo.save(job) ;
        return "New job added!!";

    }

    public String deleteJobById(Long jobId){
        jobRepo.deleteById(jobId);
        return "job deleted successfully of job id : "+ jobId;
    }

    public String updateJobById(Long jobId, Type jobType){
        Optional<JobModel> myJobOpt = jobRepo.findById(jobId);
        JobModel myJob = null;
        if(myJobOpt.isPresent()){
            myJob = myJobOpt.get();
        }
        else{
            return "Job Id not fount!!";
        }
        myJob.setJobType(jobType);
        jobRepo.save(myJob);

        return "job type updated!";
    }

    public Optional<JobModel> getJobById(Long jobId) {
        return jobRepo.findById(jobId);
    }

    public List<JobModel> getJobsByJobType(Type jobType) {
        return jobRepo.findByJobType(jobType);
    }
}
