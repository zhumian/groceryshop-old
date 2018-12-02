package com.zhumian.groceryshop.bean.system;

import com.zhumian.groceryshop.bean.BaseEntity;
import lombok.Data;

import javax.persistence.Table;

@Table(name = "tb_dict")
@Data
public class Dict extends BaseEntity{

    private String type;
    private String code;
    private String value;
    private Integer sort;
    private Integer status;
    private String remark;
}
