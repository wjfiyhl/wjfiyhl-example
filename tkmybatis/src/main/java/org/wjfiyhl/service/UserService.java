package org.wjfiyhl.service;

import org.springframework.stereotype.Service;
import org.wjfiyhl.entity.User;

import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

@Service
public interface UserService {

    public User findOne(Long id);

    public List<User> findList();

}
