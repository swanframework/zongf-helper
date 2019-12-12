package org.zongf.helper.mybatis.condition2;

import org.zongf.helper.mybatis.enums.SortType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 查询条件
 * @author: zongf
 * @date: 2019-12-02
 */
public class QueryCondition extends UpdateCondition {

    // 是否去重
    private boolean distinct;

    // 查询字段名
    private List<String> fields;

    // 排序规则
    private List<SortRule> orderRules;

    public QueryCondition() {
        this.orderRules = new ArrayList<>();
    }

    public QueryCondition select(String... fields){
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    public QueryCondition orderBy(String columnName, SortType sortType){
        this.orderRules.add(new SortRule(columnName, sortType));
        return this;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<SortRule> getOrderRules() {
        return orderRules;
    }

    public void setOrderRules(List<SortRule> orderRules) {
        this.orderRules = orderRules;
    }

}





