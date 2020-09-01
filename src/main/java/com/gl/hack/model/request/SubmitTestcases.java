package com.gl.hack.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class SubmitTestcases implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("testcase_id")
    public Integer testcaseId;

    @JsonProperty("submitted_values")
    public List<String> submittedValues;

    public Integer getTestcaseId() {
        return testcaseId;
    }

    public void setTestcaseId(Integer testcaseId) {
        this.testcaseId = testcaseId;
    }

    public List<String> getSubmittedValues() {
        return submittedValues;
    }

    public void setSubmittedValues(List<String> submittedValues) {
        this.submittedValues = submittedValues;
    }

    @Override
    public String toString() {
        return "SubmitTestcases{" +
                "testcaseId=" + testcaseId +
                ", submittedValues=" + submittedValues +
                '}';
    }
}
