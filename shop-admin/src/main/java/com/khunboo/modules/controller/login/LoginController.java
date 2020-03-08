package com.khunboo.modules.controller.login;

import com.khunboo.dto.LoginDto;
import com.khunboo.modules.service.SysUserService;
import com.khunboo.utils.Result;
import com.khunboo.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/login")
    public Result login(@RequestParam("account") String account, @RequestParam("password") String password){

        return new Result(200, "登录成功", null);
    }


    @PostMapping("/register")
    public Result register(@Valid @RequestBody LoginDto loginDto){

        ValidatorUtils.validateEntity(loginDto);
        sysUserService.save(loginDto);
        return new Result(200, "注册成功", null);
    }
}
