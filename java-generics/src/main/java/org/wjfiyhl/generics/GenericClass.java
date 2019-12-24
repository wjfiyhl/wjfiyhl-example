package org.wjfiyhl.generics;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

/**
 * 定义泛型类
 * @param <T>
 */

/**
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
 * 在实例化泛型类时，必须指定T的具体类型。
 * @param <T>
 */
public class GenericClass<T> {

    // key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    // 泛型构造方法形参key的类型也为T，T的类型由外部指定
    public GenericClass(T key) {
        this.key = key;
    }

    // 泛型方法getKey的返回值类型为T，T的类型由外部指定
    public T getKey(){
        return key;
    }

}
