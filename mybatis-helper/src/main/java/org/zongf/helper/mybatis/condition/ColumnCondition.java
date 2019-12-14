package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OperatorType;
import org.zongf.helper.mybatis.enums.RelationType;

/** 字段条件类
 * @author zongf
 * @date 2019-12-11
 */
public class ColumnCondition<T extends Enum> {

    // 关系类型
    private RelationType relationType;

    // 字段名称
    private T field;

    // 关系
    private OperatorType operatorType;

    // 值
    private Object value;
    
    // 大小写敏感
    private boolean caseSensitive;

	public ColumnCondition() {
        super();
    }

	public ColumnCondition(RelationType relationType, T field, OperatorType operatorType, Object value) {
        super();
		this.relationType = relationType;
		this.field = field;
		this.operatorType = operatorType;
		this.value = value;
    }

    public void setRelationType(RelationType relationType){
		this.relationType=relationType;
	}

	public RelationType getRelationType(){
		return this.relationType;
	}

    public void setField(T field){
		this.field=field;
	}

	public T getField(){
		return this.field;
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

    public void setCaseSensitive(boolean caseSensitive){
		this.caseSensitive=caseSensitive;
	}

	public boolean isCaseSensitive(){
		return this.caseSensitive;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {relationType:" + relationType + ", field:" + field + ", operatorType:" + operatorType + ", value:" + value + ", caseSensitive:" + caseSensitive  + "}";
	}

}
