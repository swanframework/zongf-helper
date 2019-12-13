package org.zongf.helper.mybatis.condition;

import java.util.Map;

/** 更新条件
 * @author zongf
 * @date 2019-12-12
 */
public class UpdateCondition<T extends Enum> extends AbsCondition{

    private Map<T, Object> valueMap;

    public Map<T, Object> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<T, Object> valueMap) {
        this.valueMap = valueMap;
    }
}
