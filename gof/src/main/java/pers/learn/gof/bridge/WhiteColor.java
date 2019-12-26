package pers.learn.gof.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WhiteColor implements Color {

    @Override
    public String bepaint(String penType, String thing) {
        String result = penType + " draw white " + thing;
        log.info("{} draw white {}", penType, thing);
        return result;
    }
}
