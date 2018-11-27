package com.zhumian.groceryshop.base.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class BasePageResponse<T> extends BaseResponse {

    private Integer draw;
    private Long recordsTotal;
    private Long recordsFiltered;
    private List<T> data;

    public BasePageResponse(){
        this.data = new ArrayList<>();
    }

    public BasePageResponse(Integer draw, Long total, List<T> data){
        this.draw = draw;
        this.recordsTotal = total;
        this.recordsFiltered = total;
        this.data = data;
    }
}
