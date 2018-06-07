package com.exampleserver.demo.Service;

import com.exampleserver.demo.Entities.task;

import java.util.List;

public interface taskService {
    public List<task> getAllTasks();
    public task saveTask(task task);

}
