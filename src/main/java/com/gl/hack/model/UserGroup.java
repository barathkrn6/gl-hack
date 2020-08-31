package com.gl.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


/**
 * The persistent class for the user_group database table.
 */
@Entity
@Table(name = "user_group")
@NamedQuery(name = "UserGroup.findAll", query = "SELECT u FROM UserGroup u")
public class UserGroup implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "user_id")
    private Integer userId;

    public UserGroup() {
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

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}