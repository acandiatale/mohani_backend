package kr.co.mohani.mohani_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
    @Id
    @Column(name="ID")
    private String userId;
    @Column
    private String password;
    @Column
    private String name;
    @Column(name = "group_id")
    private String groupId;


}
