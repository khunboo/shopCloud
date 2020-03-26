package com.khunboo.modules.service;

import com.khunboo.dto.LoginDto;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.service.BaseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface SysUserService extends BaseService<SysUserEntity> {

    void save(LoginDto dto);

    SysUserEntity getByAccount(String account, String password);

    void cacheUser(LoginDto loginDto, HttpServletResponse response, HttpServletRequest request);
}
