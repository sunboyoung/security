package com.zms.pojo.permission;

import java.io.Serializable;
import java.util.Date;

public class Permission implements Serializable {
    private Long id;

    private String type; //权限类型 'resource'代表资源权限 'opration'代表操作权限

    private String description; //权限描述

    private Date createtime;//创建时间

    private String scope;//权限范围 all代表所有 only代表其中一种

    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

    public Permission() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String toString() {
        return "Role{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}