package com.gl.hack.repo;

import com.gl.hack.model.Hackothon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HackothonRepo extends JpaRepository<Hackothon, Integer> {
}
