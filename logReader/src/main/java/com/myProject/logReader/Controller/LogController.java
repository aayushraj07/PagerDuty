package com.myProject.logReader.Controller;
import com.myProject.logReader.Dto.LogRequest;
import com.myProject.logReader.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;


    @PostMapping
    public ResponseEntity<String> receiveLogs(@RequestBody List<LogRequest> logRequests) {
        logService.processLog(logRequests);
        return ResponseEntity.ok("Logs processed successfully.");
    }
}
