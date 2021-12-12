package com.wyx.isisystem.service.project;

import com.wyx.isisystem.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:48
 */
public interface ProjectService {
    // 创建项目
    int createProject(String name, String description, String owner, String ownerPhone, int checkGroupId);
    // 查询项目
    Project getProjectById(int id);
    // 修改项目
    int editProject(int id, String name, String description, String owner, String ownerPhone, int checkGroupId);
    // 删除未开始的项目
    int removeProject(int id);
    // 查询项目状态
    int getProjectState(int id);
    // 修改项目状态
    int editProjectState(int id, int state);
    // 查询指定状态下的项目数量
    int getStateProjectCount(int state);
    // 查询所有项目
    List<Project> getAllProject();
}
