package com.creationline.springbootscheduler.data.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.creationline.springbootscheduler.data.models.TtTask;

@Transactional(readOnly = true)
public interface TtTaskRepository extends JpaRepository<TtTask, String> {

	List<TtTask> findAllByStatus(Integer status);

	@Modifying
	@Query("update TtTask task set " + " task.status = :status " + " where task.task_id = :taskID")
	public Integer updateStatus(@Param("status") Integer status, @Param("taskID") String taskID);
}
