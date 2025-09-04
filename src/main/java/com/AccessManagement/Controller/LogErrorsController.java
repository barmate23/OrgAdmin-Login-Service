package com.AccessManagement.Controller;

import com.AccessManagement.Request.InputLogMessage;
import com.AccessManagement.Service.LogErrosService;
import com.AccessManagement.Utils.ConstantsForAPIs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LogErrorsController {

    @Autowired
    private LogErrosService logErrosService;

    @PostMapping(ConstantsForAPIs.SAVE_ERROR_LOG)
    public String saveText(@RequestBody InputLogMessage input) {
        String formattedText = input.getMessage() + " : [" + input.getTimestamp() + "]";
        logErrosService.saveLogsToFile(formattedText);
        return "Text saved successfully!";
    }
}
