package org.wjfiyhl.generics;

/**
 * @author: WJF
 * @date: 2019/12/23
 */

public class Main {

    public static void main(String[] args) {
        GenericInterface<String,Integer> gen = new GenericClass<>();
        String str = new String("1");
        Integer integer = 100;
        try {
            integer = new Integer(str);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }finally {
            gen.name(str,integer);
            System.out.println(gen);
        }
        System.out.println(str);
        System.out.println(integer);
    }

}
