package org.wjfiyhl.example;

import org.wjfiyhl.generics.GenericClass;
import org.wjfiyhl.generics.Main;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

public class ClassExample extends Main {

    @Override
    public void invoke() {
        String key = "wjf";
        GenericClass<String> generic = new GenericClass<>(key);

        System.out.println(generic.getKey());
    }

}
