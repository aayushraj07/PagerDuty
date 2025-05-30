package com.myProject.logReader.Dto;

import lombok.Data;
import java.time.Instant;

@Data
public class LogEntryDTO {
    private Instant timestamp;
    private String level;
    private String service;
    private String message;
}
