package org.zongf.helper.mybatis.enums;

/** 操作运算符
 * @author: zongf
 * @date: 2019-12-04
 */
public enum OperatorType {

    /** 等于 */
    equals("="),

    /** 不等于 */
    notEquals("!="),

    /** 大于 */
    greaterThan(">"),

    /** 小于 */
    lessThan("<"),

    /** 小于等于: <= */
    notGreaterThan("<="),

    /** 大于等于: >= */
    notLessThan(">="),

    /** 忽略大小写等于 */
    igCaseEquals("="),

    /** 忽略大小写不等于: != */
    igCaseNotEquals("!="),

    /** 为空 is null */
    isNull("is null"),

    /** 不为空 is not null */
    isNotNull("is not null"),

    /** in 查询*/
    in("in"),

    /** like 模糊查询*/
    like("like"),

    /** 忽略大小写模糊匹配 */
    igCaseLike("like");

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}