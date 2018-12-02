package com.zhumian.groceryshop.business.system.dict.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhumian.groceryshop.base.service.BaseServiceImpl;
import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.base.vo.BaseResponse;
import com.zhumian.groceryshop.bean.system.Dict;
import com.zhumian.groceryshop.business.system.dict.req.DictPageListRequest;
import com.zhumian.groceryshop.business.system.dict.req.DictSaveOrUpdateRequest;
import com.zhumian.groceryshop.business.system.dict.res.DictPageListResponse;
import com.zhumian.groceryshop.business.system.dict.res.DictResponse;
import com.zhumian.groceryshop.business.system.dict.service.DictService;
import com.zhumian.groceryshop.exception.BusinessException;
import com.zhumian.groceryshop.util.BeanUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DictServiceImpl extends BaseServiceImpl<Integer ,Dict> implements DictService {

    @Override
    public BaseResponse<Void> saveOrUpdate(DictSaveOrUpdateRequest request) {
        if(request.getId() == null){
            Dict dict = new Dict();
            BeanUtil.obj2obj(request, dict);
            dict.setCreatorId(request.getCurrentUserId());
            dict.setCreatorName(request.getCurrentUserName());
            dict.setCreateTime(request.getNow());
            validate(dict);
            save(dict);
        }else {
            Dict select = new Dict();
            select.setId(request.getId());
            Dict dict = getOne(select);
            if(dict == null) {
                throw new BusinessException("无效ID");
            }
            BeanUtil.obj2obj(request, dict);
            validate(dict);
            update(dict);
        }
        return new BaseResponse<>();
    }

    private void validate(Dict dict){
        Dict select = new Dict();
        select.setType(dict.getType());
        select.setCode(dict.getCode());
        List<Dict> dicts = queryByParams(select, false);
        if((dict.getId() == null && !dicts.isEmpty()) || (dict.getId() != null && dicts.size() > 1)){
            throw new BusinessException("数据字典编码不能重复！");
        }
    }

    @Override
    public BasePageResponse<DictPageListResponse> pageList(DictPageListRequest request) {
        Dict select = new Dict();
        BeanUtil.obj2obj(request, select);
        Page page = PageHelper.startPage(request.getPage(), request.getSize());
        List<Dict> dicts = queryByParams(select);
        List<DictPageListResponse> responses = new ArrayList<>();
        BeanUtil.list2list(dicts, responses, DictPageListResponse.class);
        return new BasePageResponse<>(page.getTotal(), responses);

    }

    @Override
    public BaseResponse<DictResponse> get(Integer id) {
        Dict dict = getById(id);
        DictResponse response = new DictResponse();
        BeanUtil.obj2obj(dict, response);
        return new BaseResponse<>(response);
    }
}
