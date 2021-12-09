package com.wyx.isisystem.service.login;

import com.wyx.isisystem.entity.Tenant;
import com.wyx.isisystem.entity.Staff;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:06
 */
public interface LoginService {
    // 租户登录
    Tenant tenantLogin(int id, String password);
    // 员工登录
    Staff staffLogin(int id, String password);


}
