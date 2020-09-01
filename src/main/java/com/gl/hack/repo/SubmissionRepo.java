package com.gl.hack.repo;

import com.gl.hack.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission, Integer> {

    @Query(value = "select s1.* from submissions s1 join (select group_id, hackthon_id, max(created_at) as " +
            "max_submit_date from submissions group by group_id, hackthon_id) s2 on s1.group_id = s2.group_id and " +
            "s1.hackthon_id = s2.hackthon_id and s1.created_at = s2.max_submit_date", nativeQuery = true)
    List<Submission> getAllUpdatedSubmission();

    @Query(value = "select s1.* from submissions s1 join (select group_id, hackthon_id, max(created_at) as " +
            "max_submit_date from submissions group by group_id, hackthon_id) s2 on s1.group_id = s2.group_id and " +
            "s1.hackthon_id = s2.hackthon_id and s1.created_at = s2.max_submit_date and s1.hackthon_id = :hackthon_id",
            nativeQuery = true)
    List<Submission> getUpdatedSubmission(@Param("hackthon_id") Integer hackthonId);
}
