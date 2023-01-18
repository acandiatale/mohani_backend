package kr.co.mohani.mohani_server.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserGrouping {
    private String groupId;
    private String groupUser;
    private List<String> userList;
}
