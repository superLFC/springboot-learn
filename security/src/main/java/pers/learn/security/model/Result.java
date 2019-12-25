package pers.learn.security.model;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pers.learn.security.enums.ServerStautsEnum;

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

    public static Result fail(String failCode, String failMsg) {
        Result res = new Result();
        res.setCode(failCode);
        res.setMsg(failMsg);
        return res;
    }
}
