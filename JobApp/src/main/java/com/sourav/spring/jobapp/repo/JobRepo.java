package com.sourav.spring.jobapp.repo;

import com.sourav.spring.jobapp.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {

    List<JobPost> jobPosts = new ArrayList<>(
            Arrays.asList(
                    new JobPost(1, "Java", "Java " +
                            "experience", 3,
                            new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"))),
                    new JobPost(1, "Java", "Java " +
                            "experience", 3,
                            new ArrayList<>(Arrays.asList("Mango", "Guava", "Ananias"))),
                    new JobPost(1, "Java", "Java " +
                            "experience", 3,
                            new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"))),
                    new JobPost(1, "Java", "Java " +
                            "experience", 3,
                            new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"))),
                    new JobPost(1, "Java", "Java " +
                            "experience", 3,
                            new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange")))
            )
    );

    public List<JobPost> getAllJobs() {
        return jobPosts;
    }

    public void addJob(JobPost jobPost) {
        jobPosts.add(jobPost);
        System.out.println(jobPosts.get(jobPosts.size()-1));
    }
}
