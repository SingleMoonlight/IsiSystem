package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.entity.CheckSummary;
import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.check.CheckAnalysisService;
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
 * @create 2021-12-23-16:38
 */
@Controller
@RequestMapping("/checkAnalysis")
public class CheckAnalysisController {

    @Autowired
    private CheckAnalysisService checkAnalysisService;

    @ResponseBody
    @RequestMapping(value = "/getCheckResult", method = RequestMethod.GET)
    public ContentResult getProjectCheckResult(@RequestParam("projectId") String projectId) {
        List<CheckSummary> list = checkAnalysisService.getProjectCheckResult(Integer.parseInt(projectId));

        if (list.size() > 0) {
            return new ContentResult(1, "Get check result successfully!", list);
        }
        return new ContentResult(-1, "Get check result failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/addCheckResult", method = RequestMethod.POST)
    public ContentResult addProjectCheckResult(HttpServletRequest request) {
        String projectId = request.getParameter("projectId");
        String firstId = request.getParameter("firstId");
        String secondId = request.getParameter("secondId");
        String riskLevel = request.getParameter("riskLevel");

        int addResult = checkAnalysisService.addProjectCheckResult(Integer.parseInt(projectId), Integer.parseInt(firstId),
                Integer.parseInt(secondId), Integer.parseInt(riskLevel));

        if (addResult > 0) {
            return new ContentResult(1, "Add check result successfully!");
        }
        return new ContentResult(-1, "Add check result failure!");

    }

}
