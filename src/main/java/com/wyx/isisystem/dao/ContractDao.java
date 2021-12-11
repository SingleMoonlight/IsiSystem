package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.Contract;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-09-15:28
 */
@Mapper
public interface ContractDao {
    // 新建合同
    int insertContract(Contract contract);
}
