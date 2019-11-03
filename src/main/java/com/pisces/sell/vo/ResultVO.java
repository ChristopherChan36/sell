package com.pisces.sell.vo;

import lombok.Data;

/**
 * <p>Title: ResultVO </p>
 * <p>Description: http 请求返回的统一最外层对象 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-2-28 22:06
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /**
     * 错误码.
     */
    private Integer code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;
}
