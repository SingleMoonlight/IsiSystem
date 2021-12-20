package com.wyx.isisystem.service.project.impl;

import com.wyx.isisystem.dao.ClientDao;
import com.wyx.isisystem.entity.Client;
import com.wyx.isisystem.service.project.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:26
 */
@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> getAllClient() {
        return clientDao.queryAllClient();
    }

    @Override
    public int createClient(String name, String description) {
        Client client = new Client();
        client.setClientName(name);
        client.setClientDescription(description);

        clientDao.insertClient(client);
        return client.getClientId();
    }
}
