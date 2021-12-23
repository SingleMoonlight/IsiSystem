package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.CheckRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-21-19:26
 */
@Mapper
public interface CheckRecordDao {
    // 新增检查记录
    int insertCheckRecord(CheckRecord checkRecord);
    // 查询某员工对某个项目的检查记录
    List<CheckRecord> queryCheckRecordByStaffAndProject(int staffId, int projectId);
    // 查询某个项目的检查记录
    List<CheckRecord> queryCheckRecordByProject(int projectId);
    // 设置检查记录的审核状态
    int updateCheckRecordState(int checkRecordId, int state);

}
