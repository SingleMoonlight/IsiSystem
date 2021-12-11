package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.entity.Project;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
            return new ContentResult(1, "Project create successfully!");
        }
        return new ContentResult(-1, "Project create failure!");
    }


    @ResponseBody
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public ContentResult findProjectById(@RequestParam("id") String projectId) {
        Project project = new Project();
        project = projectService.findProjectById(Integer.parseInt(projectId));

        if (project != null) {
            return new ContentResult(1, "Find project successfully!", project);
        }

        return new ContentResult(-1, "Find project failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ContentResult editProject(HttpServletRequest request) {
        String projectId = request.getParameter("id");

        int projectState = projectService.getProjectState(Integer.parseInt(projectId));
        // 项目正在进行或已经完成，不能编辑
        if (projectState != 0) {
            return new ContentResult(-2, "Project in progress or completed!");
        }

        String projectName = request.getParameter("name");
        String projectDescription = request.getParameter("description");
        String projectOwner = request.getParameter("owner");
        String projectOwnerPhone = request.getParameter("ownerPhone");
        String projectCheckGroupId = request.getParameter("checkGroupId");

        int editResult = projectService.editProject(Integer.parseInt(projectId), projectName, projectDescription, projectOwner, projectOwnerPhone, Integer.parseInt(projectCheckGroupId));
        if (editResult > 0) {
            return new ContentResult(1, "Project edit successfully!");
        }

        return new ContentResult(-1, "Project edit failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ContentResult removeProject(@RequestParam("id") String projectId) {
        int projectState = projectService.getProjectState(Integer.parseInt(projectId));
        // 项目正在进行或已完成，不能删除
        if (projectState != 0) {
            return new ContentResult(-2, "Project in progress or completed!");
        }

        int removeResult = projectService.removeProject(Integer.parseInt(projectId));
        if (removeResult > 0) {
            return new ContentResult(1, "Project remove successfully!");
        }

        return new ContentResult(-1, "Project remove failure!");
    }

}
