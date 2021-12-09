package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:47
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ContentResult createProject(HttpServletRequest request) {
        String projectName = request.getParameter("name");
        String projectDescription = request.getParameter("description");
        String projectOwner = request.getParameter("owner");
        String projectOwnerPhone = request.getParameter("ownerPhone");
        String projectCheckGroupId = request.getParameter("checkGroupId");

        int projectId = projectService.createProject(projectName, projectDescription, projectOwner, projectOwnerPhone, Integer.parseInt(projectCheckGroupId));
        if (projectId > 0) {
            return new ContentResult(1, "Project add successfully!");
        }
        return new ContentResult(-1, "Project add failure!");

    }

}
