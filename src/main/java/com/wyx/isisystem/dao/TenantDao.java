package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Tenant;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-11:31
 */
@Mapper
public interface TenantDao {
    // 从登录表查询租户
    Tenant queryFromLogin(int id, String password, int type);

}
