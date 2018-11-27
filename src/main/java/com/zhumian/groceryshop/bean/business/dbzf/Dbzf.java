package com.zhumian.groceryshop.bean.business.dbzf;

import com.zhumian.groceryshop.annotation.FuzzyQuery;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_dbzf")
@Data
public class Dbzf  {

    @Id
    private Integer id;
    private String city;
    private String area;
    private String articleId;
    private String url;

    @FuzzyQuery
    private String title;
    private String authorUrl;
    private Date publishTime;
    private Date createTime;

}
