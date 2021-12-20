package com.wyx.isisystem.service.tenant.impl;

import com.wyx.isisystem.dao.TenantDao;
import com.wyx.isisystem.entity.Tenant;
import com.wyx.isisystem.service.tenant.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wuyuxiang
 * @create 2021-12-15-17:00
 */
@Service("tenantService")
public class TenantServiceImpl implements TenantService {
    @Autowired
    private TenantDao tenantDao;

    @Override
    public Tenant getTenantInfo(int id) {
        return tenantDao.queryTenantInfo(id);
    }
}
