package com.sourav.spring.jobapplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;
    private List<String> postTechStack;

    // Explicit all-args constructor added to ensure compilation when Lombok
    // annotation processing isn't available in the build environment.
    public JobPost(int postId, String postProfile, String postDesc, Integer reqExperience, List<String> postTechStack) {
        this.postId = postId;
        this.postProfile = postProfile;
        this.postDesc = postDesc;
        this.reqExperience = reqExperience;
        this.postTechStack = postTechStack;
    }

}
