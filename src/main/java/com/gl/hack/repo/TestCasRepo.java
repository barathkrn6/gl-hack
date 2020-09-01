package com.gl.hack.repo;

import com.gl.hack.model.TestCas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestCasRepo extends JpaRepository<TestCas, Integer> {
}
