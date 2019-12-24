package org.wjfiyhl.service.impl;

import org.springframework.stereotype.Service;
import org.wjfiyhl.entity.User;
import org.wjfiyhl.mapper.UserMainMapper;
import org.wjfiyhl.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMainMapper userMainMapper;

    @Override
    public User findOne(Long id) {
        return userMainMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findList() {
        return userMainMapper.findList();
    }
}
