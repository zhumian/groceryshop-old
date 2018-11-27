package com.zhumian.groceryshop.business.dbzf.controller;

import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.business.dbzf.req.DbzfPageListRequest;
import com.zhumian.groceryshop.business.dbzf.res.DbzfPageListResponse;
import com.zhumian.groceryshop.business.dbzf.service.DbzfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/business/dbzf")
public class DbzfController {

    @Autowired
    private DbzfService dbzfService;

    @RequestMapping(value = "/list")
    public BasePageResponse<DbzfPageListResponse> list(DbzfPageListRequest request){
        return dbzfService.list(request);
    }

}
