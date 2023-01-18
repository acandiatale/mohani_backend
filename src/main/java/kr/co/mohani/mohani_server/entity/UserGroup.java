package kr.co.mohani.mohani_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER_GROUP")
@SequenceGenerator(name = "USERGROUP_SEQ_GENERATOR",sequenceName = "USERGROUP_SEQ", initialValue = 1, allocationSize = 5)
public class UserGroup {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERGROUP_SEQ_GENERATOR")
    @Column(name="GROUP_INDEX")
    private Long groupIndex;
    @Column(name = "GROUP_ID")
    private String groupId;
    @Column(name = "GROUP_USER")
    private String groupUser;

}
