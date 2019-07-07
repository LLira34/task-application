package net.llira.task_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.llira.task_app.dao.Connection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnContinue, btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inflate
        btnContinue = findViewById(R.id.btn_continue);
        btnStart = findViewById(R.id.btn_start);

        // Register listenner
        btnContinue.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_start) {
            try {
                Connection conn = new Connection(getApplication());
                conn.startDb();
                Toast.makeText(getApplicationContext(), "DB Starting...", Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error to init db: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.btn_continue) {
            Intent iHome = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(iHome);
        }
    }

}//End class
