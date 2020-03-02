package com.khunboo.modules.service.impl;

import com.khunboo.dto.LoginDto;
import com.khunboo.modules.dao.login.SysUserDao;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SysUserImpl extends BaseServiceImpl<SysUserDao, SysUserEntity> implements SysUserService{

    @Override
    public void save(LoginDto dto) {

    }
}
