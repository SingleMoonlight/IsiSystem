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
}
