package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.project.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Wuyuxiang
 * @create 2021-12-09-15:32
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ContentResult createContract(@RequestParam("clientId") String clientId, @RequestParam("projectId") String projectId, @RequestParam("checkSystemId") String checkSystemId) {
        int contractId = contractService.createContract(Integer.parseInt(clientId), Integer.parseInt(projectId), Integer.parseInt(checkSystemId));

        if (contractId > 0) {
            return new ContentResult(1, "Contract create successfully!");
        }
        return new ContentResult(-1, "Contract create failure!");
    }
}
