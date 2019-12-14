package org.zongf.helper.spring.dto;

/** 请求基类
 * @author zongf
 * @date 2019-12-14
 */
public class BaseRequest<T> {

    private T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
