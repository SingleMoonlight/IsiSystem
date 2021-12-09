package com.wyx.isisystem.service.project;

import com.wyx.isisystem.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:22
 */
public interface ClientService {
    // 查询所有委托方
    List<Client> findAllClient();
    // 录入新的委托方
    int createClient(String name, String description);
}
