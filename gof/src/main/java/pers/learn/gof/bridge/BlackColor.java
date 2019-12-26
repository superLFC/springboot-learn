package pers.learn.gof.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlackColor implements Color {

    @Override
    public String bepaint(String penType, String thing) {
        String result = penType + " draw black " + thing;
        log.info("{} draw black {}", penType, thing);
        return result;
    }
}
