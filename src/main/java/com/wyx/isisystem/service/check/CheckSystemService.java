package com.wyx.isisystem.service.check;

import com.wyx.isisystem.entity.CheckSystem;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-14:04
 */
public interface CheckSystemService {
    // 获取指定结点的后继检查体系节点
    List<CheckSystem> getSubCheckSystemNodes(int curNodeId);
    // 获取检查体系节点信息
    CheckSystem getCheckSystemNodeInfo(int id);
    // 新增检查体系节点
    int createCheckSystemNode(int preNodeId, String description);
    // 删除指定的检查体系节点
    int removeCheckSystem(int id);
    // 修改检查体系节点
    int editCheckSystemId(int id, String description);

}
