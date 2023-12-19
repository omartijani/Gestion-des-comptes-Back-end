package com.lydec.gestioncomptes.controller;

import com.lydec.gestioncomptes.model.Prfl;
import com.lydec.gestioncomptes.model.Utilisateurs;
import com.lydec.gestioncomptes.services.UtilisateursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("http://localhost:3000")
public class UtilisateursController {
    private final UtilisateursService utilisateursService;

    @Autowired
    public UtilisateursController(UtilisateursService utilisateursService) {
        this.utilisateursService = utilisateursService;
    }

    @PostMapping
    public ResponseEntity<Utilisateurs> addUtilisateur(@RequestBody Utilisateurs utilisateur) {
        Utilisateurs addedUtilisateur = utilisateursService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(addedUtilisateur, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs() {
        List<Utilisateurs> utilisateurs = utilisateursService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/{login}")
    public ResponseEntity<Utilisateurs> getUtilisateurByLogin(@PathVariable String login) {
        Utilisateurs utilisateur = utilisateursService.getUtilisateurByLogin(login);
        if (utilisateur != null) {
            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{login}")
    public ResponseEntity<Void> updateUtilisateur(@PathVariable String login, @RequestBody Utilisateurs utilisateur) {
        try {
            utilisateur.setLogin(login);
            utilisateursService.updateUtilisateur(utilisateur);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable String login) {
        utilisateursService.deleteUtilisateur(login);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{login}/addProfile/{profNum}")
    public ResponseEntity<String> addProfileToUtilisateur(
            @PathVariable String login,
            @PathVariable Integer profNum) {
        try {
            utilisateursService.addProfileToUtilisateur(login, profNum);
            return ResponseEntity.ok("Profile added to Utilisateur successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    @DeleteMapping("/{login}/removeProfile/{profNum}")
    public ResponseEntity<String> removeProfileFromUtilisateur(
            @PathVariable String login,
            @PathVariable Integer profNum) {
        try {
            utilisateursService.removeProfileFromUtilisateur(login, profNum);
            return ResponseEntity.ok("Profile removed from Utilisateur successfully.");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }



}
