package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.QueryStrategy;
import org.zongf.helper.mybatis.condition.OrderRule;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.OrderType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 查询条件构建器
 * @author zongf
 * @date 2019-12-13
 */
public class QueryStrategyBuilder<T extends Enum> {

    // 是否去重
    private boolean distinct;

    // 需要查询的条件列表
    private List<T> fieldList;

    // 查询条件
    private List<ColumnCondition> conditionList;

    // 排序规则
    private List<OrderRule> orderRules;

    public QueryStrategyBuilder(){
        this.conditionList = new ArrayList<>();
        this.fieldList = new ArrayList<>();
        this.orderRules = new ArrayList<>();
    }

    /** 是否去重
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> distinct(){
        this.distinct = true;
        return this;
    }

    /** 指定查询的属性
     * @param fields 需要查询的属性
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> select(T... fields){
        this.fieldList.addAll(Arrays.asList(fields));
        return this;
    }

    /** 添加排序策略
     * @param field 排序属性
     * @param sortType 排序类型
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> orderBy(T field, OrderType sortType){
        this.orderRules.add(new OrderRule(field, sortType));
        return this;
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> and(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition<T>(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> and(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> or(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return QueryStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public QueryStrategyBuilder<T> or(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }

    public QueryStrategy<T> build(){
        QueryStrategy<T> queryCondition = new QueryStrategy<T>();
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
