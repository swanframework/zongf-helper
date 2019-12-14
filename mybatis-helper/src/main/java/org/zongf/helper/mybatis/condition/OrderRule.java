package org.zongf.helper.mybatis.condition;

import org.zongf.helper.mybatis.enums.OrderType;

/** 排序规则
 * @author: zongf
 * @date: 2019-12-04
 */
public class OrderRule<T extends Enum> {

    // 排序字段名称
    private T field;

    // 排序类型
    private OrderType sortType;

	public OrderRule() {
        super();
    }

	public OrderRule(T field, OrderType sortType) {
        super();
		this.field = field;
		this.sortType = sortType;
    }

    public void setField(T field){
		this.field=field;
	}

	public T getField(){
		return this.field;
	}

    public void setSortType(OrderType sortType){
		this.sortType=sortType;
	}

	public OrderType getSortType(){
		return this.sortType;
	}

    public String toString() {
		return getClass().getSimpleName() + "@" + hashCode() + ": {field:" + field + ", sortType:" + sortType  + "}";
	}

}
