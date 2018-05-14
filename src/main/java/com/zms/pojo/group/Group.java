package com.zms.pojo.group;

import java.util.Date;

/**
 * @Author:zms
 * @Description:用户组
 * @Date:2018/4/12 16:24
 */
public class Group {
    private Long id;//用户组id

    private String name;//用户组

    private String description;//用户组描述

    private Date createtime;//创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
