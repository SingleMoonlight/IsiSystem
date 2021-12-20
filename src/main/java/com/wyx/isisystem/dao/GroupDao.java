package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-20-17:01
 */
@Mapper
public interface GroupDao {
    // 新增小组
    int insertGroup(Group group);
    // 修改小组
    int updateGroup(int id);
    // 删除小组
    int deleteGroup(int id);
    // 查询所有小组
    List<Group> queryAllGroup();
    // 查询小组信息
    Group queryGroup(int id);
}
