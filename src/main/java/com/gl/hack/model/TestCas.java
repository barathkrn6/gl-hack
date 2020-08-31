package com.gl.hack.model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the test_cases database table.
 */
@Entity
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
@Table(name = "test_cases")
@NamedQuery(name = "TestCas.findAll", query = "SELECT t FROM TestCas t")
public class TestCas implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "assert_values")
    private String[] assertValues;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private String name;

    private Integer points;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public TestCas() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getAssertValues() {
        return this.assertValues;
    }

    public void setAssertValues(String[] assertValues) {
        this.assertValues = assertValues;
    }

    public Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return this.points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}