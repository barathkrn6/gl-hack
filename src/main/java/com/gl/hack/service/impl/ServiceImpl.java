package com.gl.hack.service.impl;

import com.gl.hack.model.Hackathon;
import com.gl.hack.model.Submission;
import com.gl.hack.model.TestCas;
import com.gl.hack.model.request.SubmitHackathon;
import com.gl.hack.model.request.SubmitTestcases;
import com.gl.hack.repo.HackathonRepo;
import com.gl.hack.repo.SubmissionRepo;
import com.gl.hack.repo.TestCasRepo;
import com.gl.hack.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HackathonRepo hackathonRepo;

    @Autowired
    private TestCasRepo testCasRepo;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Override
    public ResponseEntity<?> submitHackathon(SubmitHackathon submitHackathon, UriComponentsBuilder ucBuilder) {
        try {
            logger.info("Request to submit hackaton :: {}", submitHackathon.toString());
            Hackathon hackathonData = hackathonRepo.getById(submitHackathon.getHackathonId());
            Integer[] testCases = hackathonData.getTestCases();

            Map<Integer, List<String>> submittedTestCases = new HashMap<>();
            List<SubmitTestcases> testCaseSubmitted = submitHackathon.getSubmitTestcasesList();
            for (SubmitTestcases tcs : testCaseSubmitted) {
                submittedTestCases.put(tcs.getTestcaseId(), tcs.getSubmittedValues());
            }

            Integer totalScore = 0;
            for (Integer tc : testCases) {
                TestCas testCas = testCasRepo.getOne(tc);
                String[] actualValues = testCas.getAssertValues();
                List<String> actualValuesList = Arrays.asList(actualValues);
                List<String> submitValuesList = submittedTestCases.get(testCas.getId());

                if (actualValuesList.equals(submitValuesList)) {
                    totalScore += testCas.getPoints();
                }
            }
            Submission submission = new Submission();
            submission.setGroupId(submitHackathon.getGroupId());
            submission.setHackthonId(submitHackathon.getHackathonId());
            submission.setPoints(totalScore);
            submission.setCreatedAt(LocalDateTime.now());
            submission.setUpdatedAt(LocalDateTime.now());
            submissionRepo.save(submission);

            HttpHeaders headers = new HttpHeaders();
            // headers.setLocation(ucBuilder.path("/submit-hackathon/{id}").buildAndExpand(submission.getId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }

    }
}
