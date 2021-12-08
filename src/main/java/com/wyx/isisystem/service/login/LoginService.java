package com.wyx.isisystem.service.login;

import com.wyx.isisystem.entity.Client;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:06
 */
public interface LoginService {

    Client login(int id, String password);

}
