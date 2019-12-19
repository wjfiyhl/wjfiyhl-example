package org.wjfiyhl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.mapper.UserMapper;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.selectList(null);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }

    /**
     * QueryWrapper为条件构造器
     * @param id
     */
    @Override
    public void delete(Long id) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        userMapper.delete(wrapper);
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public List<User> findByAge(Integer age) {
        return userMapper.findByAge(age);
    }
}
