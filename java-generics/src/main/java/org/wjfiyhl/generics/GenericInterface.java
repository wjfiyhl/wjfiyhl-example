package org.wjfiyhl.generics;


/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 定义泛型接口
 * @param <Y>
 * @param <W>
 */
public interface GenericInterface<Y, W> {

    default String[] name(Y y, W w) {
        return new String[]{y.getClass().getName(),y.getClass().getName()};
    }

}
