package org.example.sprint_task_2_spring_boot.controller;

import org.example.sprint_task_2_spring_boot.model.ApplicationRequest;
import org.example.sprint_task_2_spring_boot.repositiry.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;


    @GetMapping(value = "/home")
    public String getHomePage(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAll();
        model.addAttribute("applicationRequest", applicationRequestList);
        return "home";
    }
    @GetMapping(value = "/addRequest")
    public String addRequestPage(Model model){
        return "addRequest";
    }
    @PostMapping(value="/addRequest")
    public String addRequestSubmit(@RequestParam(value="username") String username,
                                   @RequestParam(value="courseName") String courseName,
                                   @RequestParam(value = "phoneNumber") String phoneNumber,
                                   @RequestParam(value = "comments") String comments){
        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(username);
        applicationRequest.setCourseName(courseName);
        applicationRequest.setPhone(phoneNumber);
        applicationRequest.setCommentary(comments);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/home";
    }
    @GetMapping(value = "/detailsRequest/{id}")
    public String getdetailsRequest(@PathVariable(value = "id") Long id,
                                    Model model){
        ApplicationRequest applicationRequest = applicationRequestRepository.findById(id).orElseThrow();
        model.addAttribute("appDetail", applicationRequest);
        return "detailsRequest";
    }
    @PostMapping(value = "/removeRequest/{id}")
    public String removeRequestById(@PathVariable(value = "id") Long id){
        applicationRequestRepository.deleteById(id);
        return "redirect:/home";
    }
    @PostMapping(value = "/changeHandled/{id}")
    public String changeHandled(@PathVariable(value = "id") Long id){


        ApplicationRequest applicationRequest = applicationRequestRepository.findById(id).orElseThrow();
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/home";
    }
}
