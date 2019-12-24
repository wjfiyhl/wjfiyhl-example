package org.wjfiyhl.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: WJF
 * @date: 2019/12/24
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class User {

    @Column(name = "ID")
    @Id
    Long id;

    @Column(name = "NAME")
    String name;

    @Column(name = "SEX")
    String sex;

}
