package com.SOTG.ShuttleonTheGO.repo;

import com.SOTG.ShuttleonTheGO.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface StopRepo extends JpaRepository<Stop,Integer> {

    @Query(value= "select * from stop where stop_name = ?",nativeQuery = true)
    Stop getByStop_name(String stopName);

}
