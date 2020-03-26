package com.khunboo.modules.controller.login;

import com.khunboo.Base.BaseController;
import com.khunboo.dto.LoginDto;
import com.khunboo.modules.entity.SysUserEntity;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.utils.ConvertUtils;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/login")
    public Result login(@RequestParam("account") String account, @RequestParam("password") String password){

        SysUserEntity sysUserEntity = sysUserService.getByAccount(account, password);
        if(sysUserEntity == null){
            return new Result(201, "账号或者密码错误", null);
        }

        LoginDto dto = ConvertUtils.sourceToTarget(sysUserEntity, LoginDto.class);
        //缓存用户数据
        sysUserService.cacheUser(dto, getHttpServletResponse(), getHttpServletRequest());
        return new Result(200, "登录成功", null);
    }


    @PostMapping("/register")
    public Result register(@Valid @RequestBody LoginDto loginDto){

        ValidatorUtils.validateEntity(loginDto);
        sysUserService.save(loginDto);
        return new Result(200, "注册成功", null);
    }
}
