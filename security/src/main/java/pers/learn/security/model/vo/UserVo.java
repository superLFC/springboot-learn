package pers.learn.security.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {

    private String userName;

    private Date dateCreate;

    private Date dateUpdate;
}
