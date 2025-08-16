package com.myProject.logReader.Entity;

import com.myProject.logReader.enums.Level;
import com.myProject.logReader.enums.Status;
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

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Level level;

    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
    }
}
