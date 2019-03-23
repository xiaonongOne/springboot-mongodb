package com.example.mongodb.controller;

import com.example.mongodb.bean.User;
import com.example.mongodb.service.UserMongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserController
 * @Author: xz
 * @CreateDate: 2019/3/4 15:20
 * @Version: 1.0
 */
@RestController
@RequestMapping("userMongo")
public class UserController {
    @Autowired
    private UserMongoDbService userMongoDbService;

    @PostMapping("/save")
    @ResponseBody
    public String saveObj(User user) {
        return userMongoDbService.saveObj(user);
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userMongoDbService.findAll();
    }

    @GetMapping("/findOne")
    public User findOne(@RequestParam String id) {
        return userMongoDbService.getUserById(id);
    }

    @GetMapping("/findOneByName")
    public User findOneByName(@RequestParam String userName) {
        return userMongoDbService.getUserByName(userName);
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(User user) {
        return userMongoDbService.updateUser(user);
    }

    @GetMapping("/delById")
    public String delById(@RequestParam String id) {
        return userMongoDbService.deleteUserById(id);
    }
}
