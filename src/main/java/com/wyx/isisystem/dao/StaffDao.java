package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-13:15
 */
@Mapper
public interface StaffDao {
    // 从登陆表查询员工
    Staff queryFromLogin(int id, String password, int type);
}
