package com.khunboo.modules.controller.login;

import com.khunboo.dto.LoginDto;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/login")
    public Result login(@Valid @RequestBody LoginDto login){

        return new Result(200, "登录成功", null);
    }


    @RequestMapping("/register")
    public Result register(@Valid @RequestBody LoginDto loginDto){

        ValidatorUtils.validateEntity(loginDto);
        sysUserService.save(loginDto);
        return new Result(200, "注册成功", null);
    }
}
