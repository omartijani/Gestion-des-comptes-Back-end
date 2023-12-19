package com.lydec.gestioncomptes.controller;

import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Prfl;
import com.lydec.gestioncomptes.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequestMapping("/action")
@CrossOrigin("http://localhost:3000")
public class ActionController {
    private final ActionService actionService;

    @Autowired
    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public ResponseEntity<List<Action>> getAllActions() {
        List<Action> actions = actionService.getAllActions();
        return new ResponseEntity<>(actions, HttpStatus.OK);
    }

    @GetMapping("/{actId}")
    public ResponseEntity<Action> getActionById(@PathVariable String actId) {
        Action action = actionService.getActionById(actId);
        if (action != null) {
            return new ResponseEntity<>(action, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{appId}")
    public ResponseEntity<Void> addAction(@PathVariable String appId, @RequestBody Action action) {
        try {
            actionService.addAction(action, appId);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{actId}")
    public ResponseEntity<Void> updateAction(@PathVariable String actId, @RequestBody Action action) {
        try {
            action.setActId(actId);
            actionService.updateAction(action);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{actId}")
    public ResponseEntity<Void> deleteAction(@PathVariable String actId) {
        Action actionToDelete = actionService.getActionById(actId);
        if (actionToDelete != null) {
            actionService.deleteAction(actionToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{actId}/profiles")
    public List<Prfl> getProfileByActId(@PathVariable String actId) {
        return actionService.getProfilesByActId(actId);
    }
}
