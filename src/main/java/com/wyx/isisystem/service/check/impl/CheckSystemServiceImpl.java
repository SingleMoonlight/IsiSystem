package com.wyx.isisystem.service.check.impl;

import com.wyx.isisystem.dao.CheckSystemDao;
import com.wyx.isisystem.entity.CheckSystem;
import com.wyx.isisystem.service.check.CheckSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:05
 */
@Service("checkSystemService")
public class CheckSystemServiceImpl implements CheckSystemService {
    @Autowired
    private CheckSystemDao checkSystemDao;


    @Override
    public List<CheckSystem> getSubCheckSystemNodes(int curNodeId) {
        return checkSystemDao.querySubNodes(curNodeId);
    }

    @Override
    public CheckSystem getCheckSystemNodeInfo(int id) {
        return null;
    }

    @Override
    public int createCheckSystemNode(int preNodeId, String description) {
        return 0;
    }

    @Override
    public int removeCheckSystem(int id) {
        return 0;
    }


}
