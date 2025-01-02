package com.timelogs.mytimelogs.models;

public class ActivitySummary {
    private String activityType;
    private Long count;

    public ActivitySummary(String activityType, Long count) {
        this.activityType = activityType;
        this.count = count;
    }

    public ActivitySummary() {
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
