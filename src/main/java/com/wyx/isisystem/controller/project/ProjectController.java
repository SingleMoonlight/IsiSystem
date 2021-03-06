package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.entity.Client;
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
import java.util.List;

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
            return new ContentResult(1, "Project create successfully!", projectId);
        }
        return new ContentResult(-1, "Project create failure!");
    }


    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ContentResult getProjectById(@RequestParam("id") String projectId) {
        Project project = new Project();
        project = projectService.getProjectById(Integer.parseInt(projectId));

        if (project != null) {
            return new ContentResult(1, "Get project successfully!", project);
        }

        return new ContentResult(-1, "Get project failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ContentResult editProject(HttpServletRequest request) {
        String projectId = request.getParameter("id");

        int projectState = projectService.getProjectState(Integer.parseInt(projectId));
        // ????????????????????????????????????????????????
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
        // ?????????????????????????????????????????????
        if (projectState != 0) {
            return new ContentResult(-2, "Project in progress or completed!");
        }

        int removeResult = projectService.removeProject(Integer.parseInt(projectId));
        if (removeResult > 0) {
            return new ContentResult(1, "Project remove successfully!");
        }

        return new ContentResult(-1, "Project remove failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ContentResult getAllProject() {
        List<Project> list = projectService.getAllProject();
        if (list.size() != 0) {
            return new ContentResult(1, "Get projects successfully!", list);
        }
        return new ContentResult(-1, "Get projects failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getByGroupAndState", method = RequestMethod.POST)
    public ContentResult getProjectByGroupAndState(@RequestParam("groupId") String groupId, @RequestParam("state") String state) {
        List<Project> list = projectService.getProjectByGroupAndState(Integer.parseInt(groupId), Integer.parseInt(state));
        if (list.size() != 0) {
            return new ContentResult(1, "Get projects successfully!", list);
        }
        return new ContentResult(-1, "Get projects failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getByState", method = RequestMethod.GET)
    public ContentResult getProjectByState(@RequestParam("state") String state) {
        List<Project> list = projectService.getProjectByState(Integer.parseInt(state));
        if (list.size() != 0) {
            return new ContentResult(1, "Get projects successfully!", list);
        }
        return new ContentResult(-1, "Get projects failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getCheckSystem", method = RequestMethod.GET)
    public ContentResult getProjectCheckSystem(@RequestParam("id") String projectId) {
        String checkSystem = projectService.getProjectCheckSystem(Integer.parseInt(projectId));

        if (checkSystem != null) {
            return new ContentResult(1, "Get project check system successfully!", checkSystem);
        }
        return new ContentResult(-1, "Get project check system successfully!");
    }

    @ResponseBody
    @RequestMapping(value = "/editState", method = RequestMethod.POST)
    public ContentResult editProjectState(@RequestParam("id") String projectId, @RequestParam("state")  String state) {
        int editResult = projectService.editProjectState(Integer.parseInt(projectId), Integer.parseInt(state));
        if (editResult > 0) {
            return new ContentResult(1, "Edit project state successfully!");
        }
        return new ContentResult(-1, "Edit project state failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/editRiskValue", method = RequestMethod.POST)
    public ContentResult editProjectRiskValue(@RequestParam("id") String projectId, @RequestParam("riskValue")  String riskValue) {
        int editResult = projectService.editProjectRiskValue(Integer.parseInt(projectId), Integer.parseInt(riskValue));
        if (editResult > 0) {
            return new ContentResult(1, "Edit project risk value successfully!");
        }
        return new ContentResult(-1, "Edit project risk value failure!");
    }

}
