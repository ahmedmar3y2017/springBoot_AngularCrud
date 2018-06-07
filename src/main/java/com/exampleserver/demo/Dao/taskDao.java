package com.exampleserver.demo.Dao;

import com.exampleserver.demo.Entities.task;

import java.util.List;

public interface taskDao {
    public List<task> getAllTasks();

    public task saveTask(task task);

}
