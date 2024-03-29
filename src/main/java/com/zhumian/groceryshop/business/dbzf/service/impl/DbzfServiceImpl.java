package com.zhumian.groceryshop.business.dbzf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhumian.groceryshop.base.service.BaseServiceImpl;
import com.zhumian.groceryshop.base.vo.BasePageResponse;
import com.zhumian.groceryshop.bean.business.dbzf.Dbzf;
import com.zhumian.groceryshop.business.dbzf.mapper.DbzfMapper;
import com.zhumian.groceryshop.business.dbzf.req.DbzfPageListRequest;
import com.zhumian.groceryshop.business.dbzf.res.DbzfPageListResponse;
import com.zhumian.groceryshop.business.dbzf.service.DbzfService;
import com.zhumian.groceryshop.util.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DbzfServiceImpl extends BaseServiceImpl<Integer, Dbzf> implements DbzfService {

    @Autowired
    private DbzfMapper mapper;

    @Override
    public BasePageResponse<DbzfPageListResponse> list(DbzfPageListRequest request) {
        Dbzf select = new Dbzf();
        select.setCity(request.getCity());
        select.setArea(request.getArea());
        select.setTitle(request.getTitle());
        Page page = PageHelper.startPage(request.getPage(), request.getSize());
        List<Dbzf> dbzfs = mapper.pageList(BeanUtil.obj2Map(request));
        List<DbzfPageListResponse> responses = new ArrayList<>();
        BeanUtil.list2list(dbzfs, responses, DbzfPageListResponse.class);
        return new BasePageResponse<>(page.getTotal(), responses);
    }
}
