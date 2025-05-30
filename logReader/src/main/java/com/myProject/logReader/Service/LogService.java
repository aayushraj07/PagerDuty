package com.myProject.logReader.Service;
import com.myProject.logReader.Dto.LogRequest;

import java.util.List;

public interface LogService {
    void processLog(List<LogRequest> logRequests);
}
