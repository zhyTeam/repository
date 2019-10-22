package cn.kgc.tangcco.appinfosys.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class DevUser {
    private Integer id;//主键id
    private  String devCode;//开发者账号
    private  String devName;//开发者名称
    private  String devPassword;//开发者密码
    private  String devEmail;//开发者电子邮件
    private  String devInfo;//开发者简介
    private Integer createBy;//创建者
    private Date datetime;//创建时间
    private Integer modifyBy;//更新者
    private Integer modifyDate;//最新更新时间
}
