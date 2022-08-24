package com.vaya.bestpractice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.vaya.bestpractice.service.core.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("workExecutor")
	TaskExecutor taskExecutor;

	@Override
	public void multiTasking() {
		for (int i = 0; i < 10; i++) {
			asyncTask(i);
			taskExecutor.execute(getTask(i));
        }
	}
	
	private Runnable getTask (int i) {
        return () -> {
           System.out.printf("running task %d. Thread: %s%n",i,Thread.currentThread().getName());
       };
   }
	
	@Autowired
	@Async("workExecutor")
	private void  asyncTask(int i) {
		System.out.printf("running task %d. Thread: %s%n",i,Thread.currentThread().getName());
	}
	
	
	
}
