package com.creationline.springbootscheduler.scheduler.jobs;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.creationline.springbootscheduler.common.utils.AppLogger;
import com.creationline.springbootscheduler.data.models.TtTask;
import com.creationline.springbootscheduler.data.repositories.TtTaskRepository;

@Component
@Transactional
public class SampleJob implements Job {

	private final static AppLogger logger = AppLogger.getInstance();

	@Autowired
	private TtTaskRepository ttTaskRepository;

	public void execute(JobExecutionContext context) throws JobExecutionException {

		List<TtTask> tasks = ttTaskRepository.findAllByStatus(0);

		if (tasks != null && !tasks.isEmpty()) {

			for (TtTask task : tasks) {
				ttTaskRepository.updateStatus(1, task.getTask_id());

				logger.info("Start to process taskID=" + String.valueOf(task.getTask_id()));
			}
		}
	}

}
