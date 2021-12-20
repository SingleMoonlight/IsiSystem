package com.wyx.isisystem.service.staff;

import com.wyx.isisystem.entity.Group;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:26
 */
public interface GroupService {
    // 创建小组
    int createGroup(String name, int groupLeaderId, String staffList);
    // 查询所有小组
    List<Group> getAllGroup();
    // 编辑小组
    int editGroup();
    // 删除小组
    int removeGroup();
}
