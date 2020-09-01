package com.gl.hack.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * The persistent class for the hackothons database table.
 */
@TypeDefs({
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        ),
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        )
})
@Entity
@Table(name = "hackathons")
@NamedQuery(name = "Hackathon.findAll", query = "SELECT h FROM Hackathon h")
public class Hackathon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Type(type = "int-array")
    @Column(name = "hidden_test_cases")
    private Integer[] hiddenTestCases;

    private String name;

    private String question;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Type(type = "int-array")
    @Column(name = "test_cases")
    private Integer[] testCases;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Type(type = "int-array")
    @Column(name = "visible_test_cases")
    private Integer[] visibleTestCases;

    public Hackathon() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer[] getHiddenTestCases() {
        return this.hiddenTestCases;
    }

    public void setHiddenTestCases(Integer[] hiddenTestCases) {
        this.hiddenTestCases = hiddenTestCases;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Integer[] getTestCases() {
        return this.testCases;
    }

    public void setTestCases(Integer[] testCases) {
        this.testCases = testCases;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer[] getVisibleTestCases() {
        return this.visibleTestCases;
    }

    public void setVisibleTestCases(Integer[] visibleTestCases) {
        this.visibleTestCases = visibleTestCases;
    }

}