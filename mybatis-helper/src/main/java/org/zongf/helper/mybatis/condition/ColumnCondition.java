package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

/** 字段条件类
 * @author zongf
 * @date 2019-12-11
 */
public class ColumnCondition {

    // 关系类型
    private RelationType relationType;

    // 字段名称
    private String columnName;

    // 关系
    private OperatorType operatorType;

    // 值
    private Object value;
    
    // 忽略大小写
    private boolean ignoreCase;

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

    public ColumnCondition(RelationType relationType, String columnName, OperatorType operatorType, Object value, boolean ignoreCase) {
        super();
        this.relationType = relationType;
        this.columnName = columnName;
        this.operatorType = operatorType;
        this.value = value;
        this.ignoreCase = ignoreCase;
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

    public void setIgnoreCase(boolean ignoreCase){
		this.ignoreCase=ignoreCase;
	}

	public boolean isIgnoreCase(){
		return this.ignoreCase;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {relationType:" + relationType + ", columnName:" + columnName + ", operatorType:" + operatorType + ", value:" + value + ", ignoreCase:" + ignoreCase  + "}";
	}

}
