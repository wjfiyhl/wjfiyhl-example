package org.wjfiyhl.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: WJF
 * @date: 2019/12/20
 */

@Component
@ResponseBody
public class HelloService {

    @RequestMapping("/hello/{param}")
    public String nacos(@PathVariable("param") String param) {
        return "Hello Nacos!" + param;
    }

}
