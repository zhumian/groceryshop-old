package com.zhumian.groceryshop.bean.system;

import com.zhumian.groceryshop.bean.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;


@Table(name = "tb_role")
@Data
public class Role extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -5539172945479475695L;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private Integer status;


}
