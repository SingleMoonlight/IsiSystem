package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:47
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;



}
