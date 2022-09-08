package service;

import entity.Task;
import memory.TaskMemory;

import java.util.List;

public class TaskService {

    private final TaskMemory taskMemory = new TaskMemory();

    // Create
    public Task saveTask(String name, String description, String status, String category) {
        return taskMemory.addTask( name, description, status, category );
    }

    // Read
    public Task findTask(int id) {
        return taskMemory.findTask( id );
    }

    public List<Task> findTasksByCategory(String category) {
        return taskMemory.findTasksByCategory( category);
    }

    // Update
    public void updateTask(int id, String name, String description, String status, String category) {
        taskMemory.updateTask( id, name, description, status, category );
    }

    // Delete
    public Task deleteTask(int id) {
        return taskMemory.deleteTask( id );
    }
}
