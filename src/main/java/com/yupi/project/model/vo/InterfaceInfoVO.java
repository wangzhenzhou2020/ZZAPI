package com.yupi.project.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class InterfaceInfoVO  implements Serializable {
    private Long id;
    private String name;
    private String description;
    private String url;
    private String requestParams;
    private String requestHeader;
    private String responseHeader;
    private Integer status;
    private String method;
    private Long userId;

    private Integer totalNum;

}
