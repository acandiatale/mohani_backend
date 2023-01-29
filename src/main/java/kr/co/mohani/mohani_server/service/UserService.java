package kr.co.mohani.mohani_server.service;

import jakarta.transaction.Transactional;
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
    @Transactional
    public UserGroup addUserToUserGroup(UserGroup group) {
        UserGroup result = userGroupRepository.findByGroupUserAndGroupId(group.getGroupUser(), group.getGroupId());
        if(result == null) {
            result = new UserGroup();
            result.setGroupId(group.getGroupId());
            result.setGroupUser(group.getGroupUser());
            userGroupRepository.save(result);

            Users user = getUser(group.getGroupUser());
            user.setGroupId(group.getGroupId());
            Users savedUser = repository.save(user);
            log.info(savedUser.getGroupId());
        } else {

        }
        return result;
    }
}
