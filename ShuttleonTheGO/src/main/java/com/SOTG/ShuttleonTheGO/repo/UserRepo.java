package com.SOTG.ShuttleonTheGO.repo;


import com.SOTG.ShuttleonTheGO.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where username = ? and password = ?", nativeQuery = true)
    Optional<User> findbyUsernameandPassword(String username,String password);

}
