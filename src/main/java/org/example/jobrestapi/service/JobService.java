package org.example.jobrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.example.jobrestapi.model.JobPost;
import org.example.jobrestapi.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JobService {
    @Autowired
    public JobRepo repo;




    public List<JobPost> getAllJobs() {
        return repo.findAll();

    }






    public void addJob(JobPost jobPost) {
        repo.save(jobPost);

    }





    public JobPost getJob(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }




    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);

    }




    public void deleteJob(int postId) {
        repo.deleteById(postId);

    }


    public void load(){

        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
                        new JobPost(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
                        new JobPost(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
                        new JobPost(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
                        new JobPost(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))

                ));

        repo.saveAll(jobs);

    }

    public  List<JobPost> search(String keyword){
        return  repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }

}