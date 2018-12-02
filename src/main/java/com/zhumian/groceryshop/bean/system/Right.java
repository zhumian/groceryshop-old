package com.zhumian.groceryshop.bean.system;

import com.zhumian.groceryshop.bean.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "tb_right")
public class Right extends BaseEntity implements Serializable{


    private static final long serialVersionUID = -4949225956207744201L;

    private Long pid;

    private String rightName;

    private String rightCode;

    private Integer rightType;

    private Integer level;

    private Integer sort;

    private Integer status;
}
