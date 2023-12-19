package com.lydec.gestioncomptes.services;

import com.lydec.gestioncomptes.Repository.PrflRepository;
import com.lydec.gestioncomptes.Repository.UtilisateursRepository;
import com.lydec.gestioncomptes.model.Prfl;
import com.lydec.gestioncomptes.model.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class UtilisateursService {
    private final UtilisateursRepository utilisateursRepository;
    private  final PrflRepository PrflRepository;

    @Autowired
    public UtilisateursService(UtilisateursRepository utilisateursRepository, com.lydec.gestioncomptes.Repository.PrflRepository prflRepository) {
        this.utilisateursRepository = utilisateursRepository;
        PrflRepository = prflRepository;
    }



    public Utilisateurs addUtilisateur(Utilisateurs utilisateur) {
        return utilisateursRepository.save(utilisateur);
    }


    public List<Utilisateurs> getAllUtilisateurs() {
        return utilisateursRepository.findAll();
    }


    public Utilisateurs getUtilisateurByLogin(String login) {
        return utilisateursRepository.findById(login).orElse(null);
    }


    public void updateUtilisateur(Utilisateurs utilisateur) {
        Utilisateurs existingUtilisateur = utilisateursRepository.findById(utilisateur.getLogin()).orElse(null);

        if (existingUtilisateur != null) {

            existingUtilisateur.setLogin(utilisateur.getLogin());
            existingUtilisateur.setMatr(utilisateur.getMatr());
            existingUtilisateur.setPasswdWebs(utilisateur.getPasswdWebs());
            existingUtilisateur.setWebsPassCle(utilisateur.getWebsPassCle());
            existingUtilisateur.setAgcCode(utilisateur.getAgcCode());
            existingUtilisateur.setSiteApprov(utilisateur.getSiteApprov());
            existingUtilisateur.setUserFix(utilisateur.getUserFix());
            existingUtilisateur.setPasswdFix(utilisateur.getPasswdFix());
            existingUtilisateur.setIfxPassCle(utilisateur.getIfxPassCle());
            existingUtilisateur.setCltsaValide(utilisateur.getCltsaValide());
            existingUtilisateur.setUserAd(utilisateur.getUserAd());
            existingUtilisateur.setPasswdAd(utilisateur.getPasswdAd());
            existingUtilisateur.setProfiles(utilisateur.getProfiles());

            utilisateursRepository.save(existingUtilisateur);
        } else {

            throw new EntityNotFoundException("Utilisateur with Login " + utilisateur.getLogin() + " not found.");
        }
    }


    public void deleteUtilisateur(String login) {

        utilisateursRepository.deleteById(login);
    }
    public void addProfileToUtilisateur(String login, Integer profNum) {
        Utilisateurs utilisateur = utilisateursRepository.findById(login)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found with login: " + login));

        Prfl profile = PrflRepository.findById(profNum)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found with profNum: " + profNum));

        utilisateur.getProfiles().add(profile);
        utilisateursRepository.save(utilisateur);
    }

    public void removeProfileFromUtilisateur(String login, Integer profNum) {
        Utilisateurs utilisateur = utilisateursRepository.findById(login)
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur not found with login: " + login));

        Prfl profile = PrflRepository.findById(profNum)
                .orElseThrow(() -> new EntityNotFoundException("Profile not found with profNum: " + profNum));

        utilisateur.getProfiles().remove(profile);
        utilisateursRepository.save(utilisateur);
    }
    }


