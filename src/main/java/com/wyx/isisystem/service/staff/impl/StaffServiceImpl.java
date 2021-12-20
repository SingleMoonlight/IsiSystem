package com.wyx.isisystem.service.staff.impl;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.wyx.isisystem.dao.StaffDao;
import com.wyx.isisystem.entity.Staff;
import com.wyx.isisystem.service.staff.StaffService;
import com.wyx.isisystem.utils.StaffExcelDataListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:27
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff getStaffInfo(int id) {
        return staffDao.queryStaffInfo(id);
    }

    @Override
    @Transactional
    public int addStaff(String name, String gender, String phone, String password) {
        Staff staff = new Staff();
        staff.setName(name);
        staff.setGender(gender);
        staff.setPhone(phone);

        // 插入员工信息到员工表
        staffDao.insertStaff(staff);
        int staffId = staff.getId();
        // 插入登录信息到登陆表
        staffDao.insertStaffToLogin(staffId, password, 2);
        return staffId;
    }

    @Override
    @Transactional
    public int batchAddStaff(MultipartFile file, String password) {
        int addResult = -1;
        // 读取excel文件
        StaffExcelDataListener<LinkedHashMap<Integer, String>> listener = new StaffExcelDataListener<>();
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcelFactory.read(file.getInputStream(), null, listener).headRowNumber(1).build();
        } catch (IOException e) {
            return addResult;
        }
        excelReader.readAll();
        List<LinkedHashMap<Integer, String>> list = listener.getData();
        excelReader.finish();

        // 插入数据库中
        for (int i = 0; i < list.size(); i++) {
            LinkedHashMap<Integer, String> map = list.get(i);
            Staff staff = new Staff();
            staff.setName(map.get(0));
            staff.setGender(map.get(1));
            staff.setPhone(map.get(2));

            // 插入员工信息到员工表
            staffDao.insertStaff(staff);
            int staffId = staff.getId();
            // 插入登录信息到登陆表
            staffDao.insertStaffToLogin(staffId, password, 2);

            addResult = staffId;
        }

        return addResult;
    }

    @Override
    public int editStaffInfo(int id, String name, String gender, String phone) {
        Staff staff = new Staff();
        staff.setId(id);
        staff.setName(name);
        staff.setGender(gender);
        staff.setPhone(phone);

        return staffDao.updateStaffInfo(staff);
    }

    @Override
    @Transactional
    public int removeStaffInfo(int id) {
        staffDao.deleteStaffFromLogin(id, 2);
        return staffDao.deleteStaff(id);
    }

    @Override
    public int changePassword(int id, String password) {
        return staffDao.updateStaffFromLogin(id, password, 2);
    }

    @Override
    public String getPassword(int id) {
        return staffDao.queryPassword(id);
    }

    @Override
    public List<Staff> getStaffByGroup(int groupId) {
        return staffDao.queryStaffByGroup(groupId);
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.queryAllStaff();
    }

    @Override
    public int changeStaffGroup(int staffId, int groupId) {
        return staffDao.updateStaffGroup(staffId, groupId);
    }

}
