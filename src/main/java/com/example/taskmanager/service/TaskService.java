package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskExecution;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.util.CommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() { return repository.findAll(); }
    public Optional<Task> getTaskById(String id) { return repository.findById(id); }
    public List<Task> findTasksByName(String name) { return repository.findByNameContaining(name); }

    public Task saveTask(Task task){
        if(!CommandValidator.isSafe(task.getCommand()))
            throw new RuntimeException("Unsafe command");
        return repository.save(task);
    }

    public void deleteTask(String id){ repository.deleteById(id); }

    public TaskExecution runTask(String taskId) throws Exception{
        Task task = repository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        TaskExecution exec = new TaskExecution();
        exec.setStartTime(new Date());

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("cmd.exe", "/c", task.getCommand());
        builder.redirectErrorStream(true);
        Process process = builder.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            output.append(line).append("\n");
        }
        process.waitFor();

        exec.setEndTime(new Date());
        exec.setOutput(output.toString());
        task.getTaskExecutions().add(exec);
        repository.save(task);
        return exec;
    }
}
