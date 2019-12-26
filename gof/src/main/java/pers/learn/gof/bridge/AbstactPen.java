package pers.learn.gof.bridge;

import pers.learn.gof.PenTypeEnum;

public abstract class AbstactPen {

    protected Color color;

    protected PenTypeEnum penType;

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String draw(String thing);
}
