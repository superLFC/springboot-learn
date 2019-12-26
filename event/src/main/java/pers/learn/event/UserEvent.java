package pers.learn.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

@Slf4j
public class UserEvent extends ApplicationEvent {

    private String message;

    public UserEvent(Object source, String message) {
        super(source);
        log.info("source clazz:{}", source.getClass());
        this.message = message;
    }
}
