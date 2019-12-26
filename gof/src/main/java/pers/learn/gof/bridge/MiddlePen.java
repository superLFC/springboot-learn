package pers.learn.gof.bridge;

import pers.learn.gof.PenTypeEnum;

public class MiddlePen extends AbstactPen {

    public MiddlePen() {
        this.penType = PenTypeEnum.MIDDLE_PEN;;
    }

    @Override
    public String draw(String thing) {
        return this.color.bepaint(this.penType.getDesc(), thing);
    }
}
