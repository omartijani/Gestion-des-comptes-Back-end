package com.lydec.gestioncomptes.services;

import com.lydec.gestioncomptes.Repository.ActionRepository;
import com.lydec.gestioncomptes.Repository.AppsRepository;
import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Apps;
import com.lydec.gestioncomptes.model.Prfl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ActionService {
    private final ActionRepository actionRepository;
    private final AppsRepository appsRepository;

    @Autowired
    public ActionService(ActionRepository actionRepository, AppsRepository appsRepository) {
        this.actionRepository = actionRepository;
        this.appsRepository = appsRepository;
    }


    public List<Action> getAllActions() {
        return actionRepository.findAll();
    }

    public Action getActionById(String actId) {
        return actionRepository.findById(actId).orElse(null);
    }

    public void addAction(Action action, String appId) {
        Apps apps = appsRepository.findById(appId).orElse(null);

        if (apps == null) {
            throw new EntityNotFoundException("Apps with id " + appId + " not found.");
        }

        action.setApps(apps);
        actionRepository.save(action);
    }

    public void updateAction(Action action) {
        actionRepository.save(action);

        Action nAction = actionRepository.findById(action.getActId()).orElse(null);
        if (nAction != null){
            nAction.setActId(action.getActId());
            nAction.setActBsecurise(action.getActBsecurise());

            nAction.setApps(action.getApps());
            nAction.setActLb(action.getActLb());
            nAction.setActLib(action.getActLib());


            actionRepository.save(nAction);
        }else {

            throw new EntityNotFoundException("Action with id " + action.getActId() + " not found.");
        }


    }
    public  void deleteAction(Action action){
        actionRepository.delete(action);
    }

    public List<Prfl> getProfilesByActId(String actId) {
        return actionRepository.findProfilesByActId(actId);
    }
}