package com.geekster.JobSearchApp.repository;


import com.geekster.JobSearchApp.model.JobModel;
import com.geekster.JobSearchApp.model.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository <JobModel,Long> {

    List<JobModel> findByJobType(Type jobType);

}
