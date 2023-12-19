package com.lydec.gestioncomptes.Repository;

import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Apps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppsRepository extends JpaRepository<Apps,String> {
    @Query("SELECT a FROM Action a WHERE a.apps.appId = :appId")
    List<Action> findActionsByAppId(String appId);
    
}
