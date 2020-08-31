package com.gl.hack.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;


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
@Table(name = "hackothons")
@NamedQuery(name = "Hackothon.findAll", query = "SELECT h FROM Hackothon h")
public class Hackothon implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "hidden_test_cases")
    private Integer[] hiddenTestCases;

    private String name;

    private String question;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "test_cases")
    private Integer[] testCases;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "visible_test_cases")
    private Integer[] visibleTestCases;

    public Hackothon() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Timestamp endDate) {
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

    public Timestamp getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Integer[] getTestCases() {
        return this.testCases;
    }

    public void setTestCases(Integer[] testCases) {
        this.testCases = testCases;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer[] getVisibleTestCases() {
        return this.visibleTestCases;
    }

    public void setVisibleTestCases(Integer[] visibleTestCases) {
        this.visibleTestCases = visibleTestCases;
    }

}