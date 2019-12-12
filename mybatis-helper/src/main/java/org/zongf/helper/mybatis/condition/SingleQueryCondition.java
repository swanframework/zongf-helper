package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.SortType;

import java.util.ArrayList;
import java.util.List;

/** 单表查询条件
 * @author: zongf
 * @date: 2019-12-02
 */
public class SingleQueryCondition {

    // 条件列表
    private List<ColumnCondition> conditions;

    // 排序规则
    private List<SortRule> orderRules;

    public SingleQueryCondition() {
        this.conditions = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    public SingleQueryCondition and(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public SingleQueryCondition and(String columnName, OperatorType operatorType, Object value, boolean ignoreCase){
        conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value, ignoreCase));
        return this;
    }

    public SingleQueryCondition or(String columnName, OperatorType operatorType, Object value){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public SingleQueryCondition or(String columnName, OperatorType operatorType, Object value, boolean ignoreCase){
        conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value, ignoreCase));
        return this;
    }

    public SingleQueryCondition orderBy(String columnName, SortType sortType){
        this.orderRules.add(new SortRule(columnName, sortType));
        return this;
    }

}





