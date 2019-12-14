package org.zongf.helper.mybatis.condition;

import java.util.Map;

/** 更新条件
 * @author zongf
 * @date 2019-12-12
 */
public class UpdateStrategy<T extends Enum> extends AbsStrategy {

    private Map<T, Object> setMap;

    public Map<T, Object> getSetMap() {
        return setMap;
    }

    public void setSetMap(Map<T, Object> setMap) {
        this.setMap = setMap;
    }
}
