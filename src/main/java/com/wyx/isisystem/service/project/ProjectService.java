package com.wyx.isisystem.service.project;

import org.springframework.stereotype.Service;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:48
 */
public interface ProjectService {
    // 创建项目
    int createProject(String name, String description, String owner, String ownerPhone, int checkGroupId);
    // 查询项目

    // 修改项目

    // 删除项目

}
