package pers.learn.security.mapper;

import pers.learn.security.entity.User;

public interface UserMapper extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
