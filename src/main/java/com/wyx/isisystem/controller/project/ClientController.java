package com.wyx.isisystem.controller.project;

import com.wyx.isisystem.entity.Client;
import com.wyx.isisystem.entity.ContentResult;
import com.wyx.isisystem.service.project.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Wuyuxiang
 * @create 2021-12-08-22:30
 */
@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ContentResult getAllClient() {
        List<Client> list = clientService.getAllClient();
        if (list.size() != 0) {
            return new ContentResult(1, "Get clients successfully!", list);
        }
        return new ContentResult(-1, "Get clients failure!");
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ContentResult createClient(@RequestParam("name") String clientName, @RequestParam("description") String clientDescription) {
        int clientId = clientService.createClient(clientName, clientDescription);
        if (clientId > 0) {
            return new ContentResult(1, "Client create successfully!");
        }
        return new ContentResult(-1, "Client create failure!");
    }
}
