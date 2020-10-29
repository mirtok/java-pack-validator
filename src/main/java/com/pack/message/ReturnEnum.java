package com.pack.message;

public enum ReturnEnum {

    SUCCESS(1,"成功"),
    ERROR(0,"失败");

    private int code;
    private String message;

    ReturnEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
