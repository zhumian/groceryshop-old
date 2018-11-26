package com.zhumian.groceryshop.bean.system;

import com.zhumian.groceryshop.bean.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@Table(name = "tb_user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2717592229856250854L;
    private String account;
    private String name;
    private String password;
    private Integer gender;
    private Integer status;
}
