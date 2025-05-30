package com.myProject.logReader.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "logs")
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    private String eventId;
    private String event;
    private boolean duplicated;
    private LocalDateTime created;

}
