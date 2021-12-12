package com.wyx.isisystem.dao;

import com.wyx.isisystem.entity.CheckSystem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-11-16:12
 */
@Mapper
public interface CheckSystemDao {
    // 查询指定结点的后继检查体系节点
    List<CheckSystem> querySubNodes(int curNodeId);

}
