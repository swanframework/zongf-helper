package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.DeleteStrategy;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

import java.util.ArrayList;
import java.util.List;

/** 删除条件构建器
 * @author zongf
 * @date 2019-12-13
 */
public class DeleteStrategyBuilder<T extends Enum> {

    private List<ColumnCondition> conditionList;

    public DeleteStrategyBuilder(){
        this.conditionList = new ArrayList<>();
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return DeleteStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public DeleteStrategyBuilder<T> and(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition<T>(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return DeleteStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public DeleteStrategyBuilder<T> and(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return DeleteStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public DeleteStrategyBuilder<T> or(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return DeleteStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public DeleteStrategyBuilder<T> or(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }

    /** 生成删除策略
     * @return DeleteStrategy<T>
     * @author zongf
     * @date 2019-12-14
     */
    public DeleteStrategy<T> build(){
        DeleteStrategy<T> deleteCondition = new DeleteStrategy<>();

        // 如果没有查询条件, 则返回空
        if(conditionList.size() ==0) return null;

        deleteCondition.setConditions(conditionList);
        return deleteCondition;
    }
}
