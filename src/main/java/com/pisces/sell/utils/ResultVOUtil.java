package com.pisces.sell.utils;

import com.pisces.sell.vo.ResultVO;

/**
 * <p>Title: ResultVOUtil </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 0:31
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("操作成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setData(null);
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}
