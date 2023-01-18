package kr.co.mohani.mohani_server.repository;

import kr.co.mohani.mohani_server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {

    Users findByUserId(String userId);

}
