package pers.learn.helloworld.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(255) not null")
    private String name;

    @Column(name = "writer", columnDefinition = "varchar(128) not null")
    private String writer;

    @Column(name = "type", columnDefinition = "varchar(64) default null")
    private String type;

    @Column(name = "date_create")
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreate;

    @Column(name = "date_update")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date dateUpdate;
}
