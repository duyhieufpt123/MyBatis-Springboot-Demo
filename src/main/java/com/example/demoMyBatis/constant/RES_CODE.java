package com.example.demoMyBatis.constant;

public enum RES_CODE {

    SUCCESS(0, "OPERATION SUCCESSFUL"),
    FAIL(-1, "OPERATION FAILED"),
    EMPTY(2, "EMPTY LIST")
    ;

    private final int code;
    private final String message;


    RES_CODE(int code, String message) {
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

