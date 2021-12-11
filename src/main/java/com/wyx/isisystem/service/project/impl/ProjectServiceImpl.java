package com.wyx.isisystem.service.project.impl;

import com.wyx.isisystem.dao.ProjectDao;
import com.wyx.isisystem.entity.Project;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-13:59
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Override
    public int createProject(String name, String description, String owner, String ownerPhone, int checkGroupId) {
        Project project = new Project();
        project.setName(name);
        project.setDescription(description);
        project.setOwner(owner);
        project.setOwnerPhone(ownerPhone);
        project.setGroupId(checkGroupId);
        project.setState(0);
        project.setRiskValue(0);
        return projectDao.insertProject(project);
    }

    @Override
    public Project findProjectById(int id) {
        Project project = projectDao.queryProject(id);
        return project;
    }

    @Override
    public int editProject(int id, String name, String description, String owner, String ownerPhone, int checkGroupId) {
        Project project = new Project();
        project.setId(id);
        project.setName(name);
        project.setDescription(description);
        project.setOwner(owner);
        project.setOwnerPhone(ownerPhone);
        project.setGroupId(checkGroupId);
        project.setState(0);
        project.setRiskValue(0);
        return projectDao.updateProject(project);
    }

    @Override
    public int removeProject(int id) {
        return projectDao.deleteProject(id);
    }

    @Override
    public int getProjectState(int id) {
        return projectDao.queryProjectState(id);
    }

    @Override
    public int editProjectState(int id, int state) {
        return projectDao.updateProjectState(id, state);
    }


}
