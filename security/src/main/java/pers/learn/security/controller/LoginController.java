package pers.learn.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.learn.security.entity.User;
import pers.learn.security.model.Result;
import pers.learn.security.model.vo.UserVo;
import pers.learn.security.service.UserService;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/fail")
    public Result<String> loginSuccess() {
        return Result.fail(String.valueOf(HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    @PostMapping("/success")
    public Result<UserVo> loginFail() {
        //获取登录的用户的主要信息，getPrincipal即获取认证用户的主要信息，这个是程序员填充的,这里为用户名
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserVo vo = userService.convertByUser(user);
        return Result.success(vo);
    }
}
