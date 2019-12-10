package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.RelationType;
import org.zongf.helper.mybatis.enums.OperatorType;

/**
 * @author: zongf
 * @date: 2019-12-04
 */
public class ColumnCondition{

    private RelationType relationType;

    // 字段名称
    private String columnName;

    // 关系
    private OperatorType operatorType;

    // 值
    private Object value;

    public ColumnCondition() {
        super();
    }

    public ColumnCondition(RelationType relationType, String columnName, OperatorType operatorType, Object value) {
        super();
        this.relationType = relationType;
        this.columnName = columnName;
        this.operatorType = operatorType;
        this.value = value;
    }

    public void setRelationType(RelationType relationType){
        this.relationType=relationType;
    }

    public RelationType getRelationType(){
        return this.relationType;
    }

    public void setColumnName(String columnName){
        this.columnName=columnName;
    }

    public String getColumnName(){
        return this.columnName;
    }

    public void setOperatorType(OperatorType operatorType){
        this.operatorType=operatorType;
    }

    public OperatorType getOperatorType(){
        return this.operatorType;
    }

    public void setValue(Object value){
        this.value=value;
    }

    public Object getValue(){
        return this.value;
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + hashCode() + ": {relationType:" + relationType + ", columnName:" + columnName + ", operatorType:" + operatorType + ", value:" + value  + "}";
    }

}