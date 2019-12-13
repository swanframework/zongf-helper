package org.zongf.helper.mybatis.condition;

import java.util.List;

/**
 * @author zongf
 * @date 2019-12-12
 */
public abstract class AbsCondition {

    // 条件列表
    private List<ColumnCondition> conditions;

    public List<ColumnCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<ColumnCondition> conditions) {
        this.conditions = conditions;
    }

}
