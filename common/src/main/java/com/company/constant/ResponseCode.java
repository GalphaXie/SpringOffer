package com.company.constant;

public enum ResponseCode {
    SUCCESS(0, "success"), FAIL(-1, "fail");

    private int code;
    private String description;



    ResponseCode(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
