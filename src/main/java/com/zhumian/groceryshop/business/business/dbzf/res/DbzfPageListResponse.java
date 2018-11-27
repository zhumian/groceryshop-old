package com.zhumian.groceryshop.business.business.dbzf.res;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class DbzfPageListResponse {

    private Integer id;
    private String title;
    private String url;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date publishTime;
}
