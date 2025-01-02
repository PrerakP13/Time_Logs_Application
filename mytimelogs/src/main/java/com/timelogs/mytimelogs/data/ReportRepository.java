package com.timelogs.mytimelogs.data;

import com.timelogs.mytimelogs.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
