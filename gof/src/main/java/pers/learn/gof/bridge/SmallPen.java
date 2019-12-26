package pers.learn.gof.bridge;

import pers.learn.gof.PenTypeEnum;

public class SmallPen extends AbstactPen {

    public SmallPen() {
        this.penType = PenTypeEnum.SMALL_PEN;
    }

    @Override
    public String draw(String thing) {
        return this.color.bepaint(this.penType.getDesc(), thing);
    }
}
