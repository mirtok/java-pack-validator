package com.pack.message;


public class ReturnUtils {
    private static ReturnObject returnObject = new ReturnObject();
    /**
     * 成功的返回
     * @return flag: 1
     */
    public static ReturnObject successResult(Object data){
        returnObject.setFlag(ReturnEnum.SUCCESS.getCode());
        returnObject.setMessage(ReturnEnum.SUCCESS.getMessage());
        returnObject.setData(data);
        return returnObject;
    }

    /**
     * 失败的返回 flag: 0
     * @return
     */
    public static ReturnObject errorResult(String message,Object data){
        returnObject.setFlag(ReturnEnum.ERROR.getCode());
        returnObject.setMessage(message);
        returnObject.setData(data);
        return returnObject;
    }
}
