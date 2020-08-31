package com.gl.hack.repo;

import com.gl.hack.model.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {
}
