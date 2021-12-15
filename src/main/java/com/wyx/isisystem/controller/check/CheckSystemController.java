package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.entity.CheckSystem;
import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.check.CheckSystemService;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-11-16:09
 */
@Controller
@RequestMapping("/checkSystem")
public class CheckSystemController {
    @Autowired
    private CheckSystemService checkSystemService;
    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/getFirstLevel", method = RequestMethod.GET)
    public ContentResult getFirstLevel() {
        // 第一级节点的前置节点为0
        List<CheckSystem> list = checkSystemService.getSubCheckSystemNodes(0);

        if (list.size() != 0) {
            return new ContentResult(1, "Get the first check system node successfully!", list);
        }
        return new ContentResult(-1, "Get the first check system node failure!");
    }


    @ResponseBody
    @RequestMapping(value = "/getNodeInfo", method = RequestMethod.GET)
    public ContentResult getNodeInfo(@RequestParam("nodeId") String curNodeId) {
        CheckSystem checkSystem = checkSystemService.getCheckSystemNodeInfo(Integer.parseInt(curNodeId));

        if (checkSystem != null) {
            return new ContentResult(1, "Get the check system node successfully!", checkSystem);
        }
        return new ContentResult(-1, "Get the check system node failure!");

    }

    @ResponseBody
    @RequestMapping(value = "/createNode", method = RequestMethod.POST)
    public ContentResult createNode(@RequestParam("preNodeId") String preNodeId, @RequestParam("description") String description) {
        if (projectService.getStateProjectCount(1) > 0) {
            return new ContentResult(-2, "A node cannot be added because a project is in progress!");
        }

        int curNodeId = checkSystemService.createCheckSystemNode(Integer.parseInt(preNodeId), description);

        if (curNodeId > 0) {
            return new ContentResult(1, "Create the check system node successfully!");
        }
        return new ContentResult(-1, "Create the check system node failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/removeNode", method = RequestMethod.POST)
    public ContentResult removeNode(@RequestParam("nodeId") String curNodeId) {
        if (projectService.getStateProjectCount(1) > 0) {
            return new ContentResult(-2, "A node cannot be removed because a project is in progress!");
        }

        int removeResult = checkSystemService.removeCheckSystem(Integer.parseInt(curNodeId));

        if (removeResult > 0) {
            return new ContentResult(1, "Remove the check system node successfully!");
        }
        return new ContentResult(-1, "Remove the check system node failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/editNode", method = RequestMethod.POST)
    public ContentResult editNode(@RequestParam("curNodeId") String curNodeId, @RequestParam("description") String description) {
        if (projectService.getStateProjectCount(1) > 0) {
            return new ContentResult(-2, "A node cannot be edited because a project is in progress!");
        }

        int editResult = checkSystemService.editCheckSystemId(Integer.parseInt(curNodeId), description);

        if (editResult > 0) {
            return new ContentResult(1, "Edit the check system node successfully!");
        }
        return new ContentResult(-1, "Edit the check system node failure!");
    }


}
