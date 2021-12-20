package com.wyx.isisystem.service.tenant;

import com.wyx.isisystem.entity.Tenant;

/**
 * @author Wuyuxiang
 * @create 2021-12-15-17:00
 */
public interface TenantService {
    // 获取租户信息
    Tenant getTenantInfo(int id);
}
