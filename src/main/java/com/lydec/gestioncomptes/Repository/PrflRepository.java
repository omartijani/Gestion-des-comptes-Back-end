package com.lydec.gestioncomptes.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lydec.gestioncomptes.model.Prfl;
import org.springframework.stereotype.Repository;

@Repository
public interface PrflRepository extends JpaRepository<Prfl,Integer> {
    
}
