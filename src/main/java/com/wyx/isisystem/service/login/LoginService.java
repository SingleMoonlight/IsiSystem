package com.wyx.isisystem.service.login;

import com.wyx.isisystem.entity.Client;
import com.wyx.isisystem.entity.Staff;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:06
 */
public interface LoginService {
    // 委托方登录
    Client clientLogin(int id, String password);
    // 员工登录
    Staff staffLogin(int id, String password);


}
