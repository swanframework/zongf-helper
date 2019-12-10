package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.SortType;

import java.util.ArrayList;
import java.util.List;

/** 查询条件
 * @author: zongf
 * @date: 2019-12-02
 */
public class SimpleQueryCondition {

    // 条件列表
    private List<ColumnCondition> conditions;

    // 排序规则
    private List<SortRule> orderRules;

    public SimpleQueryCondition() {
        this.conditions = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    public SimpleQueryCondition and(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public SimpleQueryCondition or(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public SimpleQueryCondition orderBy(String columnName, SortType sortType){
        this.orderRules.add(new SortRule(columnName, sortType));
        return this;
    }

    public List<ColumnCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ColumnCondition> conditions) {
        this.conditions = conditions;
    }

    public List<SortRule> getOrderRules() {
        return orderRules;
    }

    public void setOrderRules(List<SortRule> orderRules) {
        this.orderRules = orderRules;
    }
}





