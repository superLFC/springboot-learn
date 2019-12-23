package pers.learn.security.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "t_user")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name", columnDefinition = "varchar(128) not null")
    private String userName;

    @Column(name = "password", columnDefinition = "varchar(128) not null")
    private String password;

    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreate;

    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdate;
}
