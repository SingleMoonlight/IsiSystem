package com.wyx.isisystem.service.project;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:00
 */
public interface ContractService {
    // 创建合同
    int createContract(int clientId, int projectId, String checkSystemId);

}
