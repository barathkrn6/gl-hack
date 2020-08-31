package com.gl.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


/**
 * The persistent class for the submissions database table.
 */
@Entity
@Table(name = "submissions")
@NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s")
public class Submission implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "hackthon_id")
    private Integer hackthonId;

    private Integer points;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Submission() {
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

    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getHackthonId() {
        return this.hackthonId;
    }

    public void setHackthonId(Integer hackthonId) {
        this.hackthonId = hackthonId;
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