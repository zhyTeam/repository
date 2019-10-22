package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class AppCategory {
    private Integer id;//主键id
    private  String categoryCode;//分类编码
    private  String categoryName;//分类名称
    private  Integer parenId;//父及节点
    private  Integer createBy;//创建者
    private Date creationTime;
    private  Integer modifyBy;
    private Date modifyDate;
}
