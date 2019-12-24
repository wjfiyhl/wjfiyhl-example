package org.wjfiyhl.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/24
 */


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/findOne")
    public User findOne(Long id) {
        return userService.findOne(id);
    }

    @RequestMapping("/findList")
    public List<User> findList() {
        return userService.findList();
    }

}
