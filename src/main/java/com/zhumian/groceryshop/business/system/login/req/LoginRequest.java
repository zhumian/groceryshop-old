package com.zhumian.groceryshop.business.system.login.req;

import com.zhumian.groceryshop.base.vo.BaseRequest;
import lombok.Data;

@Data
public class LoginRequest extends BaseRequest{

    private String account;
    private String password;
}
