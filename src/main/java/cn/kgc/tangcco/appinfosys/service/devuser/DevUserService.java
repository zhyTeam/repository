package cn.kgc.tangcco.appinfosys.service.devuser;
import cn.kgc.tangcco.appinfosys.pojo.*;
public interface DevUserService {
    /*
    * 登录
    * */
    DevUser login(String userCode,String userPassword)throws Exception;

}
