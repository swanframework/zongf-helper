package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.SortType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 单表查询条件
 * @author: zongf
 * @date: 2019-12-02
 */
public class SingleQueryCondition {

    // 查询字段名
    private List<String> fields;

    // 条件列表
    private List<ColumnCondition> conditions;

    // 排序规则
    private List<SortRule> orderRules;

    public SingleQueryCondition() {
        this.conditions = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    public SingleQueryCondition select(String... fields){
        this.fields.addAll(Arrays.asList(fields));
        return this;
    }

    public SingleQueryCondition and(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public SingleQueryCondition and(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public SingleQueryCondition or(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public SingleQueryCondition or(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public SingleQueryCondition orderBy(String columnName, SortType sortType){
        this.orderRules.add(new SortRule(columnName, sortType));
        return this;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
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





