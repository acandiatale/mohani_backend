package kr.co.mohani.mohani_server.controller;

import kr.co.mohani.mohani_server.entity.UserGroup;
import kr.co.mohani.mohani_server.entity.UserGrouping;
import kr.co.mohani.mohani_server.entity.Users;
import kr.co.mohani.mohani_server.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService service;

    @GetMapping("/getuser")
    public String getUser(@RequestParam String id) {
        Users user = service.getUser(id);

        return user != null ? "success" : "Faild";
    }

    @PostMapping("/addGroup")
    public String addUserGroup(@RequestBody UserGrouping userGrouping) {
        for (String user : userGrouping.getUserList()) {
            UserGroup group = new UserGroup();
            group.setGroupId(userGrouping.getGroupId());
            group.setGroupUser(user);
            service.addUserToUserGroup(group);
        }


//        service.addUserToUserGroup(group);
        return "";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users user) {
        String result = service.addUser(user);
        return result;
    }
}
