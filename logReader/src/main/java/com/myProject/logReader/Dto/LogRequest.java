package com.myProject.logReader.Dto;

import lombok.Data;

@Data
public class LogRequest {
    private String eventId;
    private String event;
}
