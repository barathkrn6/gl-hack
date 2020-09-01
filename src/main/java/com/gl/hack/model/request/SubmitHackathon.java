package com.gl.hack.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class SubmitHackathon implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("group_id")
    public Integer groupId;

    @JsonProperty("hackathon_id")
    public Integer hackathonId;

    @JsonProperty("submit_testcases")
    public List<SubmitTestcases> submitTestcasesList;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHackathonId() {
        return hackathonId;
    }

    public void setHackathonId(Integer hackathonId) {
        this.hackathonId = hackathonId;
    }

    public List<SubmitTestcases> getSubmitTestcasesList() {
        return submitTestcasesList;
    }

    public void setSubmitTestcasesList(List<SubmitTestcases> submitTestcasesList) {
        this.submitTestcasesList = submitTestcasesList;
    }

    @Override
    public String toString() {
        return "SubmitHackathon{" +
                "groupId=" + groupId +
                ", hackathonId=" + hackathonId +
                ", submitTestcasesList=" + submitTestcasesList +
                '}';
    }
}
