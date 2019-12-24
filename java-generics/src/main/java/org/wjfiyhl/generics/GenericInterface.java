package org.wjfiyhl.generics;


/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 定义泛型接口
 * @param <T>
 */
public interface GenericInterface<T> {

    public T name();

    /**
     * 定义泛型方法
     * @param e
     * @param <E>
     */
    public <E> void get(E e);

}
