package pers.learn.event.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pers.learn.event.UserEvent;

@Component
@Slf4j
public class CustomerPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishAnEvent(String message) {
        log.info("publish an event message:{}", message);
        UserEvent event = new UserEvent(this, message);
        applicationEventPublisher.publishEvent(event);
    }
}
