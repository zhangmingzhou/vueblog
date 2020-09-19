package com.markerhub.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.markerhub.common.dto.LoginDto;
import com.markerhub.common.dto.UpdateDto;
import com.markerhub.common.exception.BlogException;
import com.markerhub.common.lang.Result;
import com.markerhub.entity.User;
import com.markerhub.service.UserService;
import com.markerhub.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        User user = null;
        try {
            user = userService.getOne(loginDto.getUsername());
        } catch (BlogException blogexception) {
            return Result.fail("没有该用户");
        }


        if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expost-Headers", "Authorization");

        return Result.succ(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map());
    }

    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.succ(null);
    }

    @PostMapping("/sign")
    public Result signUp(@Validated @RequestBody User user){
        userService.insertOne(user);
        return Result.succ(user);
    }

    @PostMapping("/update")
    public  Result update(@Validated @RequestBody UpdateDto updateDto){
        userService.updateOne(updateDto);
        String message = "修改成功";
        return Result.succ(message);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody User user){
        userService.deleteOne(user);
        return Result.succ("账号删除成功");
    }
}
