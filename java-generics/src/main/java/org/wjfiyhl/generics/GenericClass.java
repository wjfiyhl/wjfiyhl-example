package org.wjfiyhl.generics;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 定义泛型类
 * @param <W>
 */
public class GenericClass<Y, W> implements GenericInterface<Y, W> {

    @Override
    public String toString() {
        return "值为1则true，值为100则false";
    }
}
