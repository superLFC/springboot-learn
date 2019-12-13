package pers.learn.helloworld.model;

import lombok.Data;
import pers.learn.helloworld.enums.ServerStautsEnum;

@Data
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public static Result success(Object data) {
        Result res = new Result();
        res.setCode(ServerStautsEnum.SUCCESS.getStatusCode());
        res.setMsg(ServerStautsEnum.SUCCESS.getDescription());
        res.setData(data);
        return res;
    }

    public static Result fail(ServerStautsEnum status) {
        Result res = new Result();
        res.setCode(status.getStatusCode());
        res.setMsg(status.getDescription());
        return res;
    }
}
