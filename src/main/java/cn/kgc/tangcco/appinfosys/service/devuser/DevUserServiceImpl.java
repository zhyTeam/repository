package cn.kgc.tangcco.appinfosys.service.devuser;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

public class DevUserServiceImpl implements DevUserService {
    @Resource
    private  DevUserMapper devUserMapper;
    /*
    * 登录
    * */
    @Override
    public DevUser getUserByCode(String userCode, String userPassword) throws Exception {
      DevUser devUser=devUserMapper.getUserByCode(userCode);
      if (devUser!=null){
          if (!devUser.getDevPassWord().equals(userPassword)){
              devUser=null;
          }
      }
        return devUser;
    }
}
