package org.zongf.helper.spring.dto;

import org.zongf.helper.spring.constant.BaseResponseCodeConst;

/**响应基类
 * @author zongf
 * @date 2019-12-14
 */
public class BaseResponse<T> {

    // 响应码
    private int code;

    // 描述
    private String message;

    // 响应数据
    private T body;

	public BaseResponse() {
        super();
    }

    /** 请求成功
     * @return BaseResponse
     * @author zongf
     * @date 2019-12-14
     */
    public static BaseResponse success(){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseResponseCodeConst.SUCCESS);
		return baseResponse;
	}

	/** 请求成功
	 * @param body 响应数据
	 * @return BaseResponse
	 * @author zongf
	 * @date 2019-12-14
	 */
	public static <T> BaseResponse success(T body){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseResponseCodeConst.SUCCESS);
		baseResponse.setBody(body);
		return baseResponse;
	}

	/** 请求失败
	 * @return BaseResponse
	 * @author zongf
	 * @date 2019-12-14
	 */
	public static BaseResponse failed(){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseResponseCodeConst.FAILED);
		return baseResponse;
	}

	/** 请求失败
	 * @param body 响应数据
	 * @return BaseResponse
	 * @author zongf
	 * @date 2019-12-14
	 */
	public static <T> BaseResponse failed(T body){
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setCode(BaseResponseCodeConst.FAILED);
		baseResponse.setBody(body);
		return baseResponse;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
