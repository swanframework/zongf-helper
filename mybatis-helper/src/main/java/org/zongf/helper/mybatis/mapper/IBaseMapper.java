package org.zongf.helper.mybatis.mapper;

import org.zongf.helper.mybatis.condition.SimpleQueryCondition;

import java.util.List;
import java.util.Map;

public interface IBaseMapper<T> {

    boolean save(T t);
    int batchSave(List<T> list);

    boolean deleteById(Integer id);
    int batchDelete(List<T> list);
    int batchDeleteByIds(List<Integer> list);

    boolean update(T t);
    boolean updateFields(T t, List<String> fieldNameList);
    boolean updateNotNull(T t);

    T queryById(Integer id);
    List<T> queryByIds(List<Integer> ids);
    List<T> queryList();
    T queryIncludeFieldsById(Integer id, List<String> fields);
    List<T> queryIncludeFieldsByIds( List<Integer> ids, List<String> fields);
    T queryExcludeFieldsById(Integer id, List<String> fields);
    List<T> queryExcludeFieldsByIds( List<Integer> ids,  List<String> fields);

    Map<Integer, Object> queryMapByIds(List<Integer> ids);
    Map<String, Object> queryFieldMapById(Integer id);
    List<Map<String, Object>> queryFieldMapListByIds(List<Integer> ids);

    int queryTotalCount();

    //TODO
    // 分页
//    PageList<T> queryPager();
//    PageList<T> queryPagerOnCondition(SimpleQueryCondition simpleQuery);

    List<T> queryListOnCondition(SimpleQueryCondition simpleQuery);
    int batchDeleteOnCondition(SimpleQueryCondition simpleQuery);
    int batchUpdateOnCondition(Map<String, Object> valMap, SimpleQueryCondition simpleQuery);
    int queryCountOnCondition(SimpleQueryCondition simpleQuery);


}
