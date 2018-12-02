package com.zhumian.groceryshop.business.system.dict.req;

import com.zhumian.groceryshop.base.vo.BasePageRequest;
import lombok.Data;

@Data
public class DictPageListRequest extends BasePageRequest{

    private String type;
    private String code;
    private String value;
    private Integer sort;
    private Integer status;
}
