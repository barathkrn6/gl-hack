package com.gl.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


/**
 * The persistent class for the groups database table.
 */
@Entity
@Table(name = "groups")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private String name;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public Group() {
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}