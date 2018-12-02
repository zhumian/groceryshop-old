package com.zhumian.groceryshop.base.vo;

import lombok.Data;

@Data
public class BasePageRequest extends BaseRequest {

    private Integer page;

    private Integer size;

    public BasePageRequest(){
        this.page = 1;
        this.size = 10;
    }

    public void setPage(Integer page) {
        this.page = page < 0 ? 1 : page;
    }


    public void setSize(Integer size) {
        this.size = size < 0 ? 10 : size;
    }
}
