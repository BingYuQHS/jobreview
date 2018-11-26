package com.flamingo.jrmessage.util;

import com.flamingo.jrmessage.model.ResultVO;

/***
 * 工具类
 * 封装ResultVO
 */
public class R {

    /***
     * 成功，返回数据
     * @param object
     * @return
     */
    public static ResultVO ok(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }

    /***
     * 成功，不返回数据
     * @return
     */
    public static ResultVO ok() {
        return ok(null);
    }

    /***
     * 失败，返回错误信息
     * @param code
     * @param msg
     * @return
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    /**
     * 失败，返回错误信息和数据
     * @param code
     * @param msg
     * @param object
     * @return
     */
    public static ResultVO error(Integer code, String msg, Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(object);
        return resultVO;
    }
}
