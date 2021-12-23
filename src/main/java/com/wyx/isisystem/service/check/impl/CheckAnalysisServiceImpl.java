package com.wyx.isisystem.service.check.impl;

import com.wyx.isisystem.dao.CheckSummaryDao;
import com.wyx.isisystem.entity.CheckSummary;
import com.wyx.isisystem.service.check.CheckAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:08
 */
@Service("checkAnalysisService")
public class CheckAnalysisServiceImpl implements CheckAnalysisService {

    @Autowired
    private CheckSummaryDao checkSummaryDao;


    @Override
    public List<CheckSummary> getProjectCheckResult(int projectId) {
        return checkSummaryDao.queryProjectCheckResult(projectId);
    }

    @Override
    public int addProjectCheckResult(int projectId, int firstId, int secondId, int riskLevel) {
        CheckSummary checkSummary = new CheckSummary();
        checkSummary.setProjectId(projectId);
        checkSummary.setFirstId(firstId);
        checkSummary.setSecondId(secondId);
        checkSummary.setRiskLevel(riskLevel);

        return checkSummaryDao.insertProjectCheckResult(checkSummary);
    }


}
