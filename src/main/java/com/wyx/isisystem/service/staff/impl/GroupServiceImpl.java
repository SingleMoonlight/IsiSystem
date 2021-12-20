package com.wyx.isisystem.service.staff.impl;

import com.wyx.isisystem.dao.GroupDao;
import com.wyx.isisystem.dao.StaffDao;
import com.wyx.isisystem.entity.Group;
import com.wyx.isisystem.entity.Staff;
import com.wyx.isisystem.service.staff.GroupService;
import com.wyx.isisystem.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:27
 */
@Service("groupServiceImpl")
public class GroupServiceImpl implements GroupService {
    @Autowired
    private StaffService staffService;
    @Autowired
    private GroupDao groupDao;

    @Override
    public Group getGroupInfo(int id) {
        return groupDao.queryGroup(id);
    }

    @Override
    @Transactional
    public int createGroup(String name, int groupLeaderId, String staffList) {
        Group group = new Group();
        group.setName(name);
        group.setLeaderId(groupLeaderId);

        // 新增小组
        groupDao.insertGroup(group);
        int groupId = group.getId();
        // 更新组员小组属性信息
        String[] staffs = staffList.split(",");
        for (String staffId : staffs) {
            staffService.changeStaffGroup(Integer.parseInt(staffId), groupId);
        }

        return groupId;
    }

    @Override
    public List<Group> getAllGroup() {
        return groupDao.queryAllGroup();
    }

    @Override
    public int editGroupName(int id, String name) {
        return groupDao.updateGroupName(id, name);
    }

    @Override
    @Transactional
    public int editGroupLeader(int id, int leaderId) {
        int oldLeaderId = getGroupInfo(id).getId();
        // 设置旧组长为普通员工
        staffService.changeStaffLeaderFlag(oldLeaderId, 0);
        // 设置新员工为组长
        staffService.changeStaffLeaderFlag(leaderId, 1);
        staffService.changeStaffGroup(leaderId, id);
        // 更新小组信息
        return groupDao.updateGroupLeader(id, leaderId);
    }

    @Override
    @Transactional
    public int removeGroup(int groupId) {
        // 设置原小组组员为未分配状态
        List<Staff> list = staffService.getStaffByGroup(groupId);
        for (Staff staff : list) {
            staffService.changeStaffGroup(staff.getId(), 0);
        }
        // 设置原小组组长为普通员工
        int oldLeaderId = getGroupInfo(groupId).getId();
        staffService.changeStaffLeaderFlag(oldLeaderId, 0);
        // 删除小组信息
        return groupDao.deleteGroup(groupId);
    }


}
