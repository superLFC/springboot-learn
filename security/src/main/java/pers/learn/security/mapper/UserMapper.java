package pers.learn.security.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pers.learn.security.entity.User;

@Mapper
public interface UserMapper {

    User findByUsername(@Param("userName") String userName);

    int updatePassByUserName(@Param("userName") String userName,
                             @Param("password") String password);

    void insert(User user);
}
