package com.zhumian.groceryshop.base.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class BasePageResponse<T> extends BaseResponse {

    private Long total;
    private List<T> data;

    public BasePageResponse(){
        this.data = new ArrayList<>();
    }

    public BasePageResponse(Long total, List<T> data){
        this.total = total;
        this.data = data;
    }
}
