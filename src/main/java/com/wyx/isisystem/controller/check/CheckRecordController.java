package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.entity.CheckRecord;
import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.check.CheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
            return new ContentResult(1, "Add check record successfully!");
        }

        return new ContentResult(-1, "Add check record failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getStaffCheckState", method = RequestMethod.POST)
    public ContentResult getStaffCheckState(@RequestParam("staffId") String staffId, @RequestParam("projectId") String projectId) {
        int state = checkRecordService.getCheckRecordState(Integer.parseInt(staffId), Integer.parseInt(projectId));

        return new ContentResult(1, "Get check record state successfully!", state);
    }

    @ResponseBody
    @RequestMapping(value = "/getByProject", method = RequestMethod.POST)
    public ContentResult getCheckRecordByProject(@RequestParam("projectId") String projectId) {
        List<CheckRecord> list = checkRecordService.getCheckRecordByProject(Integer.parseInt(projectId));

        if (list.size() > 0) {
            return new ContentResult(1, "Get check record successfully!", list);
        }
        return new ContentResult(-1, "Get check record failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/editState", method = RequestMethod.POST)
    public ContentResult editCheckRecordState(@RequestParam("checkRecordId") String checkRecordId, @RequestParam("state") String state) {
        int editResult = checkRecordService.editCheckRecordState(Integer.parseInt(checkRecordId), Integer.parseInt(state));
        if (editResult > 0) {
            return new ContentResult(1, "Edit check record state successfully!");
        }
        return new ContentResult(-1, "Edit check record state failure!");
    }
}
