package com.geekster.JobSearchApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobModel {

    @Id
    private Long jobId;
    @NotBlank(message = "Job title can not be blank.")
    private String jobTitle;

    @NotEmpty
    private String jobDescription;

    private String location;

    @Min(value = 20000)
    private Double salary;

    @Email
    @Column(unique = true)
    private String companyEmail;

    private String companyName;

    private String employerName;

    @Enumerated(EnumType.STRING)
    private Type jobType;


    private LocalDate appliedJob;


}
