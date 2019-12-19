package pers.learn.security.security;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义的内存用户信息管理器
 */
@Component
@Slf4j
public class MyInMemoryUserDetailsManager implements UserDetailsManager {

    private static Map<String, UserDetails> users = new HashMap<>();

    static {
        User user = new User("Darwin", "123456", Collections.emptyList());
        users.put(user.getUsername(), user);
        log.info("init user, username:{}, password:{}", user.getUsername(), user.getPassword());
    }

    @Override
    public void createUser(UserDetails user) {
        log.info("自定义的用户管理器...createUser:{}", JSON.toJSON(user));
        users.putIfAbsent(user.getUsername(), user);
    }

    @Override
    public void updateUser(UserDetails user) {
        log.info("自定义的用户管理器...updateUser:{}", JSON.toJSON(user));
        users.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(String username) {
        log.info("自定义的用户管理器...deleteUser:{}", username);
        users.remove(username);
    }

    @SneakyThrows
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
        if (currentUser == null) {
            throw new AccessDeniedException("Can't change user password ,bacause there is no Authentication object found in context fro current user");
        }

        String username = currentUser.getName();
        UserDetails user = users.get(username);

        if (user == null) {
            throw new IllegalStateException("Current user doesn't exist!!!");
        }

        //TODO 仿照InMemory
    }

    @Override
    public boolean userExists(String username) {
        log.info("自定义的用户管理器...userExists:{}", username);
        return users.containsKey(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("自定义的用户管理器...loadUserByUsername:{}", username);
        return users.get(username);
    }
}
