package net.llira.task_app.models;

public class Task {
    private String taskKey;
    private String description;
    private String priority;
    private String date;
    private String status;

    public Task(String taskKey, String description, String priority, String date, String status) {
        this.taskKey = taskKey;
        this.description = description;
        this.priority = priority;
        this.date = date;
        this.status = status;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
