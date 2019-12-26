package pers.learn.gof.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedColor implements Color {

    @Override
    public String bepaint(String penType, String thing) {
        String result = penType + " draw red " + thing;
        log.info("{} draw red {}", penType, thing);
        return result;
    }
}
