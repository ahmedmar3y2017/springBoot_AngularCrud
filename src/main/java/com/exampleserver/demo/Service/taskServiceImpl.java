package com.exampleserver.demo.Service;

import com.exampleserver.demo.Dao.taskDaoImpl;
import com.exampleserver.demo.Entities.task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taskServiceImpl implements taskService {

    @Autowired
    taskDaoImpl taskDao;

    @Override
    public List<task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public task saveTask(task task) {
        return taskDao.saveTask(task);
    }

    @Override
    public int deleteTaskById(int id) {
        return taskDao.deleteTaskById(id);
    }

    @Override
    public task updateTask( task b) {
        return taskDao.updateTask( b);
    }
}
