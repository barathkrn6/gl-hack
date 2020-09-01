package com.gl.hack.controller;

import com.gl.hack.model.request.SubmitHackathon;
import com.gl.hack.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/submit-hackathon")
    public ResponseEntity<?> submitHackathon(@RequestBody SubmitHackathon submitHackathon, UriComponentsBuilder ucBuilder) {
        return service.submitHackathon(submitHackathon, ucBuilder);
    }

    @GetMapping("/get-leaderboard")
    public Map<String, Object> getLeaderboard(@RequestParam(name = "hackathon_id", required = false) Integer hackathonId) {
        return service.getLeaderboard(hackathonId);
    }
}
