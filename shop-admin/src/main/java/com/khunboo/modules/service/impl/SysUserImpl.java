package com.khunboo.modules.service.impl;

import com.khunboo.dto.LoginDto;
import com.khunboo.exception.SysException;
import com.khunboo.modules.dao.login.SysUserDao;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.service.impl.BaseServiceImpl;
import com.khunboo.utils.DateUtils;
import com.khunboo.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService{


    @Autowired
    private SysUserDao sysUserDao;

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

        sysUserDao.save(dto);

    }
}
