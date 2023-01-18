package kr.co.mohani.mohani_server.repository;

import kr.co.mohani.mohani_server.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {
    UserGroup findByGroupUser(String groupUser);
//    boolean existsUserGroupByGroupUser(String groupUser);
}
