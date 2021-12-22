package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.check.CheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wuyuxiang
 * @create 2021-12-21-16:07
 */
@Controller
@RequestMapping("/checkRecord")
public class CheckRecordController {
    @Autowired
    private CheckRecordService checkRecordService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ContentResult addCheckRecord(HttpServletRequest request) {
        String staffId = request.getParameter("staffId");
        String projectId = request.getParameter("projectId");
        String firstLevel = request.getParameter("firstLevel");
        String secondLevel = request.getParameter("secondLevel");
        String riskLevel = request.getParameter("riskLevel");
        String picUrl = request.getParameter("picUrl");
        String description = request.getParameter("description");

        int checkRecordId = checkRecordService.addCheckRecord(Integer.parseInt(staffId), Integer.parseInt(projectId),
                Integer.parseInt(firstLevel), Integer.parseInt(secondLevel), Integer.parseInt(riskLevel), picUrl, description);
        if (checkRecordId > 0) {
            return new ContentResult(1, "Add check record successfully!!");
        }

        return new ContentResult(-1, "Add check record failure!");
    }
}
