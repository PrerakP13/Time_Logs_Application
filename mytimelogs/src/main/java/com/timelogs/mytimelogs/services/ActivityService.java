package com.timelogs.mytimelogs.services;

import com.timelogs.mytimelogs.data.ActivityRepository;
import com.timelogs.mytimelogs.models.Activity;
import com.timelogs.mytimelogs.models.ActivitySummary;
import io.micrometer.common.lang.Nullable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class ActivityService implements ActivityRepository {
   ActivityRepository repos;

   @Value("${report.directory}")
   private String reportDir;

    public ActivityService(ActivityRepository repos) {
        this.repos = repos;
    }

    public void saveActivity(Activity activity){
        activity.setTimestamp(LocalDateTime.now());
        repos.save(activity);
    }

    public void deleteActivities(){
        repos.deleteAll();
    }

    public String generateandsavereport(List<ActivitySummary> activitiesSummaries){
        String activityFile = reportDir + "/ActivityReport_" + LocalDate.now() + ".csv";

        try(FileWriter fileWriter = new FileWriter(activityFile)){
            fileWriter.append("ActivityType, Count\n");
            for(ActivitySummary activitySummary : activitiesSummaries){
                fileWriter.append(activitySummary.getActivityType())
                        .append(",")
                        .append(activitySummary.getCount().toString())
                        .append("\n");
            }
        }catch (IOException e){
                e.printStackTrace();
        }

        return activityFile;
    }

    @PostConstruct
    public void init() {
        File directory = new File(reportDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }




    public Activity getallActivities(){
        return (Activity) repos.findAll();
    }

    /*######################################################################333333333*/

    @Override
    public <S extends Activity> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Activity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Activity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Activity> findAll() {
        return null;
    }

    @Override
    public Iterable<Activity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Activity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Activity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
