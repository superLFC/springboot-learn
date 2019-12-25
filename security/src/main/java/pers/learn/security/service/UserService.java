package pers.learn.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pers.learn.security.entity.User;
import pers.learn.security.model.vo.UserVo;

public interface UserService extends UserDetailsService{

    User getUserByUserName(String userName);

    UserVo convertByUser(User user);

    void addUser(User user);

    void updateUser(User user);
}
