package pers.learn.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.learn.security.entity.User;
import pers.learn.security.model.Result;
import pers.learn.security.model.vo.UserVo;
import pers.learn.security.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Result<UserVo> create(@RequestParam("username") String username,
                                 @RequestParam("pasword") String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername(username);
        user.setPassword(encoder.encode(password));
        userService.addUser(user);
        return Result.success(userService.convertByUser(user));
    }
}
