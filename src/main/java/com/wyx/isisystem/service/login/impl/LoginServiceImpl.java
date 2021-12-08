package com.wyx.isisystem.service.login.impl;

import com.wyx.isisystem.dao.ClientDao;
import com.wyx.isisystem.dao.StaffDao;
import com.wyx.isisystem.entity.Client;
import com.wyx.isisystem.entity.Staff;
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
    @Autowired
    private StaffDao staffDao;

    @Override
    public Client clientLogin(int id, String password) {
        Client client = clientDao.queryFromLogin(id, password, 1);
        return client;
    }

    @Override
    public Staff staffLogin(int id, String password) {
        Staff staff = staffDao.queryFromLogin(id, password, 2);
        return staff;
    }
}
