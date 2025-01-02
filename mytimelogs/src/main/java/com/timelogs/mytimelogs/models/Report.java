package com.timelogs.mytimelogs.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;


@Table(name = "reports")
public class Report {
    @Id
    @Column("id")
    private Long id;

    @Column("filename")
    private String filename;

    @Column("creationdate")
    private LocalDate creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    // Getters and Setters

    public Report() {
    }

    public Report(Long id, String filename, LocalDate creationDate) {
        this.id = id;
        this.filename = filename;
        this.creationDate = creationDate;
    }


}

