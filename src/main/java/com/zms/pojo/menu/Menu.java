package com.zms.pojo.menu;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {

    private Long id;
    private String title; //导航栏标题
    private String description; //导航栏标题描述
    private String icon;//导航栏图标
    private Boolean spread = Boolean.TRUE;//是否显示,默认0显示,1不显示
    private List<ChildrenMenu> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getSpread() {
        return spread;
    }

    public void setSpread(Boolean spread) {
        this.spread = spread;
    }

    public List<ChildrenMenu> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenMenu> children) {
        this.children = children;
    }


}
