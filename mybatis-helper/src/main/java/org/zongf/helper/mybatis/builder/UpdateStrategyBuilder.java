package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.UpdateStrategy;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

import java.util.*;

/** 更新条件构建器
 * @author zongf
 * @date 2019-12-13
 */
public class UpdateStrategyBuilder<T extends Enum> {

    private List<ColumnCondition> conditionList;

    private Map<T, Object> setMap;

    public UpdateStrategyBuilder(){
        conditionList = new ArrayList<>();
        setMap = new LinkedHashMap<>();
    }

    /** 添加更新属性和值
     * @param field 更新的属性名
     * @param value 更新的属性值
     * @return UpdateStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategyBuilder<T> set(T field, Object value){
        this.setMap.put(field, value);
        return this;
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return UpdateStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategyBuilder<T> and(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition<T>(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加and 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return UpdateStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategyBuilder<T> and(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.and, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @return UpdateStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategyBuilder<T> or(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }

    /** 添加or 条件
     * @param field 字段
     * @param operatorType 运算符
     * @param value 值
     * @param caseSensitive 是否大小写敏感
     * @return UpdateStrategyBuilder<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategyBuilder<T> or(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.or, field, operatorType, value));
        return this;
    }


    /** 生成更新策略
     * @return UpdateStrategy<T>
     * @author zongf
     * @date 2019-12-14
     */
    public UpdateStrategy<T> build(){
        UpdateStrategy<T> updateCondition = new UpdateStrategy<>();

        if(this.setMap.size() == 0) return null;

        updateCondition.setConditions(conditionList);
        updateCondition.setSetMap(setMap);
        return updateCondition;
    }
}
