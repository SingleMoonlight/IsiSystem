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
    public int editGroup() {
        return 0;
    }

    @Override
    public int removeGroup() {
        return 0;
    }
}
