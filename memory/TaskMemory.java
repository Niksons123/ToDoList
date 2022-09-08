package memory;

import entity.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaskMemory {
    private final Map<Integer, Task> taskMap = new HashMap<>();

    public Task addTask(String name, String description, String status, String category) {
        Task task = new Task(name, description, status, category);
        taskMap.put(task.getId(), task);
        return taskMap.get( task.getId() );
    }

    public Task findTask(int id) {
        return taskMap.get(id);
    }
    public List<Task> findTasksByCategory(String category) {
        return taskMap.values().stream().filter(task -> task.getCategory().equals(category)).collect(Collectors.toList());
    }
    public void updateTask(int id, String name, String description, String status, String category) {
        Task task = taskMap.get(id);
        task.setName( name );
        task.setDescription( description );
        task.setStatus( status );
        task.setCategory( category );
    }

    public Task deleteTask(int id) {
         return taskMap.remove(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskMemory that = (TaskMemory) o;
        return Objects.equals( taskMap, that.taskMap );
    }

    @Override
    public int hashCode() {
        return Objects.hash( taskMap );
    }
}
