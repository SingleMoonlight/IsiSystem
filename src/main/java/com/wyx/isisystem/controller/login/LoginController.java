package com.wyx.isisystem.controller.login;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.login.LoginService;
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

    @ResponseBody
    @RequestMapping(value = "/tenant", method = RequestMethod.POST)
    private ContentResult tenantLogin(@RequestParam("id") String tenantId, @RequestParam("password")String tenantPsw) {
        if (loginService.tenantLogin(Integer.parseInt(tenantId), tenantPsw) != null) {
            return new ContentResult(1, "Login successfully!");
        }
        return new ContentResult(-1, "Login failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    private ContentResult staffLogin(@RequestParam("id") String staffId, @RequestParam("password") String staffPsw) {
        if (loginService.staffLogin(Integer.parseInt(staffId), staffPsw) != null) {
            return new ContentResult(1, "Login successfully!");
        }
        return new ContentResult(-1, "Login failure!");
    }

}
