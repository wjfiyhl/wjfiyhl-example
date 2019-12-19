package org.wjfiyhl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.wjfiyhl.entity.User;

import java.util.List;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

/**
 * 继承BaseMapper获取基本CRUD
 */
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(Long id);

    List<User> findByAge(@Param("age") Integer age);
}
