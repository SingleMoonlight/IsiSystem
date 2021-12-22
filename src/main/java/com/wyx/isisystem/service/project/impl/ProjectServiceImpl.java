package com.wyx.isisystem.service.project.impl;

import com.wyx.isisystem.dao.ProjectDao;
import com.wyx.isisystem.dao.StaffDao;
import com.wyx.isisystem.entity.Project;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        projectDao.insertProject(project);
        return project.getId();
    }

    @Override
    public Project getProjectById(int id) {
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

    @Override
    public int getStateProjectCount(int state) {
        return projectDao.queryStateProjectCount(state);
    }

    @Override
    public List<Project> getAllProject() {
        return projectDao.queryAllProject();
    }

    @Override
    public List<Project> getProjectByGroupAndState(int groupId, int state) {
        return projectDao.queryProjectByGroupAndState(groupId, state);
    }

    @Override
    public List<Project> getProjectByState(int state) {
        return projectDao.queryProjectByState(state);
    }

    @Override
    public String getProjectCheckSystem(int projectId) {
        return projectDao.queryProjectCheckSystem(projectId);
    }

}
