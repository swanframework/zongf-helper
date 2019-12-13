package org.zongf.helper.mybatis.builder;

import org.zongf.helper.mybatis.condition.ColumnCondition;
import org.zongf.helper.mybatis.condition.UpdateCondition;
import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

import java.util.*;

/**
 * @author zongf
 * @date 2019-12-13
 */
public class UpdateConditionBuilder<T extends Enum> {

    private List<ColumnCondition> conditionList;

    private Map<T, Object> fieldMap;

    public UpdateConditionBuilder(){
        conditionList = new ArrayList<>();
        fieldMap = new LinkedHashMap<>();
    }


    public UpdateConditionBuilder<T> set(T field, Object value){
        this.fieldMap.put(field, value);
        return this;
    }

    public UpdateConditionBuilder<T> and(String columnName, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public UpdateConditionBuilder<T> and(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public UpdateConditionBuilder<T> or(String columnName, OperatorType operatorType, Object value){
        this.conditionList.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public UpdateConditionBuilder<T> or(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditionList.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public UpdateCondition<T> build(){
        UpdateCondition<T> updateCondition = new UpdateCondition<>();

        if(this.fieldMap.size() == 0) return null;

        updateCondition.setConditions(conditionList);
        updateCondition.setValueMap(fieldMap);
        return updateCondition;
    }
}
