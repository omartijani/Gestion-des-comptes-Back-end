package com.lydec.gestioncomptes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lydec.gestioncomptes.model.Utilisateurs;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateursRepository  extends JpaRepository<Utilisateurs,String>{
    

}
