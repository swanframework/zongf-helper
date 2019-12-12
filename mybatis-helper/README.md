
### 1. 集成配置
```xml

<plugin interceptor="org.zongf.plugin.mybatis.pagehelper.PageInterceptorPlus" >
    <property name="reasonable" value="true"/>
</plugin>
```

### 2. 用法示例

```java
// 不分页
List<StudentPO> queryAll();

// 分页
PageResult<StudentPO> queryAll(PageBounds pagerBounds);

// 不分页
List<StudentPO> queryBySex(@Param("sex") String sex );

// 分页
PageResult<StudentPO> queryBySex(@Param("sex") String sex, PageBounds pagerBounds);

```

```xml
<!-- 无条件查询 -->
<select id="queryAll" resultType="StudentPO">
    select * from t_student
</select>

<!-- 有条件查询-->
<select id="queryBySex" resultType="StudentPO">
    select * from t_student where sex = #{sex}
</select>

```