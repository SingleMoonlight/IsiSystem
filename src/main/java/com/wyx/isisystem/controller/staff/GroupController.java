package com.wyx.isisystem.controller.staff;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.entity.Group;
import com.wyx.isisystem.service.staff.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-20-15:09
 */
@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ContentResult createGroup(@RequestParam("name") String groupName, @RequestParam("leaderId") String groupLeaderId, @RequestParam("staffs") String staffs) {
        int groupId = groupService.createGroup(groupName, Integer.parseInt(groupLeaderId), staffs);

        if (groupId > 0) {
            return new ContentResult(1, "Create group successfully!");
        }
        return new ContentResult(-1, "Create group failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ContentResult getAllGroup() {
        List<Group> list = groupService.getAllGroup();

        if (list.size() > 0) {
            return new ContentResult(1, "Get all groups successfully!", list);
        }
        return new ContentResult(-1, "Get all groups failure!", list);
    }

    @ResponseBody
    @RequestMapping(value = "/editName", method = RequestMethod.POST)
    public ContentResult editGroupName(@RequestParam("id") String groupId, @RequestParam("name") String groupName) {
        int editResult = groupService.editGroupName(Integer.parseInt(groupId), groupName);
        if (editResult > 0) {
            return new ContentResult(1, "Edit group name successfully!");
        }
        return new ContentResult(-1, "Edit group name failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/editLeader", method = RequestMethod.POST)
    public ContentResult editGroupLeader(@RequestParam("id") String id, @RequestParam("leaderId") String leaderId) {
        int editResult = groupService.editGroupLeader(Integer.parseInt(id), Integer.parseInt(leaderId));
        if (editResult > 0) {
            return new ContentResult(1, "Edit group leader successfully!");
        }
        return new ContentResult(-1, "Edit group leader failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ContentResult removeGroup(@RequestParam("id") String groupId) {
        int removeResult = groupService.removeGroup(Integer.parseInt(groupId));
        if (removeResult > 0) {
            return new ContentResult(1, "Remove group successfully!");
        }
        return new ContentResult(-1, "Remove group failure!");
    }


}
