package com.khunboo.modules.dao.login;

import com.khunboo.dao.BaseDao;
import com.khunboo.dto.LoginDto;
import com.khunboo.modules.entity.SysUserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserDao extends BaseDao<SysUserEntity> {

    void save(LoginDto loginDto);

    public SysUserEntity getSelectByAccount(@Param("account") String account);
}
