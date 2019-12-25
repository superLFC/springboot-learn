package pers.learn.security.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserVo {

    private String username;

    private Date dateCreate;

    private Date dateUpdate;
}
