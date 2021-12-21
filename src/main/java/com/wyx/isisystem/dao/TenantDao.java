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
    // 查询租户信息
    Tenant queryTenantInfo(int id);
    // 查询租户密码
    String queryPassword(int id, int type);
    //修改密码（登录表信息）
    int updateTenantFromLogin(int id, String password, int type);
}
