package com.wyx.isisystem.service.login.impl;

import com.wyx.isisystem.dao.ClientDao;
import com.wyx.isisystem.entity.Client;
import com.wyx.isisystem.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:09
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private ClientDao clientDao;


    @Override
    public Client login(int id, String password) {
        Client client = clientDao.queryFromLogin(id, password);
        return client;
    }
}
