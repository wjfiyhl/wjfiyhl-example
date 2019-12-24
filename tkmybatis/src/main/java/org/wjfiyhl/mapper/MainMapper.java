package org.wjfiyhl.mapper;

import tk.mybatis.mapper.common.*;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

public interface MainMapper<T> extends BaseMapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T>, ExampleMapper<T> {
}
