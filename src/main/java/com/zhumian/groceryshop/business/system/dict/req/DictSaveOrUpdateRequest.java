package com.zhumian.groceryshop.business.system.dict.req;

import com.zhumian.groceryshop.base.vo.BaseRequest;
import lombok.Data;

@Data
public class DictSaveOrUpdateRequest extends BaseRequest {

    private Integer id;
    private String type;
    private String code;
    private String value;
    private Integer status;
    private Integer sort;
    private String remark;
}
