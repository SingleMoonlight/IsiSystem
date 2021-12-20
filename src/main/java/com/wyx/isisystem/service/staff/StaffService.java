package com.wyx.isisystem.service.staff;

import com.wyx.isisystem.entity.Staff;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:26
 */
public interface StaffService {
    // 获取员工信息
    Staff getStaffInfo(int id);
    // 录入单个员工
    int addStaff(String name, String gender, String phone, String password);
    // 批量录入员工信息
    int batchAddStaff(MultipartFile file, String password);
    // 修编辑员工信息
    int editStaffInfo(int id, String name, String gender, String phone);
    // 删除员工
    int removeStaffInfo(int id);
    // 修改密码
    int changePassword(int id, String password);

}
