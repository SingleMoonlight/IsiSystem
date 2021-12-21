package com.wyx.isisystem.service.check.impl;

import com.wyx.isisystem.dao.CheckRecordDao;
import com.wyx.isisystem.entity.Project;
import com.wyx.isisystem.service.check.CheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:05
 */
@Service("checkRecordService")
public class CheckRecordServiceImpl implements CheckRecordService {
    @Autowired
    private CheckRecordDao checkRecordDao;

    @Override
    public List<Project> getUnCheckProjectInfo(int staffId) {
        return null;
    }
}
