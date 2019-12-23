package org.wjfiyhl.service.impl;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.mapper.UserMapper;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;

/**
 * @author: WJF
 * @date: 2019/12/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User select(Long id) {
        return userMapper.select(id);
    }
}
