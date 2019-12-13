package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.QueryCondition;
import org.zongf.helper.mybatis.condition.SortRule;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.SortType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zongf
 * @date 2019-12-13
 */
public class QueryConditionBuilder<T extends Enum> {

    private List<ColumnCondition> conditionList;

    private List<T> fieldList;

    private List<SortRule> orderRules;

    private boolean distinct;

    public QueryConditionBuilder(){
        this.conditionList = new ArrayList<>();
        this.fieldList = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    public QueryConditionBuilder<T> distinct(){
        this.distinct = true;
        return this;
    }

    public QueryConditionBuilder<T> select(T... fields){
        this.fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    public QueryConditionBuilder<T> orderBy(String columnName, SortType sortType){
        this.orderRules.add(new SortRule(columnName, sortType));
        return this;
    }

    public QueryConditionBuilder<T> and(String columnName, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public QueryConditionBuilder<T> and(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public QueryConditionBuilder<T> or(String columnName, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public QueryConditionBuilder<T> or(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public QueryCondition<T> build(){
        QueryCondition<T> queryCondition = new QueryCondition<T>();
        queryCondition.setDistinct(distinct);
        if(fieldList.size() > 0){
            queryCondition.setFields(fieldList);
        }
        if(orderRules.size() > 0){
            queryCondition.setOrderRules(orderRules);
        }
        if(conditionList.size() > 0){
            queryCondition.setConditions(conditionList);
        }
        return queryCondition;
    }
}
