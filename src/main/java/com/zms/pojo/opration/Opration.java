package com.zms.pojo.opration;

import java.util.Date;

public class Opration {

    private Long id; //操作id 0代表父级

    private String name; //操作名称

    private Long parent_id; //父级操作id

    private Long parent_resource_id;//父级资源id 如用户操作权限 属于 resource中的用户管理

    private String permission;//权限表示 user:add

    private String description;//操作描述

    private String url;//操作前缀

    private Date createtime;//创建时间

    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用户

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

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getParent_resource_id() {
        return parent_resource_id;
    }

    public void setParent_resource_id(Long parent_resource_id) {
        this.parent_resource_id = parent_resource_id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

        Opration opration = (Opration) o;

        if (id != null ? !id.equals(opration.id) : opration.id != null) return false;

        return true;
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",parent_id'" + parent_id + '\'' +
                ",parent_resource_id'" + parent_resource_id + '\'' +
                ", description='" + description + '\'' +
                ",url='" + url + '\'' +
                ",createtime='" + createtime + '\'' +
                ", available=" + available +
                '}';
    }
}
