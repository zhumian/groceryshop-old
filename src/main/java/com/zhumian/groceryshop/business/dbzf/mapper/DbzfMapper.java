package com.zhumian.groceryshop.business.dbzf.mapper;

import com.zhumian.groceryshop.bean.business.dbzf.Dbzf;
import com.zhumian.groceryshop.config.mybatis.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DbzfMapper extends BaseMapper<Dbzf> {

    List<Dbzf> pageList(Map<String, Object> map);
}
