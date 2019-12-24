package org.wjfiyhl.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.wjfiyhl.entity.User;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

@Mapper
public interface UserMainMapper extends MainMapper<User> {
}
