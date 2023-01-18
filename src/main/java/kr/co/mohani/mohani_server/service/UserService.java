package kr.co.mohani.mohani_server.service;

import kr.co.mohani.mohani_server.entity.UserGroup;
import kr.co.mohani.mohani_server.entity.UserGrouping;
import kr.co.mohani.mohani_server.entity.Users;
import kr.co.mohani.mohani_server.repository.UserGroupRepository;
import kr.co.mohani.mohani_server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserGroupRepository userGroupRepository;

    public Users getUser(String id){
        Users user = repository.findByUserId(id);
        log.info("UserId={}, name={}", user.getUserId(), user.getName());
        return user;
    }

    public String addUser(Users user) {
        Users saved = repository.save(user);
        log.info("UserSaved = {}", saved.getUserId());
        return saved.getUserId();
    }

    public UserGroup addUserToUserGroup(UserGroup group) {
        UserGroup result = userGroupRepository.findByGroupUser(group.getGroupUser());
        if(result == null) {
            UserGroup test = userGroupRepository.save(group);
            repository.
        } else {

        }
        return result;
    }
}
