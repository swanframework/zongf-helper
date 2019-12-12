package org.zongf.helper.mybatis.condition2;

import java.util.Map;

/** 更新条件
 * @author zongf
 * @date 2019-12-12
 */
public class UpdateCondition extends AbsCondition{

    private Map<String, Object> valueMap;

    public void set(String columnName, String value){
        this.valueMap.put(columnName, value);
    }

    public Map<String, Object> getValueMap() {
        return valueMap;
    }

    public void setValueMap(Map<String, Object> valueMap) {
        this.valueMap = valueMap;
    }
}
