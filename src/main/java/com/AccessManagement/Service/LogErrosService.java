package com.AccessManagement.Service;

import org.springframework.stereotype.Service;

@Service
public interface LogErrosService {
    void saveLogsToFile(String log);
}
