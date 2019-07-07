package net.llira.task_app.dao;

import android.content.Context;

import net.llira.task_app.models.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskDAO {
    private Context context;

    public TaskDAO(Context context) {
        this.context = context;
    }

    public void insert(Task obj) throws Exception {
        String command = "INSERT INTO tasks (taskKey, description, priority, date, status) " +
                "VALUES " +
                "('" + obj.getTaskKey() + "', '" + obj.getDescription() + "', " +
                "'" + obj.getPriority() + "', '" + obj.getDate() + "', '" + obj.getStatus() + "')";
        Connection conn = new Connection(context);
        try {
            conn.executeSentence(command);
        } catch (Exception e) {
            throw new Exception("Error al insertar: " + e.getMessage());
        }
    }

    public void update(Task obj) throws Exception {
        String command = "UPDATE tasks SET " +
                "taskKey= '" + obj.getTaskKey() + "', " +
                "description= '" + obj.getDescription() + "', " +
                "priority= '" + obj.getPriority() + "'," +
                "date= '" + obj.getDate() + "' " +
                "status= '" + obj.getStatus() + "', " +
                "WHERE taskKey='" + obj.getTaskKey() + "'";
        Connection conn = new Connection(context);
        try {
            conn.executeSentence(command);
        } catch (Exception e) {
            throw new Exception("Error al editar: " + e.getMessage());
        }
    }

    public void delete(Task obj) throws Exception {
        String command = "DELETE FROM tasks WHERE taskKey = '" + obj.getTaskKey() + "'";
        Connection conn = new Connection(context);
        try {
            conn.executeSentence(command);
        } catch (Exception e) {
            throw new Exception("Error al eliminar: " + e.getMessage());
        }
    }

    public List<Task> getAll() throws Exception {
        String table = "Tasks";
        String fields[] = new String[]{"taskKey", "description", "priority", "date", "status"};
        List<Task> listTasks = new ArrayList<Task>();
        Connection conn = new Connection(context);
        List<HashMap<String, String>> result = conn.execQuery(table, fields, null);
        Task task;
        for (HashMap<String, String> reg : result) {
            task = new Task();
            task.setTaskKey(reg.get("taskKey"));
            task.setDescription(reg.get("description"));
            task.setPriority(reg.get("priority"));
            task.setDate(reg.get("date"));
            task.setStatus(reg.get("status"));
            listTasks.add(task);
        }
        return listTasks;
    }

    public Task getById(Task obj) throws Exception {
        String table = "Tasks";
        String fields[] = new String[]{"taskKey", "description", "priority", "date", "status"};
        String condition = "taskKey= '" + obj.getTaskKey() + "'";
        Connection conn = new Connection(context);
        List<HashMap<String, String>> result = conn.execQuery(table, fields, condition);
        Task task = null;
        for (HashMap<String, String> reg : result) {
            task = new Task();
            task.setTaskKey(reg.get("taskKey"));
            task.setDescription(reg.get("description"));
            task.setPriority(reg.get("priority"));
            task.setDate(reg.get("date"));
            task.setStatus(reg.get("status"));
        }
        return task;
    }

}//End class
