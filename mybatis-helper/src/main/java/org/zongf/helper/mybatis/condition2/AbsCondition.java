package org.zongf.helper.mybatis.condition2;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

import java.util.List;

/**
 * @author zongf
 * @date 2019-12-12
 */
public abstract class AbsCondition {

    // 条件列表
    private List<ColumnCondition> conditions;

    public AbsCondition and(String columnName, OperatorType operatorType, Object value){
        this.conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value));
        return this;
    }

    public AbsCondition and(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditions.add(new ColumnCondition(RelationType.AND, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public AbsCondition or(String columnName, OperatorType operatorType, Object value){
        this.conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value));
        return this;
    }

    public AbsCondition or(String columnName, OperatorType operatorType, Object value, boolean caseSensitive){
        this.conditions.add(new ColumnCondition(RelationType.OR, columnName, operatorType, value, caseSensitive));
        return this;
    }

    public List<ColumnCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ColumnCondition> conditions) {
        this.conditions = conditions;
    }

}
