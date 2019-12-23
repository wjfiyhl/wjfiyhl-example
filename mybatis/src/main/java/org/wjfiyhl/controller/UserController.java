package org.wjfiyhl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;

/**
 * @author: WJF
 * @date: 2019/12/23
 */


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/insert")
    public void insert(User user) {
        userService.insert(user);
    }

    @RequestMapping("/delete")
    public void delete(Long id) {
        userService.delete(id);
    }

    @RequestMapping("/update")
    public void update(User user) {
        userService.update(user);
    }

    @RequestMapping("/select")
    public User select(Long id) {
        return userService.select(id);
    }

}
