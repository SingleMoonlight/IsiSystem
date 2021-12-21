package com.wyx.isisystem.controller.tenant;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.tenant.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wuyuxiang
 * @create 2021-12-21-15:57
 */
@Controller
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @ResponseBody
    @RequestMapping(value = "/getPassword", method = RequestMethod.GET)
    public ContentResult getPassword(@RequestParam("id") String tenantId) {
        String psw = tenantService.getPassword(Integer.parseInt(tenantId));

        if (psw != null) {
            return new ContentResult(1, "Get password successfully!", psw);
        }
        return new ContentResult(-1, "Get password failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ContentResult changePassword(@RequestParam("id") String tenantId, @RequestParam("password") String newPassword) {
        int changeResult = tenantService.changePassword(Integer.parseInt(tenantId), newPassword);

        if (changeResult > 0) {
            return new ContentResult(1, "Change password successfully!");
        }
        return new ContentResult(-1, "Change password failure!");
    }
}
