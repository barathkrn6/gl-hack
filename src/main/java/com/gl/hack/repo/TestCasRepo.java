package com.gl.hack.repo;

import com.gl.hack.model.TestCas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCasRepo extends JpaRepository<TestCas, Integer> {
}
