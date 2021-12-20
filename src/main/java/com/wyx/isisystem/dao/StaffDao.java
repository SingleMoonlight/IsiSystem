package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-13:15
 */
@Mapper
public interface StaffDao {
    // 从登陆表查询员工，类型1为租户，2为员工
    Staff queryFromLogin(int id, String password, int type);
    // 员工信息录入登录表
    int insertStaffToLogin(int id, String password, int type);

    // 查询员工信息
    Staff queryStaffInfo(int id);
    // 新增员工
    int insertStaff(Staff staff);
    // 批量新增，性能更好但是不符合要求
    int insertStaffs(List<Staff> staffs);
    // 修改员工信息
    int updateStaffInfo(Staff staff);
    // 删除员工
    int deleteStaff(int id);

}
