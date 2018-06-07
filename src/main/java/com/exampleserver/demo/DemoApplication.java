package com.exampleserver.demo;

import com.exampleserver.demo.Entities.task;
import com.exampleserver.demo.Service.taskServiceImpl;
import com.sun.jmx.snmp.tasks.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin(origins = {"http://localhost:4200"})
public class DemoApplication implements CommandLineRunner {

    @Autowired
    taskServiceImpl taskService;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        task task = new task();
//        task.setId(3);
//        task.setTaskName("eslam mihamed");
//        task.setTaskDesc("ahmed mohamed");
//
//        taskService.updateTask(task);
    }
}
