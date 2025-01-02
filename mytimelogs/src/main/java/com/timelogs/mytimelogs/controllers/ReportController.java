package com.timelogs.mytimelogs.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ReportController {
    @Value("${report.directory}")
    private String reportDirectory;

    @GetMapping("/reports")
    public String listReports(Model model) {
        File folder = new File(reportDirectory);
        File[] files = folder.listFiles((dir, name) -> name.startsWith("activity_report_"));
        model.addAttribute("reports", files);
        return "reportList";
    }

    @GetMapping("/download")
    public void downloadReport(@RequestParam("filename") String filename, HttpServletResponse response) {
        try {
            File file = new File(reportDirectory + "/" + filename);
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            Files.copy(file.toPath(), response.getOutputStream());
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

