package com.lydec.gestioncomptes.controller;
import com.lydec.gestioncomptes.model.Action;
import com.lydec.gestioncomptes.model.Apps;
import com.lydec.gestioncomptes.services.AppsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import java.util.List;


@RestController
@RequestMapping("/apps")
@CrossOrigin("http://localhost:3000")
public class AppsController {
    private final AppsService appsService;

    @Autowired
    public AppsController(AppsService appsService) {
        this.appsService = appsService;
    }

    @GetMapping
    public ResponseEntity<List<Apps>> getAllApps() {
        List<Apps> apps = appsService.getAllApps();
        return new ResponseEntity<>(apps, HttpStatus.OK);
    }

    @GetMapping("/{appId}")
    public ResponseEntity<Apps> getAppById(@PathVariable String appId) {
        Apps app = appsService.getAppById(appId);
        if (app != null) {
            return new ResponseEntity<>(app, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> addApp(@RequestBody Apps app) {
        appsService.addApp(app);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{appId}")
    public ResponseEntity<Void> updateApp(@PathVariable String appId, @RequestBody Apps app) {
        try {
            app.setAppId(appId);
            appsService.updateApp(app);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{appId}")
    public ResponseEntity<Void> deleteApp(@PathVariable String appId) {
        Apps appToDelete = appsService.getAppById(appId);
        if (appToDelete != null) {
            appsService.deleteApp(appToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{appId}/actions")
    public List<Action> getActionsByAppId(@PathVariable String appId) {
        return appsService.getActionsByAppId(appId);
    }
}
