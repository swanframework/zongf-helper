package org.zongf.helper.mybatis.pager;

/**
 * @author zongf
 * @date 2019-12-12
 */
public class PageBounds {

    /** 页码 **/
    private int page;

    /** 每页大小 **/
    private int pageSize;

    public PageBounds() {
    }

    public PageBounds(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public static PageBounds of(int page, int pageSize) {
        return new PageBounds(page, pageSize);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}