package pers.learn.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/success")
    public Result<String> loginSuccess() {
        return Result.fail(String.valueOf(HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED.getReasonPhrase());
    }

    @PostMapping("/fail")
    public Result<UserVo> loginFail() {
        //获取登录的用户的主要信息，getPrincipal即获取认证用户的主要信息，这个是程序员填充的,这里为用户名
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByUserName(username);
        UserVo vo = userService.convertByUser(user);
        return Result.success(vo);
    }

    @PostMapping
    public Result<String> login(@RequestParam(name = "userName")String userName,
                                @RequestParam(name = "password")String password) {
        User user = userService.getUserByUserName(userName);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(password);
        if (user.getPassword().equals(encodePassword)) {

        }
    }
}
