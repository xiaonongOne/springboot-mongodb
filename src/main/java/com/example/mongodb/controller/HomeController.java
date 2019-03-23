package com.example.mongodb.controller;

import com.example.mongodb.bean.User;
import com.example.mongodb.service.UserMongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: HomeController
 * @Author: xz
 * @CreateDate: 2019/3/10 16:06
 * @Version: 1.0
 */
@Controller
public class HomeController {
    @Autowired
    private UserMongoDbService userMongoDbService;

    @RequestMapping({"/","/index"})
    public String index(Model map) {
        List<User> all = userMongoDbService.findAll();
        map.addAttribute("userList",all);
        return "/index";
    }

    @RequestMapping({"/add"})
    public String add(Model map) {
        return "/add";
    }

    @RequestMapping({"/update"})
    public String update(String id,Model map) {
        User user = userMongoDbService.getUserById(id);
        map.addAttribute("user",user);
        return "/update";
    }

    @RequestMapping({"/delById"})
    public String del(String id,Model map) {
        String result = userMongoDbService.deleteUserById(id);
        System.out.println(result);
        List<User> all = userMongoDbService.findAll();
        map.addAttribute("userList",all);
        return "/index";
    }
}
