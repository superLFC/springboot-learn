package pers.learn.event.listener;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pers.learn.event.UserEvent;

@Component
@Slf4j
public class AnotherCustomerEventListener {

    @Async("threadPoolTaskExecutor")
    @EventListener
    public void otherListener(UserEvent event) {
        log.info("other listener event:{}", JSON.toJSON(event));
    }
}
