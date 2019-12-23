package pers.learn.security.service;

import pers.learn.security.entity.User;
import pers.learn.security.model.vo.UserVo;

public interface UserService {

    User getUserByUserName(String userName);

    UserVo convertByUser(User user);
}
