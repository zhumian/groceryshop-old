package com.zhumian.groceryshop.bean;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable{


    private static final long serialVersionUID = 5869847843668735242L;

    @Id
    private Integer id;

    private Integer creatorId;

    private String creatorName;

    private Date createTime;

    private Integer updaterId;

    private String updaterName;

    private Date updateTime;
}
