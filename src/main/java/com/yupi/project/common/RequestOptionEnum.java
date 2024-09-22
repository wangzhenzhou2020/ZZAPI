package com.yupi.project.common;

import lombok.Getter;

/**
 * 指定新增还是修改，用于参数校验。
 * @author wangzhenzhou
 */
@Getter
public enum RequestOptionEnum {
    Add("新增"),
    Update("修改");
    private final String message;
    RequestOptionEnum(String message){
        this.message=message;
    }
}
