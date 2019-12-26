package pers.learn.gof;

public enum PenTypeEnum {

    SMALL_PEN("小号笔"),

    MIDDLE_PEN("中号笔"),

    BIG_PEN("大号笔");

    private String desc;

    PenTypeEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
