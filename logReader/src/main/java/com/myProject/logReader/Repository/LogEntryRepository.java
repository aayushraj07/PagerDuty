package com.myProject.logReader.Repository;

import com.myProject.logReader.Entity.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface LogEntryRepository extends JpaRepository<LogEntry, Long> {

    List<LogEntry> findAllByCreatedBetween(LocalDateTime start, LocalDateTime end);

}
