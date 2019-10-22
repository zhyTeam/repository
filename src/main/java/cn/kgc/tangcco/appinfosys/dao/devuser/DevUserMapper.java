package cn.kgc.tangcco.appinfosys.dao.devuser;

public interface DevUserMapper {
    /*
    根据用户编码和密码查询用户
    *
    */
    DevUser getUserByCode(String userCode)throws Exception;
}
