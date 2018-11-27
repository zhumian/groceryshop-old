package com.zhumian.groceryshop.business.dbzf.req;

import com.zhumian.groceryshop.base.vo.BasePageRequest;
import lombok.Data;

@Data
public class DbzfPageListRequest extends BasePageRequest {

    //城市名称
    private String city;
    //地区名称
    private String area;
    //标题关键字
    private String title;

}
