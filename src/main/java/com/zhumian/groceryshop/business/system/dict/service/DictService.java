package com.zhumian.groceryshop.business.system.dict.service;

import com.zhumian.groceryshop.base.service.BaseService;
import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.base.vo.BaseRequest;
import com.zhumian.groceryshop.base.vo.BaseResponse;
import com.zhumian.groceryshop.bean.system.Dict;
import com.zhumian.groceryshop.business.system.dict.req.DictPageListRequest;
import com.zhumian.groceryshop.business.system.dict.req.DictSaveOrUpdateRequest;
import com.zhumian.groceryshop.business.system.dict.res.DictPageListResponse;
import com.zhumian.groceryshop.business.system.dict.res.DictResponse;

import java.util.List;

public interface DictService extends BaseService<Integer, Dict> {

    /**
     * 保存or更新
     * @param request
     * @return
     */
    BaseResponse<Void> saveOrUpdate(DictSaveOrUpdateRequest request);


    /**
     * 分页查询
     * @param request
     * @return
     */
    BasePageResponse<DictPageListResponse> pageList(DictPageListRequest request);


    /**
     * 获取实体
     * @param id
     * @return
     */
    BaseResponse<DictResponse> get(Integer id);


}
