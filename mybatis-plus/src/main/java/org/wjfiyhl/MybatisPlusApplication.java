package org.wjfiyhl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: WJF
 * @date: 2019/12/19
 */

@SpringBootApplication
/**
 * 扫描Mapper接口
 */
@MapperScan("org.wjfiyhl.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class,args);
    }
}
