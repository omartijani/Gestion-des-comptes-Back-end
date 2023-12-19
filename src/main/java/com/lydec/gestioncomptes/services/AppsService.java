package com.lydec.gestioncomptes.services;

import com.lydec.gestioncomptes.Repository.AppsRepository;

import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Apps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

@Service
public class AppsService {
    private final AppsRepository appsRepository;

    @Autowired
    public AppsService(AppsRepository appsRepository) {
        this.appsRepository = appsRepository;
    }

    public List<Apps> getAllApps() {
        return appsRepository.findAll();
    }

    public Apps getAppById(String appId) {
        return appsRepository.findById(appId).orElse(null);
    }

    public void addApp(Apps app) {
        appsRepository.save(app);
    }

    public void updateApp(Apps app) {

        Apps nApp = appsRepository.findById(app.getAppId()).orElse(null);

        if (nApp != null) {
            nApp.setAppCreation(app.getAppCreation());
            nApp.setAppDomaine(app.getAppDomaine());
            nApp.setAppVersion(app.getAppVersion());
            nApp.setAppHelp(app.getAppHelp());
            nApp.setAppAuteur(app.getAppAuteur());
            nApp.setAppModifcation(app.getAppModifcation());
            nApp.setAppOuverte(app.getAppOuverte());
            nApp.setAppDatFermeture(app.getAppDatFermeture());
            nApp.setAppTypMsg(app.getAppTypMsg());
            nApp.setAppLibMsg(app.getAppLibMsg());
            nApp.setAppLb(app.getAppLb());


            appsRepository.save(nApp);
        }else {

            throw new EntityNotFoundException("App with Id " + app.getAppId() + " not found.");
        }
    }
    public void deleteApp(Apps app){
        appsRepository.delete(app);
    }
    public List<Action> getActionsByAppId(String appId) {
        return appsRepository.findActionsByAppId(appId);
    }
}


