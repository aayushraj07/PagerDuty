package com.myProject.logReader.Dto;

import com.myProject.logReader.enums.Level;
import com.myProject.logReader.enums.Status;
import lombok.Data;

@Data
public class LogRequest {
    private String eventId;
    private String event;
    private Status status;
    private Level level;
}
