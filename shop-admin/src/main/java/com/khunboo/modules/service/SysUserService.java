package com.khunboo.modules.service;

import com.khunboo.dto.LoginDto;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.service.BaseService;

public interface SysUserService extends BaseService<SysUserEntity> {

    void save(LoginDto dto);
}
