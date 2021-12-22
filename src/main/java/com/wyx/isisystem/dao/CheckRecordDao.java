package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.CheckRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Wuyuxiang
 * @create 2021-12-21-19:26
 */
@Mapper
public interface CheckRecordDao {
    // 新增检查记录
    int insertCheckRecord(CheckRecord checkRecord);

}
