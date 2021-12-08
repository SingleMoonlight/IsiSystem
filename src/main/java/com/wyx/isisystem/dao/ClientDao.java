package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Client;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-11:31
 */
@Mapper
public interface ClientDao {

    Client queryFromLogin(int id, String password);

}
