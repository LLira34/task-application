package net.llira.task_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class NewTaskActivity extends AppCompatActivity {
    private MaterialBetterSpinner spnPriorities, spnStatus;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        //Inflate
        btnSave = findViewById(R.id.btn_save);
        spnPriorities = findViewById(R.id.spn_priorities);
        spnStatus = findViewById(R.id.spn_status);

        //Combo
        ArrayAdapter<CharSequence> arrayPriority = ArrayAdapter.createFromResource(this,
                R.array.cmbPriorities, android.R.layout.simple_dropdown_item_1line);
        spnPriorities.setAdapter(arrayPriority);

        ArrayAdapter<CharSequence> arrayStatus = ArrayAdapter.createFromResource(this,
                R.array.cmbStatus, android.R.layout.simple_dropdown_item_1line);
        spnStatus.setAdapter(arrayStatus);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_LONG).show();
            }
        });
    }
}//End class
