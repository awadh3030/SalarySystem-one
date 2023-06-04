package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Manager;
import com.codeline.sampleProject.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "manager")
public class MangerController {

    @Autowired
    ManagerService managerService ;
    @RequestMapping(value = "findManagerByTeamName", method = RequestMethod.GET)
    public Manager getManagerByTeamName(@RequestParam String teamName){
        return managerService.getManagerByTeamName(teamName);
    }
}
