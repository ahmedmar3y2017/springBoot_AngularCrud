package com.exampleserver.demo;

import com.exampleserver.demo.Entities.task;
import com.exampleserver.demo.Service.taskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    taskServiceImpl taskService;

    @RequestMapping("/api/hello")
    public String greet() {
        return "Hello from the other side!!!";
    }


    //get all tasks
    @RequestMapping(value = "/api/tasks", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> GetAlltasks() {
        List<task> tasks = taskService.getAllTasks();
        if (tasks.size() == 0) {
            return new ResponseEntity<String>("task Not Found !!",
                    HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<List<task>>(tasks, HttpStatus.OK);

        }


    }

    // save task
    @RequestMapping(value = "/api/tasks", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> insert(@RequestBody task task) {
        if (task == null) {
            return new ResponseEntity<String>("Please add task details !!", HttpStatus.NO_CONTENT);

        }

        // check email , password
        if (task.getTaskName() == "" || task.getTaskDesc() == "") {

            return new ResponseEntity<String>("Please provide the Email and password", HttpStatus.BAD_REQUEST);

        }
        // encrypt password before insert task
        task b = taskService.saveTask(task);

        return new ResponseEntity<task>(b, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/api/tasks", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> DeleteTask(@RequestParam("id") String id) {
        int result = taskService.deleteTaskById(Integer.parseInt(id));
        if (result == 0) {
            return new ResponseEntity<String>("task Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<String>("Done Delete task ", HttpStatus.OK);

        }

    }


    // update task 
    @RequestMapping(value = "/api/tasks", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> UpdateTopic(@RequestBody task task) {

        task business = taskService.updateTask( task);
        if (business == null) {
            return new ResponseEntity<String>("task Not Found !!", HttpStatus.NOT_FOUND);

        } else {
            return new ResponseEntity<task>(business, HttpStatus.OK);

        }
    }


}