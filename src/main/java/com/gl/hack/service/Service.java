package com.gl.hack.service;

import com.gl.hack.model.request.SubmitHackathon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public interface Service {
    ResponseEntity<?> submitHackathon(SubmitHackathon submitHackathon, UriComponentsBuilder ucBuilder);

    Map<String, Object> getLeaderboard(Integer hackathonId);
}
