package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class AppDictionary {
    private Integer id;//主键ID
    private String  typeCode;//类型编码
    private String  typeName;//类型名称
    private Integer  valueId;//类型值ID
    private String valueName;//类型值Name
    private Integer createdBy;//创建者（来源于backend_user用户表的用户id）
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者（来源于backend_user用户表的用户id）
    private Date modifyDate;//最新更新时间

}
