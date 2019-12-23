package org.wjfiyhl.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wjfiyhl.entity.User;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USER VALUES(NULL,name,sex)")
    void insert(User user);

    @Delete("DELETE FROM USER WHERE ID = #{id}")
    void delete(Long id);

    void update(@Param("user") User user);

    User select(Long id);
}
