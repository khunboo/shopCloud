package com.khunboo.modules.dao.login;

import com.khunboo.dao.BaseDao;
import com.khunboo.dto.LoginDto;
import com.khunboo.modules.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface SysUserDao extends BaseDao<SysUserEntity> {

    void save(LoginDto loginDto);

    SysUserEntity getSelectByAccount(@Param("username") String username);
}
