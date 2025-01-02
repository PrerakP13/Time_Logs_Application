package com.timelogs.mytimelogs.services;

import com.timelogs.mytimelogs.data.ReportRepository;
import com.timelogs.mytimelogs.models.Activity;
import com.timelogs.mytimelogs.models.ActivitySummary;
import com.timelogs.mytimelogs.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    private ActivityService activityService;

    @Autowired
    private ReportRepository reportRepository;


    public ReportService(ActivityService activityService) {
        this.activityService = activityService;
    }

    @Scheduled(fixedRate = 3600000) //every hour
    public void askforactivity(){
        System.out.println("Reminder: What are you doing right now?");
        // You can extend this to notify the front-end.
    }

    @Scheduled(cron = "0 0 0 */7 * *")
    public void generateweeklyreport(){
        List<Activity> activities = (List<Activity>) activityService.getallActivities();

        //a code to group all the same activities together and get the counts so it can be used for creation of the graph
        Map<String, Long> activityCounts = activities.stream()
                        .collect(Collectors.groupingBy(Activity::getActivity,Collectors.counting()));

        List<ActivitySummary> activitySummaries = activityCounts.entrySet().stream()
                        .map(entry -> new ActivitySummary(entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList());


        String fileName = activityService.generateandsavereport(activitySummaries); // Save report metadata
        Report report = new Report();
        report.setFilename(fileName);
        report.setCreationDate(LocalDate.now());
        reportRepository.save(report);

        activityService.deleteActivities(); }
    }

