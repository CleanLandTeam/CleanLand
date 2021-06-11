package com.example.cleanland.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cleanland.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button goHome = MainActivity.this.findViewById(R.id.button2);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//            TaskTable newTaskTable = new TaskTable(taskTitleTV.getText().toString(), taskDescriptionTV.getText().toString(), statusAddTask.getText().toString());
//            database.taskDao().saveTask(newTaskTable);
                Intent goToMainActivity = new Intent(MainActivity.this, AddOrder.class);
                MainActivity.this.startActivity(goToMainActivity);
            }
        });    }
}