package pers.learn.security.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pers.learn.security.entity.User;
import pers.learn.security.mapper.UserMapper;
import pers.learn.security.model.vo.UserVo;
import pers.learn.security.service.UserService;

@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.findByUsername(userName);
    }

    @Override
    public UserVo convertByUser(User user) {
        if (user == null) {
            return null;
        }
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        return userVo;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updatePassByUserName(null, user.getPassword());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.findByUsername(username);
    }
}
