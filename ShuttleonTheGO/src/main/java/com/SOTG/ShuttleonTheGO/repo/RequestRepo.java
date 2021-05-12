package com.SOTG.ShuttleonTheGO.repo;

import com.SOTG.ShuttleonTheGO.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request,Integer> {
}
