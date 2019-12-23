package org.wjfiyhl.service;

import org.springframework.stereotype.Service;
import org.wjfiyhl.entity.User;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

@Service
public interface UserService {

    void insert(User user);

    void delete(Long id);

    void update(User user);

    User select(Long id);
}
