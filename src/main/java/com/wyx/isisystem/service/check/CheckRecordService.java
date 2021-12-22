package com.wyx.isisystem.service.check;


import com.wyx.isisystem.entity.CheckRecord;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:04
 */
public interface CheckRecordService {
    // 提交检查记录
    int addCheckRecord(int staffId, int projectId, int firstLevel, int secondLevel, int riskLevel, String picUrl, String description);
    // 获取员工对某项目的检查记录状态
    int getCheckRecordState(int staffId, int projectId);
    // 获取员工对某项目指定检查记录状态的检查记录
    List<CheckRecord> getCheckRecord(int staffId, int projectId, int checkRecordState);

}
