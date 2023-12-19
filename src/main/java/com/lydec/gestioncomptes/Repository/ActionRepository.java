package com.lydec.gestioncomptes.Repository;

import com.lydec.gestioncomptes.model.Prfl;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lydec.gestioncomptes.model.Action;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionRepository extends JpaRepository<Action,String> {
    @Query("SELECT p FROM Prfl p JOIN p.actions a WHERE a.actId = :actId")
    List<Prfl> findProfilesByActId(@Param("actId") String actId);
}
