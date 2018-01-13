package com.zms.to.page;

/**
 * @author zms
 * @date 2018/01/01 17:28:00
 * @description 分页类封装
 */
public class Page {
    private Integer pageNo;
    //    默认每页显示条数
    private Integer pageSize;
    //    是否启用分页功能
    private Boolean defaultUseFlag;
    //    是否检测当前页码的合法性（大于最大页码或小于最小页码都不合法）
    private Boolean defaultCheckFlag;
    //    当前sql查询的总记录数，回填
    private Integer totalCount = 1;
    //    当前sql查询实现分页后的总页数，回填
    private Integer totalPageNo = 1;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo > totalPageNo) {
            pageNo = 1;
        }
        if (pageNo == null) {
            pageNo = 0;
        }
        this.pageNo = pageNo < 0 ? 0 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    public Boolean getDefaultUseFlag() {
        return defaultUseFlag;
    }

    public void setDefaultUseFlag(Boolean defaultUseFlag) {
        this.defaultUseFlag = defaultUseFlag;
    }

    public Boolean getDefaultCheckFlag() {
        return defaultCheckFlag;
    }

    public void setDefaultCheckFlag(Boolean defaultCheckFlag) {
        this.defaultCheckFlag = defaultCheckFlag;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPageNo() {
        return totalPageNo;
    }

    public void setTotalPageNo(Integer totalPageNo) {
        this.totalPageNo = totalPageNo;
    }

    public Boolean isDefaultCheckFlag() {
        return defaultCheckFlag;
    }

    public Boolean isDefaultUseFlag() {
        return defaultUseFlag;
    }
}