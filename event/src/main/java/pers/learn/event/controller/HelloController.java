package pers.learn.event.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.learn.event.model.User;
import pers.learn.event.publisher.CustomerPublisher;

@RestController
@RequestMapping("/user")
@Slf4j
public class HelloController {

    @Autowired
    private CustomerPublisher customerPublisher;

    @GetMapping("/create")
    public String createUser() {
        User user = new User();
        user.setName("Darwin");
        user.setAge("22");
        customerPublisher.publishAnEvent(user.getName());
        log.info("user:{}", JSON.toJSON(user));
        return "SUCCESS";
    }

}
