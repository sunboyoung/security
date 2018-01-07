package com.zms.pojo.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Resource implements Serializable {

    private Long id; //编号

    private String title; //资源名称

    private ResourceType type; //资源类型

    private String url; //资源路径

    private int priority;//排序

    private Long parent_id;//父级id 0为没有

    private String clue;//查找线索

    private int distance;//离顶级菜单的距离

    private String icon;//图标

    private String spread;//是否展开 默认0不展开 1展开

    private Boolean available = Boolean.FALSE;

    @SuppressWarnings({"unchecked", "rawtypes"})
    private List<Resource> children = new ArrayList(); //子级菜单

    public String getTitle() {
        return title;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public List<Resource> getChildren() {
        return children;
    }

    public void setChildren(List<Resource> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", priority='" + priority + '\'' +
                ",url='" + url + '\'' +
                ", parentId='" + parent_id + '\'' +
                ", clue=" + clue +
                ",distance=" + distance +
                ", =" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;

        if (id != null ? !id.equals(resource.id) : resource.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public static enum ResourceType {
        menu("菜单"), button("按钮");

        private final String info;
        private ResourceType(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }
}
