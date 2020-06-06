package com.taocaicai.urlroles.entity;

import java.io.Serializable;

/**
 * @author Oakley
 * @version 0.0.1
 * @Date 2020-06-07 03:18:3:18
 */
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String nameZh;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }
}
