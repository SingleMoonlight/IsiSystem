package com.wyx.isisystem.controller.staff;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.entity.Staff;
import com.wyx.isisystem.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-16-16:46
 */
@Controller
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ContentResult addStaff(HttpServletRequest request) {
        String staffName = request.getParameter("name");
        String staffGender = request.getParameter("gender");
        String staffPhone = request.getParameter("phone");
        String staffDefaultPassword = request.getParameter("password");

        int staffId = staffService.addStaff(staffName, staffGender, staffPhone, staffDefaultPassword);
        if (staffId > 0) {
            return new ContentResult(1, "Add staff successfully!");
        }
        return new ContentResult(-1, "Add staff failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/batchAdd", method = RequestMethod.POST)
    public ContentResult batchAddStaff(@RequestParam("staffForm") MultipartFile file, @RequestParam("password") String staffDefaultPassword) {
        int lastStaffId = staffService.batchAddStaff(file, staffDefaultPassword);

        if (lastStaffId > 0) {
            return new ContentResult(1, "Add staffs successfully!");
        }
        //return new ContentResult(-2, "The function is not available!");
        return new ContentResult(-1, "Add staffs failure!");
    }


}
