package org.wjfiyhl.service;

import org.wjfiyhl.entity.User;

import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

public interface UserService {

    List<User> findAll();

    void add(User user);

    void update(User user);

    void delete(Long id);

    User findById(Long id);

    List<User> findByAge(Integer age);
}
