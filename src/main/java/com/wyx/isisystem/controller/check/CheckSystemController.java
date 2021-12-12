package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.entity.CheckSystem;
import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.check.CheckSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-11-16:09
 */
@Controller
@RequestMapping("/checkSystem")
public class CheckSystemController {
    @Autowired
    private CheckSystemService checkSystemService;

    @ResponseBody
    @RequestMapping(value = "/getFirstLevel", method = RequestMethod.GET)
    public ContentResult getFirstLevel() {
        // 第一级节点的前置节点为0
        List<CheckSystem> list = checkSystemService.getSubCheckSystemNodes(0);

        if (list.size() != 0) {
            return new ContentResult(1, "Get the first check system node successfully!", list);
        }
        return new ContentResult(-1, "Get the first check system node failure!");
    }


}
