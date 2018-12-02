package com.zhumian.groceryshop.business.system.dict.res;

import lombok.Data;

@Data
public class DictPageListResponse {

    private Integer id;
    private String type;
    private String code;
    private String value;
    private Integer sort;
    private String remark;
    private Integer status;
    private String statusName;

    public void setStatus(Integer status) {
        this.status = status;
        if(status != null && status == 1){
            this.statusName = "生效";
        }else {
            this.statusName = "无效";
        }
    }
}
