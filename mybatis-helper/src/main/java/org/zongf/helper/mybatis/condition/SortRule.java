package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.SortType;

/** 排序规则
 * @author: zongf
 * @date: 2019-12-04
 */
public class SortRule {

    // 排序字段名称
    private String columnName;

    // 排序类型
    private SortType sortType;

    public SortRule() {
        super();
    }

    public SortRule(String columnName, SortType sortType) {
        super();
        this.columnName = columnName;
        this.sortType = sortType;
    }

    public void setColumnName(String columnName){
        this.columnName=columnName;
    }

    public String getColumnName(){
        return this.columnName;
    }

    public void setSortType(SortType sortType){
        this.sortType=sortType;
    }

    public SortType getSortType(){
        return this.sortType;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() + ": {columnName:" + columnName + ", sortType:" + sortType  + "}";
    }

}