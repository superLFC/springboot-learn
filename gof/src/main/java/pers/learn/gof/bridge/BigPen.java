package pers.learn.gof.bridge;

import pers.learn.gof.PenTypeEnum;

public class BigPen extends AbstactPen {

    public BigPen() {
        this.penType = PenTypeEnum.BIG_PEN;
    }

    @Override
    public String draw(String thing) {
        return this.color.bepaint(this.penType.getDesc(), thing);
    }
}
