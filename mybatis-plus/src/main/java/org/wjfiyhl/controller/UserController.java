package org.wjfiyhl.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping("/add")
    public void add(User user) {
        userService.add(user);
    }

    @RequestMapping("/update")
    public void update(User user) {
        userService.update(user);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    /**
     * 通过自定义SQL的方式查询
     * @param id
     * @return User
     */
    @RequestMapping("/findById/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    /**
     * 通过xml文件的方式查询
     * @param age
     * @return List<User>
     */
    @RequestMapping("/findByAge/{age}")
    public List<User> findByAge(@PathVariable("age") Integer age) {
        return userService.findByAge(age);
    }













}
