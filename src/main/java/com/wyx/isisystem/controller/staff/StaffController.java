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

    @ResponseBody
    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ContentResult getStaffById(@RequestParam("id") String staffId) {
        Staff staff = staffService.getStaffInfo(Integer.parseInt(staffId));

        if (staff != null) {
            return new ContentResult(1, "Get staff successfully!", staff);
        }
        return new ContentResult(-1, "Get staff failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ContentResult editStaffInfo(HttpServletRequest request) {
        String staffId = request.getParameter("id");
        String staffName = request.getParameter("name");
        String staffGender = request.getParameter("gender");
        String staffPhone = request.getParameter("phone");

        int editResult = staffService.editStaffInfo(Integer.parseInt(staffId), staffName, staffGender, staffPhone);
        if (editResult > 0) {
            return new ContentResult(1, "Edit staff successfully!");
        }
        return new ContentResult(-1, "Edit staff failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ContentResult removeStaff(@RequestParam("id") String staffId) {
        int removeResult = staffService.removeStaffInfo(Integer.parseInt(staffId));
        if (removeResult > 0) {
            return new ContentResult(1, "Staff remove successfully!");
        }
        return new ContentResult(-1, "Staff remove failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ContentResult changePassword(@RequestParam("id") String staffId, @RequestParam("password") String password) {
        int changeResult = staffService.changePassword(Integer.parseInt(staffId), password);

        if (changeResult > 0) {
            return new ContentResult(1, "Change password successfully!");
        }
        return new ContentResult(-1, "Change password failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getPassword", method = RequestMethod.GET)
    public ContentResult getPassword(@RequestParam("id") String staffId) {
        String psw = staffService.getPassword(Integer.parseInt(staffId));

        if (psw != null) {
            return new ContentResult(1, "Get password successfully!", psw);
        }
        return new ContentResult(-1, "Get password failure!");

    }

    @ResponseBody
    @RequestMapping(value = "/getByGroup", method = RequestMethod.GET)
    public ContentResult getStaffByGroup(@RequestParam("groupId") String groupId) {
        List<Staff> list = staffService.getStaffByGroup(Integer.parseInt(groupId));

        if (list.size() > 0) {
            return new ContentResult(1, "Get staff by group successfully!", list);
        }
        return new ContentResult(-1, "Get staff by group failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ContentResult getAllStaff() {
        List<Staff> list = staffService.getAllStaff();

        if (list.size() > 0) {
            return new ContentResult(1, "Get staff successfully!", list);
        }
        return new ContentResult(-1, "Get staff failure!");
    }

}
