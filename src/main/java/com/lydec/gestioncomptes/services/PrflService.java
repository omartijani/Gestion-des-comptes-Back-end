package com.lydec.gestioncomptes.services;

import com.lydec.gestioncomptes.Repository.PrflRepository;
import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Prfl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PrflService {


    @Autowired
    private PrflRepository prflRepository;

    public Prfl addPrfl(Prfl prfl) {

        return prflRepository.save(prfl);
    }




    public List<Prfl> getAllPrfls() {
        return prflRepository.findAll();
    }


    public Prfl getPrflById(Integer profNum) {
        return prflRepository.findById(profNum).orElse(null);
    }


    public void updatePrfl(Prfl prfl) {
        Prfl existingPrfl = prflRepository.findById(prfl.getProfNum()).orElse(null);

        if (existingPrfl != null) {

            existingPrfl.setProfNum(prfl.getProfNum());
            existingPrfl.setProfNom(prfl.getProfNom());
            existingPrfl.setActions(prfl.getActions());

            prflRepository.save(existingPrfl);
        } else {

            throw new EntityNotFoundException("Prfl with ProfNum " + prfl.getProfNum() + " not found.");
        }
    }

    public void deletePrfl(Integer profNum) {
        prflRepository.deleteById(profNum);
    }
    public void addActionToPrfl(Integer prflNum, Action action) {
        Prfl prfl = prflRepository.findById(prflNum).orElse(null);

        if (prfl != null) {
            Set<Action> actions = prfl.getActions();
            actions.add(action);
            prfl.setActions(actions);
            prflRepository.save(prfl);
        } else {
            throw new EntityNotFoundException("Prfl with ProfNum " + prflNum + " not found.");
        }
    }
    public void removeActionFromProfile(Integer profileId, String actionId) {
        Optional<Prfl> optionalProfile = prflRepository.findById(profileId);

        if (optionalProfile.isPresent()) {
            Prfl profile = optionalProfile.get();
            Set<Action> actions = profile.getActions();


            actions.removeIf(action -> action.getActId().equals(actionId));


            profile.setActions(actions);
            prflRepository.save(profile);
        }
    }
}

