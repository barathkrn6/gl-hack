package com.gl.hack.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


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
    private LocalDateTime createdAt;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "hackthon_id")
    private Integer hackthonId;

    private Integer points;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Submission() {
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

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}