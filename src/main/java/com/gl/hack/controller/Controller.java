package com.gl.hack.controller;

import com.gl.hack.model.request.SubmitHackathon;
import com.gl.hack.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/submit-hackathon")
    public ResponseEntity<?> submitHackathon(@RequestBody SubmitHackathon submitHackathon, UriComponentsBuilder ucBuilder) {
        return service.submitHackathon(submitHackathon, ucBuilder);
    }
}
