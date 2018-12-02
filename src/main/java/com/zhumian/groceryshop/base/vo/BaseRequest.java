package com.zhumian.groceryshop.base.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseRequest {

    private Integer currentUserId;
    private String currentUserName;
    private Date now = new Date();

}
