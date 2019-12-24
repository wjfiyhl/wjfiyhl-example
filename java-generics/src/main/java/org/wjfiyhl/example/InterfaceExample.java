package org.wjfiyhl.example;

import org.wjfiyhl.generics.GenericInterface;
import org.wjfiyhl.generics.Main;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

public class InterfaceExample extends Main {

    @Override
    public void invoke() {

        GenericInterface<String> generic = new GenericInterface<String>() {
            @Override
            public String name() {
                return "wjf";
            }

            @Override
            public <E> void get(E e) {
                System.out.println("Hello");
            }
        };

    }
}
