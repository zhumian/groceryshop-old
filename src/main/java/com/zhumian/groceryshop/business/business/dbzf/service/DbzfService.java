package com.zhumian.groceryshop.business.business.dbzf.service;

import com.zhumian.groceryshop.base.service.BaseService;
import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.bean.business.dbzf.Dbzf;
import com.zhumian.groceryshop.business.business.dbzf.req.DbzfPageListRequest;
import com.zhumian.groceryshop.business.business.dbzf.res.DbzfPageListResponse;

public interface DbzfService extends BaseService<Integer, Dbzf> {

    /**
     * 查询列表
     * @param request
     * @return
     */
    BasePageResponse<DbzfPageListResponse> list(DbzfPageListRequest request);
}
