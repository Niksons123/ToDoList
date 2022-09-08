package entity;

import java.util.Objects;
import java.util.Random;

public class Task {
    private int id;
    private String name;
    private String status;
    private String description;
    private String category;

    public Task(String name, String status, String description, String category) {
        this.id = new Random().nextInt();
        this.name = name;
        this.status = status;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals( name, task.name ) && Objects.equals( status, task.status ) && Objects.equals( description, task.description ) && Objects.equals( category, task.category );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, name, status, description, category );
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
