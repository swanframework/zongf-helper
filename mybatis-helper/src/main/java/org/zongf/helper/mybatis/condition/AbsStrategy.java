package org.zongf.helper.mybatis.condition;

import java.util.List;

/** 抽象条件类
 * @author zongf
 * @date 2019-12-12
 */
public abstract class AbsStrategy {

    // 条件列表
    private List<ColumnCondition> conditions;

    public List<ColumnCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ColumnCondition> conditions) {
        this.conditions = conditions;
    }

}
