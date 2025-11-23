package com.sourav.spring.jobapplication;

import com.sourav.spring.jobapplication.model.JobPost;
import com.sourav.spring.jobapplication.service.JobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @RequestMapping({"/", "home"})
    public String home() {
        return "home";
    }

    @GetMapping("addjob")
    public String addJob() {
        return "addjob";
    }

    @PostMapping("handleForm")
    public String handleForm(JobPost jobPost) {
        jobService.addJob(jobPost);
        return "success";
    }

    @GetMapping("viewalljobs")
    public String viewJobs(Model model) {
        List<JobPost> jobs = jobService.getAllJobs();
        model.addAttribute("jobPosts", jobs);
        return "viewalljobs";
    }
}
