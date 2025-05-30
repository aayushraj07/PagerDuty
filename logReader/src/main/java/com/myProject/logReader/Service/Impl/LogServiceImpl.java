package com.myProject.logReader.Service.Impl;

import com.myProject.logReader.Dto.LogRequest;
import com.myProject.logReader.Entity.LogEntry;
import com.myProject.logReader.Repository.LogEntryRepository;
import com.myProject.logReader.Service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogEntryRepository logEntryRepository;

    @Override
    public void processLog(List<LogRequest> logRequests) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveMinutesAgo = now.minusMinutes(5);

        // Step 1: Fetch all logs in the past 5 minutes
        List<LogEntry> recentLogs = logEntryRepository.findAllByCreatedBetween(fiveMinutesAgo, now);

        // Step 2: Group them by eventId+event
        Map<String, List<LogEntry>> recentMap = new HashMap<>();
        for (LogEntry log : recentLogs) {
            String key = log.getEventId() + "::" + log.getEvent();
            recentMap.computeIfAbsent(key, k -> new ArrayList<>()).add(log);
        }

        // Step 3: Process new requests
        for (LogRequest request : logRequests) {
            String key = request.getEventId() + "::" + request.getEvent();

            if (recentMap.containsKey(key)) {
                // Duplicate exists — update all matching entries
                List<LogEntry> duplicates = recentMap.get(key);
                for (LogEntry dup : duplicates) {
                    if (!dup.isDuplicated()) {
                        dup.setDuplicated(true);
                        logEntryRepository.save(dup);
                    }
                }
            } else {
                // No duplicate — insert as new entry
                LogEntry newLog = new LogEntry();
                newLog.setEventId(request.getEventId());
                newLog.setEvent(request.getEvent());
                newLog.setDuplicated(false);
                logEntryRepository.save(newLog);
            }
        }
    }
}
