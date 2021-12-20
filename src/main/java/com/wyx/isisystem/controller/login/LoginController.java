package com.wyx.isisystem.controller.login;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.entity.Staff;
import com.wyx.isisystem.entity.Tenant;
import com.wyx.isisystem.service.login.LoginService;
import com.wyx.isisystem.service.staff.StaffService;
import com.wyx.isisystem.service.tenant.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Wuyuxiang
 * @create 2021-12-07-22:04
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private TenantService tenantService;

    @ResponseBody
    @RequestMapping(value = "/tenant", method = RequestMethod.POST)
    public ContentResult tenantLogin(@RequestParam("id") String tenantId, @RequestParam("password")String tenantPsw) {
        Tenant tenant = loginService.tenantLogin(Integer.parseInt(tenantId), tenantPsw);
        if (tenant != null) {
            tenant = tenantService.getTenantInfo(Integer.parseInt(tenantId));
            return new ContentResult(1, "Login successfully!", tenant);
        }
        return new ContentResult(-1, "Login failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public ContentResult staffLogin(@RequestParam("id") String staffId, @RequestParam("password") String staffPsw) {
        Staff staff = loginService.staffLogin(Integer.parseInt(staffId), staffPsw);
        if (staff != null) {
            staff = staffService.getStaffInfo(Integer.parseInt(staffId));
            return new ContentResult(1, "Login successfully!", staff);
        }
        return new ContentResult(-1, "Login failure!");
    }

}
