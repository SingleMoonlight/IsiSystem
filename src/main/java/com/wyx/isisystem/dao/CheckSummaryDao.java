package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.CheckSummary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-23-16:37
 */
@Mapper
public interface CheckSummaryDao {
    // 查询项目的检查汇总结果
    List<CheckSummary> queryProjectCheckResult(int projectId);
    // 新增项目检查结果
    int insertProjectCheckResult(CheckSummary checkSummary);

}
