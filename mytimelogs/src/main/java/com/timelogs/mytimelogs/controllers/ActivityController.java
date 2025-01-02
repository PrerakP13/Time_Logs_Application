package com.timelogs.mytimelogs.controllers;


import com.timelogs.mytimelogs.models.Activity;
import com.timelogs.mytimelogs.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mytimelogs")
public class ActivityController {
    @Autowired
    ActivityService activityService;

    @GetMapping("/")
    public List<Activity> showActivity(Model model){

        return (List<Activity>) activityService.getallActivities();
    }

    @PostMapping("/save")
    public void saveActivity(@RequestBody Activity activity){
        activityService.saveActivity(activity);

    }

    @GetMapping("/summary")
    public Map<String,Long> showSummary(Model model){
        List<Activity> activities = (List<Activity>) activityService.getallActivities();

        return activities.stream()
                .collect(Collectors.groupingBy(Activity::getActivity, Collectors.counting()));
    }
}
