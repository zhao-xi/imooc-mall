package com.imooc.mall.exception;

public class ImoocMallException extends Exception {
    private final Integer code;
    private final String message;

    public ImoocMallException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ImoocMallException(ImoocMallExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
