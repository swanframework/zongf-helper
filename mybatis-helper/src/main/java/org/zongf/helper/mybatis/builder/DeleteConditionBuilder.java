package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.DeleteCondition;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

import java.util.ArrayList;
import java.util.List;

/** 删除条件构建器
 * @author zongf
 * @date 2019-12-13
 */
public class DeleteConditionBuilder<T extends Enum> {

    private List<ColumnCondition> conditionList;

    public DeleteConditionBuilder(){
        this.conditionList = new ArrayList<>();
    }

    public DeleteConditionBuilder<T> and(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition<T>(RelationType.AND, field, operatorType, value));
        return this;
    }

    public DeleteConditionBuilder<T> and(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.AND, field, operatorType, value));
        return this;
    }

    public DeleteConditionBuilder<T> or(T field, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.OR, field, operatorType, value));
        return this;
    }

    public DeleteConditionBuilder<T> or(T field, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.OR, field, operatorType, value));
        return this;
    }

    public DeleteCondition<T> build(){
        DeleteCondition<T> deleteCondition = new DeleteCondition<>();
        deleteCondition.setConditions(conditionList);
        return deleteCondition;
    }
}
