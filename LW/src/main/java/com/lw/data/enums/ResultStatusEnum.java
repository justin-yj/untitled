package com.lw.data.enums;

/**
 * @author wqy
 * @create 2018/1/9
 */
public enum ResultStatusEnum {
    SUCCESS(0, "成功"), FAILED(1, "失败"), PWDERREOR(2,"密码错误"), UN_LOGIN(9, "未登录") ;
    private Integer value;
    private String name;

    ResultStatusEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

