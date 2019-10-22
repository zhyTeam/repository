package cn.kgc.tangcco.appinfosys.pojo;

import java.util.Date;

public class AppVersion {
    private Integer id;//主键id
    private Integer appId;//appId（来源于：app_info表的主键id）
    private String versionNo;//版本号
    private String versionInfo;//版本介绍
    private Integer publishStatus;//发布状态（来源于：data_dictionary，1 不发布 2 已发布 3 预发布）
    private String downloadLink;//下载链接
    private double  versionSize;//版本大小（单位：M）
    private Integer  createdBy;//创建者（来源于dev_user开发者信息表的用户id）
    private Date creationDate;//创建时间
    private Integer modifyBy;//更新者（来源于dev_user开发者信息表的用户id）
    private Date modifyDate;//最新更新时间
    private String  apkLocPath;//apk文件的服务器存储路径
    private String apkFileName;//上传的apk文件名称

}
