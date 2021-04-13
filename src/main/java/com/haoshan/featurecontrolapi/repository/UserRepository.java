package com.haoshan.featurecontrolapi.repository;

import com.haoshan.featurecontrolapi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM user " +
                    "WHERE email = :email", nativeQuery = true)
    Optional<User> selectUserByEmail(@Param("email") String email);
}
