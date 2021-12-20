package com.wyx.isisystem.service.project.impl;

import com.wyx.isisystem.dao.ContractDao;
import com.wyx.isisystem.entity.Contract;
import com.wyx.isisystem.service.project.ContractService;
import com.wyx.isisystem.service.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:00
 */
@Service("contractService")
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ProjectService projectService;

    @Override
    @Transactional
    public int createContract(int clientId, int projectId, String checkSystemId) {
        Contract contract = new Contract();
        contract.setClientId(clientId);
        contract.setProjectId(projectId);
        contract.setCheckSystemId(checkSystemId);

        // 新建合同
        contractDao.insertContract(contract);
        int contractId = contract.getId();
        // 更新合同对应的项目状态为正在进行
        projectService.editProjectState(projectId, 1);

        return contractId;
    }

}
