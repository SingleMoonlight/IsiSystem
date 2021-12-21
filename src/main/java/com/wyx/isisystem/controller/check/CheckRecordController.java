package com.wyx.isisystem.controller.check;

import com.wyx.isisystem.service.check.CheckRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wuyuxiang
 * @create 2021-12-21-16:07
 */
@Controller
@RequestMapping("/checkRecord")
public class CheckRecordController {
    @Autowired
    private CheckRecordService checkRecordService;


}
