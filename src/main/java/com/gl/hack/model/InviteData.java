package com.gl.hack.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;


/**
 * The persistent class for the invite_data database table.
 */
@Entity
@Table(name = "invite_data")
@NamedQuery(name = "InviteData.findAll", query = "SELECT i FROM InviteData i")
public class InviteData implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "invited_by_user_id")
    private Integer invitedByUserId;

    @Column(name = "invited_to_user_id")
    private Integer invitedToUserId;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public InviteData() {
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

    public Integer getInvitedByUserId() {
        return this.invitedByUserId;
    }

    public void setInvitedByUserId(Integer invitedByUserId) {
        this.invitedByUserId = invitedByUserId;
    }

    public Integer getInvitedToUserId() {
        return this.invitedToUserId;
    }

    public void setInvitedToUserId(Integer invitedToUserId) {
        this.invitedToUserId = invitedToUserId;
    }

    public Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}