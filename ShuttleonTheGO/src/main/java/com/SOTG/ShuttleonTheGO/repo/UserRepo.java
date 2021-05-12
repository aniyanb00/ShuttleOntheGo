package com.SOTG.ShuttleonTheGO.repo;


import com.SOTG.ShuttleonTheGO.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select * from user where username = ?", nativeQuery = true)
    User findbyUsername(String username);

}
