package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Client;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:03
 */
@Mapper
public interface ClientDao {
    // 查询所有委托方
    List<Client> queryAllClient();
    // 新增委托方
    int insertClient(Client client);
}
