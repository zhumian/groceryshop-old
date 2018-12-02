package com.zhumian.groceryshop.business.system.dict.controller;

import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.base.vo.BaseResponse;
import com.zhumian.groceryshop.business.system.dict.req.DictPageListRequest;
import com.zhumian.groceryshop.business.system.dict.req.DictSaveOrUpdateRequest;
import com.zhumian.groceryshop.business.system.dict.res.DictPageListResponse;
import com.zhumian.groceryshop.business.system.dict.res.DictResponse;
import com.zhumian.groceryshop.business.system.dict.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/dict")
public class DictController {

    @Autowired
    private DictService dictService;

    @RequestMapping(value = "/saveOrUpdate")
    public BaseResponse<Void> saveOrUpdate(@RequestBody DictSaveOrUpdateRequest request){
        return dictService.saveOrUpdate(request);
    }


    @RequestMapping(value = "/pageList")
    public BasePageResponse<DictPageListResponse> pageList(DictPageListRequest request){
        return dictService.pageList(request);
    }

    @RequestMapping(value = "/getById")
    public BaseResponse<DictResponse> getById(Integer id){
        return dictService.get(id);
    }
}
