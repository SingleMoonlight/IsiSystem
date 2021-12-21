package com.wyx.isisystem.service.check;

import com.wyx.isisystem.entity.Project;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:04
 */
public interface CheckRecordService {
    // 获取员工待检查项目合同信息
    List<Project> getUnCheckProjectInfo(int staffId);



}
