package com.khunboo.modules.service.impl;

import com.khunboo.dto.LoginDto;
import com.khunboo.exception.SysException;
import com.khunboo.modules.dao.login.SysUserDao;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.service.impl.BaseServiceImpl;
import com.khunboo.utils.DateUtils;
import com.khunboo.utils.ManageUtils;
import com.khunboo.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class SysUserImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService{


    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private ManageUtils manageUtils;

    private final String TOKEN_NAME = "token";

    private final String SESSION_LOGIN_USER_NAME = "loginDto";

    @Override
    public void save(LoginDto dto) {

        String allTime = DateUtils.getAllTime();
        //判断账号是否重复
        String username = dto.getUsername();
        SysUserEntity sysUserEntity = sysUserDao.getSelectByAccount(username);
        if(sysUserEntity != null) {
            throw new SysException(500, "对不起，您所创建的账号已存在！！！");
        }

        dto.setPassword(Md5Utils.encrypt(dto.getPassword()));
        dto.setCreater("admin");
        dto.setCreateTime(allTime);
        dto.setUpdater("admin");
        dto.setUpdateTime(allTime);
        dto.setSalt(manageUtils.getPasswordSalt());

        sysUserDao.save(dto);

    }

    @Override
    public SysUserEntity getByAccount(String account, String password) {

        SysUserEntity sysUserEntity = sysUserDao.getSelectByAccount(account);
        if(sysUserEntity != null && sysUserEntity.getPassword().equals(Md5Utils.encrypt(password + sysUserEntity.getSalt()))){

            return sysUserEntity;
        }

        return null;

    }


    @Override
    public void cacheUser(LoginDto loginDto, HttpServletResponse response, HttpServletRequest request){

        String token = UUID.randomUUID().toString().replace("-", "");
        Cookie cookie = new Cookie(TOKEN_NAME, token);

        response.addCookie(cookie);

        redisUtils.set(token, loginDto, -1L);
        request.getSession().setAttribute(SESSION_LOGIN_USER_NAME, loginDto);
    }
}
