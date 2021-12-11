package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Project;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-16:34
 */
@Mapper
public interface ProjectDao {
    // 新建项目
    int insertProject(Project project);
    // 查询项目
    Project queryProject(int id);
    // 更新项目
    int updateProject(Project project);
    // 删除项目
    int deleteProject(int id);
    // 更新项目状态
    int updateProjectState(int id, int state);
    // 查询项目状态
    int queryProjectState(int id);

}
