package test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.demo.data.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
    Boolean existsByUsername(String username);

    //username으로 회원 조회
    UserEntity findByUsername(String username);
}
