package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskExecution;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public List<Task> getAllTasks(@RequestParam(required=false) String id){
        if(id != null) return service.getTaskById(id).map(List::of).orElseThrow(() -> new RuntimeException("Not found"));
        return service.getAllTasks();
    }

    @PutMapping
    public Task saveTask(@RequestBody Task task){ return service.saveTask(task); }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable String id){ service.deleteTask(id); }

    @GetMapping("/search")
    public List<Task> findByName(@RequestParam String name){ return service.findTasksByName(name); }

    @PutMapping("/{id}/run")
    public TaskExecution runTask(@PathVariable String id) throws Exception{ return service.runTask(id); }
}
