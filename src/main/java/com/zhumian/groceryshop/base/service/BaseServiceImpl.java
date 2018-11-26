package com.zhumian.groceryshop.base.service;

import com.zhumian.groceryshop.config.mybatis.BaseMapper;
import com.zhumian.groceryshop.util.ExampleUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Slf4j
public abstract class BaseServiceImpl<PK extends Serializable, T extends Serializable> implements BaseService<PK, T>{

    @Autowired
    protected BaseMapper<T> mapper;

    protected Class entityClass;


    public BaseServiceImpl() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

    @Override
    public T getById(PK pk) {
        return mapper.selectByPrimaryKey(pk);
    }

    @Override
    public T getOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public List<T> queryByParams(T t) {
        Example example = ExampleUtil.createExample(t, true, t.getClass());
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> queryByParams(T t, boolean isFuzzyQuery) {
        Example example = ExampleUtil.createExample(t, isFuzzyQuery, t.getClass());
        return mapper.selectByExample(example);
    }

    @Override
    public int save(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public int saveList(List<T> list) {
        return mapper.insertList(list);
    }

    @Override
    public int update(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int updateCompletely(T t) {
       return mapper.updateByPrimaryKey(t);
    }

    @Override
    public int deleteById(PK pk) {
        return mapper.deleteByPrimaryKey(pk);
    }
}
