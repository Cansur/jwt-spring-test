package test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.demo.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
    
}
