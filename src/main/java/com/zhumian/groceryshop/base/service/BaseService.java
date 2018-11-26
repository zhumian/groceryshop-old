package com.zhumian.groceryshop.base.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<PK extends Serializable, T extends Serializable> {

    T getById(PK pk);

    T getOne(T t);

    List<T> findAll();

    List<T> queryByParams(T t);

    List<T> queryByParams(T t, boolean isFuzzyQuery);

    int save(T t);

    int saveList(List<T> list);

    int update(T t);

    int updateCompletely(T t);

    int deleteById(PK pk);



}
