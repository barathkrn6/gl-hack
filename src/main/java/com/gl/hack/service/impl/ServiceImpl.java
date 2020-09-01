package com.gl.hack.service.impl;

import com.gl.hack.model.Group;
import com.gl.hack.model.Hackathon;
import com.gl.hack.model.Submission;
import com.gl.hack.model.TestCas;
import com.gl.hack.model.request.SubmitHackathon;
import com.gl.hack.model.request.SubmitTestcases;
import com.gl.hack.repo.GroupRepo;
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
import java.util.*;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HackathonRepo hackathonRepo;

    @Autowired
    private TestCasRepo testCasRepo;

    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private GroupRepo groupRepo;

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

    @Override
    public Map<String, Object> getLeaderboard(Integer hackathonId) {
        List<Submission> submissions = null;
        if (hackathonId != null) {
            submissions = submissionRepo.getUpdatedSubmission(hackathonId);
        } else {
            submissions = submissionRepo.getAllUpdatedSubmission();
        }

        Set<Integer> hackathonIds = new HashSet<>();
        Set<Integer> groupIds = new HashSet<>();
        getAllIds(submissions, hackathonIds, groupIds);

        List<Hackathon> hackData = hackathonRepo.findAllById(hackathonIds);
        List<Group> groupData = groupRepo.findAllById(groupIds);

        Map<Integer, String> hackMapData = new HashMap<>();
        Map<Integer, String> groupMapData = new HashMap<>();
        createHackGroupData(hackData, groupData, hackMapData, groupMapData);

        Map<String, Object> result = new LinkedHashMap<>();
        for (Submission s : submissions) {
            if (result.get(hackMapData.get(s.getHackthonId())) != null) {
                List<Map<String, Object>> list = (List<Map<String, Object>>) result.get(hackMapData.get(s.getHackthonId()));
                updateMap(s, result, list, hackMapData, groupMapData);
            } else {
                List<Map<String, Object>> list = new ArrayList<>();
                updateMap(s, result, list, hackMapData, groupMapData);
            }
        }
        return result;
    }

    private void createHackGroupData(List<Hackathon> hackData, List<Group> groupData,
                                     Map<Integer, String> hackMapData, Map<Integer, String> groupMapData) {
        for (Hackathon h : hackData) {
            hackMapData.put(h.getId(), h.getName());
        }
        for (Group g : groupData) {
            groupMapData.put(g.getId(), g.getName());
        }
    }

    public void getAllIds(List<Submission> submissions, Set<Integer> hackathonIds, Set<Integer> groupIds) {
        for (Submission s : submissions) {
            hackathonIds.add(s.getHackthonId());
            groupIds.add(s.getGroupId());
        }
    }
    public void updateMap(Submission s, Map<String, Object> result, List<Map<String, Object>> list, Map<Integer,
            String> hackMapData, Map<Integer, String> groupMapData) {
        Map<String, Object> tempMap = new LinkedHashMap<>();
        tempMap.put("group_id", s.getGroupId());
        tempMap.put("group_name", groupMapData.get(s.getGroupId()));
        tempMap.put("hackathon_id", s.getHackthonId());
        tempMap.put("hackathon_name", hackMapData.get(s.getHackthonId()));
        tempMap.put("points", s.getPoints());
        list.add(tempMap);

        list.sort(new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return Integer.valueOf(o2.get("points").toString()) - Integer.valueOf(o1.get("points").toString());
            }
        });

        result.put(hackMapData.get(s.getHackthonId()), list);
    }
}
