package com.lydec.gestioncomptes.controller;

import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Prfl;
import com.lydec.gestioncomptes.services.PrflService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/prfl")
@CrossOrigin("http://localhost:3000")
public class PrflController {
    private final PrflService prflService;

    @Autowired
    public PrflController(PrflService prflService) {
        this.prflService = prflService;
    }

    @PostMapping
    public ResponseEntity<Prfl> addPrfl(@RequestBody Prfl prfl) {
        Prfl addedPrfl = prflService.addPrfl(prfl);
        return new ResponseEntity<>(addedPrfl, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Prfl>> getAllPrfls() {
        List<Prfl> prfls = prflService.getAllPrfls();
        return new ResponseEntity<>(prfls, HttpStatus.OK);
    }

    @GetMapping("/{profNum}")
    public ResponseEntity<Prfl> getPrflById(@PathVariable Integer profNum) {
        Prfl prfl = prflService.getPrflById(profNum);
        if (prfl != null) {
            return new ResponseEntity<>(prfl, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{profNum}")
    public ResponseEntity<Void> updatePrfl(@PathVariable Integer profNum, @RequestBody Prfl prfl) {
        try {
            prfl.setProfNum(profNum);
            prflService.updatePrfl(prfl);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{profNum}")
    public ResponseEntity<Void> deletePrfl(@PathVariable Integer profNum) {
        prflService.deletePrfl(profNum);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{profNum}/addAction")
    public ResponseEntity<Prfl> addActionToPrfl(@PathVariable Integer profNum, @RequestBody Action action) {
        try {
            prflService.addActionToPrfl(profNum, action);
            return ResponseEntity.ok().body(prflService.getPrflById(profNum));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{profileId}/actions/{actionId}")
    public ResponseEntity<String> removeActionFromProfile(
            @PathVariable Integer profileId,
            @PathVariable String actionId) {
        try {
            prflService.removeActionFromProfile(profileId, actionId);
            return ResponseEntity.ok("Action removed from profile successfully.");
        } catch (EntityNotFoundException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }
}
