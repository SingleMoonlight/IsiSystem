package com.wyx.isisystem.service.check;

import com.wyx.isisystem.entity.CheckSummary;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:08
 */
public interface CheckAnalysisService {
    // 获取项目的检查结果
    List<CheckSummary> getProjectCheckResult(int projectId);
    // 添加项目检查结果
    int addProjectCheckResult(int projectId, int firstId, int secondId, int riskLevel);
}
