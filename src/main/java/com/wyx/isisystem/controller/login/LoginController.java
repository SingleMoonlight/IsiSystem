package com.wyx.isisystem.controller.login;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/client", method = RequestMethod.POST)
    private ContentResult clientLogin(HttpServletRequest request) {
        String clientId = request.getParameter("id");
        String clientPsw = request.getParameter("password");

        if (loginService.login(Integer.parseInt(clientId), clientPsw) != null) {
            return new ContentResult(1, "Login successfully!");
        }
        return new ContentResult(-1, "Login failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    private ContentResult staffLogin(HttpServletRequest request) {
        String staffId = request.getParameter("id");
        String staffPsw = request.getParameter("password");

        if (loginService.login(Integer.parseInt(staffId), staffPsw) != null) {
            return new ContentResult(1, "Login successfully!");
        }
        return new ContentResult(-1, "Login failure!");
    }

}
