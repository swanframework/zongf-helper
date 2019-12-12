package org.zongf.helper.mybatis.enums;

/** 操作运算符
 * @author: zongf
 * @date: 2019-12-04
 */
public enum OperatorType {

    /** 等于 */
    equals,

    /** 不等于 */
    notEquals,

    /** 大于 */
    greaterhan,

    /** 小于 */
    lessThan,

    /** 大于等于: >= */
    greaterOrEquals,

    /** 小于等于: <= */
    lessOrEqualsThan,

    /** 为空 is null */
    isNull,

    /** 不为空 is not null */
    isNotNull,

    /** in 查询*/
    in,

    /** 模糊匹配: like %xx% */
    like,

    /** 以字符串开始: like xx% */
    startWith,

    /** 以字符串结束: like %xx*/
    endWith,

    /** 包含: instr(column, 'xxx') > 0 */
    contains
    ;
}