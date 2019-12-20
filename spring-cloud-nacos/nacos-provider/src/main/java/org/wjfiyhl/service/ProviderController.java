package org.wjfiyhl.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: WJF
 * @date: 2019/12/20
 */

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/nacos/{param}")
    public String nacos(@PathVariable("param") String param) {
        return "Hello Nacos!" + param;
    }

}
