package net.llira.task_app;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.llira.task_app.adapter.TaskAdapter;
import net.llira.task_app.models.Task;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rcvTasks;
    private TaskAdapter adapter;
    private GridLayoutManager glm;
    private FloatingActionButton fabNew;
    private Button btnDelete, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Inflate
        rcvTasks = findViewById(R.id.rcv_tasks);
        glm = new GridLayoutManager(this, 1);
        rcvTasks.setLayoutManager(glm);
        adapter = new TaskAdapter(dataSet());
        rcvTasks.setAdapter(adapter);

        fabNew = findViewById(R.id.fab_new);
        fabNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Fab here!", Toast.LENGTH_LONG).show();
                Intent iNew = new Intent(getApplicationContext(), NewTaskActivity.class);
                startActivity(iNew);
            }
        });
    }

    private ArrayList<Task> dataSet(){
        ArrayList<Task> data = new ArrayList<>();
        data.add(new Task("TK002", "tengo que desayunar", "Normal", "10/06/2019", "Pendiente"));
        data.add(new Task("TK003", "tengo que programar", "Importante", "10/06/2019", "Concluido"));
        data.add(new Task("TK004", "tomar agua", "Urgente", "10/06/2019", "Pendiente"));
        data.add(new Task("TK005", "tengo que desayunar", "Normal", "10/06/2019", "Pendiente"));
        data.add(new Task("TK006", "tengo que desayunar", "Normal", "10/06/2019", "Pendiente"));
        return data;
    }
}
