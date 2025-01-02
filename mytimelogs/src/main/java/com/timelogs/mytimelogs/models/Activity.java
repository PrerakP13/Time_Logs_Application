package com.timelogs.mytimelogs.models;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Table("timelogstable")
public class Activity {

    @Id
    @Column("id")
    private long id;

    @Column("timestamp")
    private LocalDateTime timestamp;

    @Column("activity")
    private String activity;

    public Activity(long id, LocalDateTime timestamp, String activity) {
        this.id = id;
        this.timestamp = timestamp;
        this.activity = activity;
    }

    public Activity() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
