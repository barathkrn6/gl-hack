package com.gl.hack.repo;

import com.gl.hack.model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HackathonRepo extends JpaRepository<Hackathon, Integer> {

    @Query("select h from Hackathon h where h.id = :id")
    Hackathon getById(@Param("id") Integer id);
}
